package com.jdutton.meep.poller.service.impl;

import com.google.common.collect.Sets;
import com.jdutton.meep.poller.converters.ResourceEntityToResourceConverter;
import com.jdutton.meep.poller.converters.ResourceToResourceEntityConverter;
import com.jdutton.meep.poller.data.ResourceEntity;
import com.jdutton.meep.poller.model.Resource;
import com.jdutton.meep.poller.repository.ResourceRepository;
import com.jdutton.meep.poller.service.ResourceRepositoryService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ResourceRepositoryServiceImpl implements ResourceRepositoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceRepositoryServiceImpl.class);

    private ResourceRepository resourceRepository;
    private ResourceEntityToResourceConverter resourceEntityToResourceConverter;
    private ResourceToResourceEntityConverter resourceToResourceEntityConverter;

    public ResourceRepositoryServiceImpl(final ResourceRepository resourceRepository,
                                         final ResourceEntityToResourceConverter resourceEntityToResourceConverter,
                                         final ResourceToResourceEntityConverter resourceToResourceEntityConverter) {
        super();
        this.resourceRepository = resourceRepository;
        this.resourceEntityToResourceConverter = resourceEntityToResourceConverter;
        this.resourceToResourceEntityConverter = resourceToResourceEntityConverter;
    }

    @Override
    public Resource findById(String id) {
        return this.resourceEntityToResourceConverter.convert(this.resourceRepository.findById(id).orElse(new ResourceEntity()));
    }


    @Override
    public Set<Resource> retrievePersistedResources() {
        Set<Resource> resourceSet = new HashSet<>();

        Sets.newHashSet(this.resourceRepository.findAll())
                .stream()
                .forEach(resourceEntity -> resourceSet.add(this.resourceEntityToResourceConverter.convert(resourceEntity)));

        return resourceSet;
    }



    @Override
    public void loadResourceEntities(final Set<Resource> resourcesSet) {
        Set<ResourceEntity> resourceEntitySet = new HashSet<>();

        resourcesSet.stream()
                .forEach(resource -> resourceEntitySet.add(this.resourceToResourceEntityConverter.convert(resource)));
        this.resourceRepository.deleteAll();
        this.resourceRepository.saveAll(resourceEntitySet);
    }

}
