package com.jdutton.meep.poller.service.impl;

import com.google.common.collect.Sets;
import com.jdutton.meep.poller.model.Resource;
import com.jdutton.meep.poller.service.ResourceEndpointConnectionService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ResourceEndpointConnectionServiceImpl implements ResourceEndpointConnectionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceEndpointConnectionServiceImpl.class);

    @Value("${resource.service.url}")
    private String resourceServiceUrl;

    @Value("${lower.left.lat.lon}")
    private String lowerLeftLatLon;

    @Value("${upper.right.lat.lon}")
    private String upperRightLatLon;

    @Value("${company.zone.ids}")
    private String companyZoneIds;

    @Override
    @HystrixCommand(fallbackMethod = "returnEmptyResourceSet")
    public Set<Resource> getResourcesFromRestService() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(getMessageConverters());

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Resource[]> response = restTemplate.exchange(this.resourceServiceUrl, HttpMethod.GET, entity, Resource[].class, this.lowerLeftLatLon, this.upperRightLatLon, this.companyZoneIds);
        Resource[] resources = response.getBody();

        return Sets.newHashSet(resources);
    }

    private Set<Resource> returnEmptyResourceSet() {
        LOGGER.error("Couldn't contact to resources REST endpoint!");
        return new HashSet<>();
    }

    private List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new MappingJackson2HttpMessageConverter());
        return converters;
    }
}
