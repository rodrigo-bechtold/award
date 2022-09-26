package com.rodrigo.award.batch;

import com.rodrigo.award.models.NominationModel;
import com.rodrigo.award.services.NominationService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NominationDBWriter implements ItemWriter<NominationModel> {

    private NominationService nominationService;

    public NominationDBWriter (NominationService nominationService){
        this.nominationService = nominationService;
    }

    @Override
    public void write(List<? extends NominationModel> items) throws Exception {
        nominationService.saveAll(items);
    }
}
