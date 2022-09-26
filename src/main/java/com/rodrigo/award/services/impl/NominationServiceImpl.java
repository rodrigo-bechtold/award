package com.rodrigo.award.services.impl;

import com.rodrigo.award.models.NominationModel;
import com.rodrigo.award.repositories.NominationRepository;
import com.rodrigo.award.services.NominationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NominationServiceImpl implements NominationService {

    private final NominationRepository nominationRepository;

    public NominationServiceImpl(NominationRepository nominationRepository){
        this.nominationRepository = nominationRepository;
    }

    @Transactional
    @Override
    public List<? extends NominationModel> saveAll(List<? extends NominationModel> nominationModel) {
        return nominationRepository.saveAll(nominationModel);
    }
}
