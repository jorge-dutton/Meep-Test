package com.jdutton.meep.poller.converters;

import com.jdutton.meep.poller.data.ResourceEntity;
import com.jdutton.meep.poller.model.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ResourceEntityToResourceConverterTest {
    private ResourceEntityToResourceConverter resourceEntityToResourceConverter;
    private ResourceEntity resourceEntity;

    @BeforeEach
    public void startUp() {
        this.resourceEntityToResourceConverter = new ResourceEntityToResourceConverter();
        this.resourceEntity = new ResourceEntity("PT-LIS-A00043",
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
        Resource resource = this.resourceEntityToResourceConverter.convert(this.resourceEntity);
        assertEquals(resource.getId(), this.resourceEntity.getId());
        assertEquals(resource.getName(), this.resourceEntity.getName());
        assertEquals(resource.getLicencePlate(), this.resourceEntity.getLicencePlate());
        assertEquals(resource.isRealtimeData(), this.resourceEntity.isRealtimeData());
        assertEquals(resource.getResourceImageId(), this.resourceEntity.getResourceImageId());
        assertEquals(resource.getResourceType(), this.resourceEntity.getResourceType());
        assertEquals(resource.getRange(), this.resourceEntity.getRange());
        assertEquals(resource.getBatteryLevel(), this.resourceEntity.getBatteryLevel());
        assertEquals(resource.getCompanyZoneId(), this.resourceEntity.getCompanyZoneId());
        assertEquals(resource.getX(), this.resourceEntity.getX());
        assertEquals(resource.getY(), this.resourceEntity.getY());
        assertEquals(resource.getHelmets(), this.resourceEntity.getHelmets());
        assertEquals(resource.getModel(), this.resourceEntity.getModel());
    }
}
