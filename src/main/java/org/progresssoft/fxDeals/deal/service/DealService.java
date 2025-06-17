package org.progresssoft.fxDeals.deal.service;

import org.progresssoft.fxDeals.deal.dto.request.DealCreateDTO;
import org.progresssoft.fxDeals.deal.dto.resonse.DealResponseDTO;

public interface DealService {
    DealResponseDTO save(DealCreateDTO dto);
}
