package com.vellas.gareebs.dao;

import com.vellas.gareebs.model.Person;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

}