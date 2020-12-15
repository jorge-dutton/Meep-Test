package com.jdutton.meep.poller.converters;

import com.jdutton.meep.poller.data.ResourceEntity;
import com.jdutton.meep.poller.model.Resource;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class ResourceToResourceEntityConverter {
    public ResourceEntity convert(final Resource resource) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(resource, ResourceEntity.class);
    }

}
