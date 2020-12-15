package com.jdutton.meep.poller.repository;

import com.jdutton.meep.poller.data.ResourceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends CrudRepository<ResourceEntity, String> {

}
