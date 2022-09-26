package com.rodrigo.award.services.impl;

import com.rodrigo.award.dtos.NominationDTO;
import com.rodrigo.award.models.ProducerModel;
import com.rodrigo.award.repositories.ProducerRepository;
import com.rodrigo.award.services.ProducerService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProducerServiceImpl implements ProducerService {

    private ProducerRepository producerRepository;

    public ProducerServiceImpl(ProducerRepository producerRepository){
        this.producerRepository = producerRepository;
    }

    @Override
    public Set<ProducerModel> transformProducers(NominationDTO item) {
        String[] producers = item.getProducers().replace(" and ", ", ").split(",");
        Set<ProducerModel> producersModel = new HashSet<>();
        for (String producerName : producers) {
            String producerNameTrimmed = producerName.trim();
            if (producerNameTrimmed.isEmpty()) continue;
            ProducerModel producerModel = producerRepository.findByName(producerNameTrimmed).orElseGet(() -> producerRepository.save(new ProducerModel(producerNameTrimmed)));
            producersModel.add(producerModel);
        }
        return producersModel;
    }
}
