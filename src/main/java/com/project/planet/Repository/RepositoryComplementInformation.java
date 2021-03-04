package com.project.planet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.planet.Model.ComplementInformation;

@Repository
public interface RepositoryComplementInformation extends JpaRepository<ComplementInformation, Long> {

}
