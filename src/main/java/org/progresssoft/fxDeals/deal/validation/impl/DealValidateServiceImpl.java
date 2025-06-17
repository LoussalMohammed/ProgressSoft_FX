package org.progresssoft.fxDeals.deal.validation.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.progresssoft.fxDeals.deal.repository.DealRepository;
import org.progresssoft.fxDeals.deal.validation.DealValidateService;
import org.progresssoft.fxDeals.shared.exception.DuplicateDealIdException;

@Slf4j
@RequiredArgsConstructor
public class DealValidateServiceImpl implements DealValidateService {
    private DealRepository dealRepository;

    @Override
    public void SaveValidateDuplicated(String id) {
        if (dealRepository.existsById(id)) {
            log.warn("Duplicate deal ID detected: {}. Operation aborted.", id);
            throw new DuplicateDealIdException("Deal id already exists");
        }

    }
}
