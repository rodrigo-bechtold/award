package com.rodrigo.award.services;

import com.rodrigo.award.models.NominationModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NominationService {

    List<? extends NominationModel> saveAll(List<? extends NominationModel> nominationModel);
}
