package com.rodrigo.award.services;

import com.rodrigo.award.dtos.NominationDTO;
import com.rodrigo.award.models.StudioModel;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface StudioService {

    public Set<StudioModel> transformStudios(NominationDTO item);
}
