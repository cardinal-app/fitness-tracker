package com.jrsmth.cardinal.fittrack.week;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin({"http://localhost:4200", "http://localhost:3000"})
@RepositoryRestResource(path="weeks")
public interface WeekRepository extends JpaRepository<Week, Long> {

}
