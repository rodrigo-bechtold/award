package com.rodrigo.award.services;

import com.rodrigo.award.dtos.NominationDTO;
import com.rodrigo.award.models.ProducerModel;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface ProducerService {

    public Set<ProducerModel> transformProducers(NominationDTO item);
}
