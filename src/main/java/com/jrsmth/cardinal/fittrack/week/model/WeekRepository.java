package com.jrsmth.cardinal.fittrack.week.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="weeks")
public interface WeekRepository extends JpaRepository<Week, Long> {

}
