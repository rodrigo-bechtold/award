package com.rodrigo.award.batch;

import com.rodrigo.award.dtos.NominationDTO;
import com.rodrigo.award.models.NominationModel;
import com.rodrigo.award.services.ProducerService;
import com.rodrigo.award.services.StudioService;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class NominationProcessor implements ItemProcessor<NominationDTO, NominationModel> {

    private ProducerService producerService;

    private StudioService studioService;

    public NominationProcessor(ProducerService producerService, StudioService studioService){
        this.producerService = producerService;
        this.studioService = studioService;
    }

    @Override
    public NominationModel process(NominationDTO item) throws Exception {
        NominationModel nominationModel = new NominationModel();
        nominationModel.setYear(item.getYear());
        nominationModel.setTitle(item.getTitle());
        nominationModel.setWinner(item.getWinner());

        nominationModel.setProducers(producerService.transformProducers(item));
        nominationModel.setStudios(studioService.transformStudios(item));
        return nominationModel;
    }
}
