package com.jdutton.meep.poller.service;

import com.jdutton.meep.poller.model.Resource;

import java.util.Set;

public interface ResourceEndpointConnectionService {
    Set<Resource> getResourcesFromRestService();
}
