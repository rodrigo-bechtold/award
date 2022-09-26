package com.rodrigo.award.repositories;

import com.rodrigo.award.models.StudioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudioRepository extends JpaRepository<StudioModel, UUID> {

    Optional<StudioModel> findByName(String name);

}
