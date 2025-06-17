package org.progresssoft.fxDeals.deal.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.progresssoft.fxDeals.deal.dto.request.DealCreateDTO;
import org.progresssoft.fxDeals.deal.dto.resonse.DealResponseDTO;
import org.progresssoft.fxDeals.deal.entity.Deal;
import org.progresssoft.fxDeals.deal.mapper.request.DealRequestMapper;
import org.progresssoft.fxDeals.deal.repository.DealRepository;
import org.progresssoft.fxDeals.deal.service.DealService;
import org.progresssoft.fxDeals.deal.validation.DealValidateService;
import org.progresssoft.fxDeals.deal.validation.impl.DealValidateServiceImpl;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class DealServiceImpl implements DealService {
    private final DealRepository dealRepository;
    private final DealRequestMapper dealMapper;
    private final DealValidateService dealValidateService;

    @Override
    public DealResponseDTO save(DealCreateDTO dto) {
        log.info("Attempting to save deal with ID: {}", dto.id());

        dealValidateService.SaveValidateDuplicated(dto.id());

        Deal savedDeal = dealRepository.save(dealMapper.toEntity(dto));
        log.info("Deal saved successfully with ID: {}", savedDeal.getId());

        return dealMapper.toResponseEntity(savedDeal);
    }
}
