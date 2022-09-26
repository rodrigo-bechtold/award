package com.rodrigo.award.repositories;

import com.rodrigo.award.models.NominationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NominationRepository extends JpaRepository<NominationModel, UUID> {
}
