package com.jdutton.meep.poller.service;

import com.jdutton.meep.poller.model.Resource;

import java.util.List;
import java.util.Set;

public interface ResourceComparatorService {
    List<Resource> getDifferences(Set<Resource> origResourcesSet, Set<Resource> newResourcesSet);
    List<Resource> getNewAvailableResources(Set<Resource> origResourcesSet, Set<Resource> newResourcesSet);
}
