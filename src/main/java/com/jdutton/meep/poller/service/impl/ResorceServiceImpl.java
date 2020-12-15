package com.jdutton.meep.poller.service.impl;

import com.jdutton.meep.poller.converters.ResourceEntityToResourceConverter;
import com.jdutton.meep.poller.converters.ResourceToResourceEntityConverter;
import com.jdutton.meep.poller.model.Resource;
import com.jdutton.meep.poller.service.ResourceComparatorService;
import com.jdutton.meep.poller.service.ResourceEndpointConnectionService;
import com.jdutton.meep.poller.service.ResourceRepositoryService;
import com.jdutton.meep.poller.service.ResourceService;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EnableHystrix
@Service
public class ResorceServiceImpl implements ResourceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResorceServiceImpl.class);

    private ResourceEndpointConnectionService resourceEndpointConnectionService;
    private ResourceComparatorService resourceComparatorService;
    private ResourceRepositoryService resourceRepositoryService;

    public ResorceServiceImpl(final ResourceEndpointConnectionService resourceEndpointConnectionService,
                              final ResourceComparatorService resourceComparatorService,
                              final ResourceRepositoryService resourceRepositoryService) {
        super();
        this.resourceEndpointConnectionService = resourceEndpointConnectionService;
        this.resourceComparatorService = resourceComparatorService;
        this.resourceRepositoryService = resourceRepositoryService;
    }

    @Scheduled(fixedRateString = "${resource.process.rate}")
    public void processResources() {

        Set<Resource> restResourceSet = this.resourceEndpointConnectionService.getResourcesFromRestService();
        Set<Resource> persistedResourceSet = this.resourceRepositoryService.retrievePersistedResources();

        List<Resource> addedResources = this.resourceComparatorService.getNewAvailableResources(persistedResourceSet, restResourceSet);

        if (CollectionUtils.isNotEmpty(addedResources)) {
            LOGGER.info("Newly available resources: ");
            addedResources.stream().forEach(resource -> {
                LOGGER.info(resource.toString());
            });
            //TODO meter los recursos nuevos por un stream de eventos para que se puedan consumir de manera reactiva
        }

        this.resourceRepositoryService.loadResourceEntities(restResourceSet);

    }

}
