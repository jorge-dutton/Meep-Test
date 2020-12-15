package com.jdutton.meep.poller.service.impl;

import com.google.common.collect.Sets;
import com.jdutton.meep.poller.model.Resource;
import com.jdutton.meep.poller.service.ResourceComparatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(JUnitPlatform.class)
public class ResourcesComparatorServiceTest {

    private Set<Resource> testResourceSet;

    private ResourceComparatorService resourceComparatorService;

    @BeforeEach
    public void startUp() {
        resourceComparatorService = new ResourceComparatorServiceImpl();

        testResourceSet = new HashSet<>();
        testResourceSet.add(new Resource("PT-LIS-A00040",
                "82VI72",
                -9.03312,
                38.891,
                "82VI72",
                58,
                77,
                2,
                "Askoll",
                "vehicle_gen_ecooltra",
                true,
                "MOPED",
                473));
        testResourceSet.add(new Resource("PT-LIS-A00041",
                "82VI72",
                -9.03312,
                38.891,
                "82VI72",
                58,
                77,
                2,
                "Askoll",
                "vehicle_gen_ecooltra",
                true,
                "MOPED",
                473));
        testResourceSet.add(new Resource("PT-LIS-A00042",
                "82VI72",
                -9.03312,
                38.891,
                "82VI72",
                58,
                77,
                2,
                "Askoll",
                "vehicle_gen_ecooltra",
                true,
                "MOPED",
                473));
        testResourceSet.add(new Resource("PT-LIS-A00043",
                "82VI72",
                -9.03312,
                38.891,
                "82VI72",
                58,
                77,
                2,
                "Askoll",
                "vehicle_gen_ecooltra",
                true,
                "MOPED",
                473));

    }

    @Test
    public void shouldFindNoDifferences() {
        Set<Resource> newTestResourceSet = new HashSet<>(testResourceSet);
        assertEquals(0, resourceComparatorService.getDifferences(testResourceSet, newTestResourceSet).size());
    }

    @Test
    public void shouldFindDifferentResource() {
        Resource differentResource = new Resource("PT-LIS-A00040",
                "different",
                -9.03312,
                38.891,
                "82VI72",
                58,
                77,
                2,
                "Askoll",
                "vehicle_gen_ecooltra",
                true,
                "MOPED",
                473);

        Set<Resource> newTestResourceSet = new HashSet<>();
        newTestResourceSet.add(new Resource("PT-LIS-A00041",
                "82VI72",
                -9.03312,
                38.891,
                "82VI72",
                58,
                77,
                2,
                "Askoll",
                "vehicle_gen_ecooltra",
                true,
                "MOPED",
                473));
        newTestResourceSet.add(new Resource("PT-LIS-A00042",
                "82VI72",
                -9.03312,
                38.891,
                "82VI72",
                58,
                77,
                2,
                "Askoll",
                "vehicle_gen_ecooltra",
                true,
                "MOPED",
                473));
        newTestResourceSet.add(new Resource("PT-LIS-A00043",
                "82VI72",
                -9.03312,
                38.891,
                "82VI72",
                58,
                77,
                2,
                "Askoll",
                "vehicle_gen_ecooltra",
                true,
                "MOPED",
                473));
        newTestResourceSet.add(differentResource);

        List<Resource> differencesList = resourceComparatorService.getDifferences(testResourceSet, newTestResourceSet);

        assertEquals(1, differencesList.size());
        assertEquals("PT-LIS-A00040", differencesList.get(0).getId());


    }

    @Test
    public void shouldFindDeletedResource() {
        Set<Resource> newTestResourceSet = testResourceSet.stream()
                .filter(resource -> !"PT-LIS-A00042".equals(resource.getId()))
                .collect(Collectors.toSet());

        List<Resource> differencesList = resourceComparatorService.getDifferences(testResourceSet, newTestResourceSet);

        assertEquals(1, differencesList.size());
        assertEquals("PT-LIS-A00042", differencesList.get(0).getId());
    }

    @Test
    public void shouldFindAddedResource() {
        Set<Resource> newTestResourceSet = new HashSet<>(testResourceSet);
        newTestResourceSet.add(new Resource("PT-LIS-A00044",
                "added",
                -9.03312,
                38.891,
                "82VI72",
                58,
                77,
                2,
                "Askoll",
                "vehicle_gen_ecooltra",
                true,
                "MOPED",
                473));

        List<Resource> differencesList = resourceComparatorService.getDifferences(testResourceSet, newTestResourceSet);

        assertEquals(1, differencesList.size());
        assertEquals("PT-LIS-A00044", differencesList.get(0).getId());
    }
}
