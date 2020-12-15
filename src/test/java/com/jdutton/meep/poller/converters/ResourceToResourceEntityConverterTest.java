package com.jdutton.meep.poller.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jdutton.meep.poller.data.ResourceEntity;
import com.jdutton.meep.poller.model.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResourceToResourceEntityConverterTest {

    private ResourceToResourceEntityConverter resourceToResourceEntityConverter;
    private Resource resource;

    @BeforeEach
    public void startUp() {
        this.resourceToResourceEntityConverter = new ResourceToResourceEntityConverter();
        this.resource = new Resource("PT-LIS-A00043",
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
                473);
    }

    @Test
    public void shouldConvertResouceToResourceEntity() {
        ResourceEntity resourceEntity = this.resourceToResourceEntityConverter.convert(this.resource);
        assertEquals(resourceEntity.getId(), this.resource.getId());
        assertEquals(resourceEntity.getName(), this.resource.getName());
        assertEquals(resourceEntity.getLicencePlate(), this.resource.getLicencePlate());
        assertEquals(resourceEntity.isRealtimeData(), this.resource.isRealtimeData());
        assertEquals(resourceEntity.getResourceImageId(), this.resource.getResourceImageId());
        assertEquals(resourceEntity.getResourceType(), this.resource.getResourceType());
        assertEquals(resourceEntity.getRange(), this.resource.getRange());
        assertEquals(resourceEntity.getBatteryLevel(), this.resource.getBatteryLevel());
        assertEquals(resourceEntity.getCompanyZoneId(), this.resource.getCompanyZoneId());
        assertEquals(resourceEntity.getX(), this.resource.getX());
        assertEquals(resourceEntity.getY(), this.resource.getY());
        assertEquals(resourceEntity.getHelmets(), this.resource.getHelmets());
        assertEquals(resourceEntity.getModel(), this.resource.getModel());
    }

}
