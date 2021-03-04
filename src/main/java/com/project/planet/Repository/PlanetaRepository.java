package com.project.planet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.planet.Model.Planeta;

@Repository
public interface PlanetaRepository extends JpaRepository<Planeta, Long>{

}
