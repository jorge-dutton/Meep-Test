package com.jdutton.meep.poller.service;

import com.jdutton.meep.poller.model.Resource;

import java.util.Set;

public interface ResourceRepositoryService {
    Resource findById(String id);
    Set<Resource> retrievePersistedResources();
    void loadResourceEntities(final Set<Resource> resourcesSet);
}
