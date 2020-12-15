package com.jdutton.meep.poller.service.impl;

import com.google.common.collect.Sets;
import com.jdutton.meep.poller.model.Resource;
import com.jdutton.meep.poller.service.ResourceComparatorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ResourceComparatorServiceImpl implements ResourceComparatorService {
    @Override
    public List<Resource> getDifferences(Set<Resource> origResourcesSet, Set<Resource> newResourcesSet) {
        List<Resource> differencesList;
        if (origResourcesSet.size() != newResourcesSet.size()) {
            differencesList = new ArrayList<>(Sets.symmetricDifference(origResourcesSet, newResourcesSet));
        } else {
            differencesList = new ArrayList<>(Sets.difference(origResourcesSet, newResourcesSet));

        }
        return differencesList;
    }

    @Override
    public List<Resource> getNewAvailableResources(Set<Resource> origResourcesSet, Set<Resource> newResourcesSet) {
        List<Resource> differencesList = new ArrayList<>();
        if (newResourcesSet.size() > origResourcesSet.size()) {
            differencesList = new ArrayList<>(Sets.symmetricDifference(origResourcesSet, newResourcesSet));
        }
        return differencesList;
    }
}
