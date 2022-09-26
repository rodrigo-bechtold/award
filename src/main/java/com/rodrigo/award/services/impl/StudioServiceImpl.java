package com.rodrigo.award.services.impl;

import com.rodrigo.award.dtos.NominationDTO;
import com.rodrigo.award.models.StudioModel;
import com.rodrigo.award.repositories.StudioRepository;
import com.rodrigo.award.services.StudioService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudioServiceImpl implements StudioService {

    private StudioRepository studioRepository;

    public StudioServiceImpl(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    @Override
    public Set<StudioModel> transformStudios(NominationDTO item) {
        String[] studios = item.getStudios().replace(" and ", ", ").split(",");
        Set<StudioModel> studiosModel = new HashSet<>();
        for (String studioName : studios) {
            String studioNameTrimmed = studioName.trim();
            if (studioNameTrimmed.isEmpty()) continue;
            StudioModel studioModel = studioRepository.findByName(studioNameTrimmed).orElseGet(() -> studioRepository.save(new StudioModel(studioNameTrimmed)));
            studiosModel.add(studioModel);
        }
        return studiosModel;
    }
}
