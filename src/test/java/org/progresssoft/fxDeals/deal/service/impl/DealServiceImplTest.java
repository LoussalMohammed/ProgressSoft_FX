package org.progresssoft.fxDeals.deal.service.impl;

import org.progresssoft.fxDeals.deal.dto.request.DealCreateDTO;
import org.progresssoft.fxDeals.deal.dto.resonse.DealResponseDTO;
import org.progresssoft.fxDeals.deal.entity.Deal;
import org.progresssoft.fxDeals.deal.mapper.request.DealRequestMapper;
import org.progresssoft.fxDeals.deal.repository.DealRepository;
import org.progresssoft.fxDeals.deal.service.DealService;
import org.progresssoft.fxDeals.deal.validation.DealValidateService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.progresssoft.fxDeals.shared.exception.DuplicateDealIdException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class DealServiceImplTest {
    @Mock
    private DealRepository dealRepository;
    @Mock
    private DealRequestMapper dealMapper;

    private DealService underTest;

    @Mock
    private DealValidateService dealValidateService;

    private DealCreateDTO dealRequestDto;
    private Deal deal;

    @BeforeEach
    void setup() {
        underTest = new DealServiceImpl(dealRepository, dealMapper, dealValidateService);
        DealCreateDTO dealCreateDTO = new DealCreateDTO("deal123",
                Currency.getInstance("MAD"),
                Currency.getInstance("USD"),
                LocalDateTime.now(),
                BigDecimal.valueOf(2000)
        );

        deal = new Deal(dealRequestDto.id(),
                dealRequestDto.fromCurrency(),
                dealRequestDto.toCurrency(),
                dealRequestDto.timestamp(),
                dealRequestDto.amount());
    }


}