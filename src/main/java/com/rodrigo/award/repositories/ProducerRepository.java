package com.rodrigo.award.repositories;

import com.rodrigo.award.models.ProducerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProducerRepository extends JpaRepository<ProducerModel, UUID> {

    Optional<ProducerModel> findByName(String name);

}
