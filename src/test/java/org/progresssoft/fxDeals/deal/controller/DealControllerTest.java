package org.progresssoft.fxDeals.deal.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.progresssoft.fxDeals.deal.dto.request.DealCreateDTO;
import org.progresssoft.fxDeals.deal.dto.resonse.DealResponseDTO;
import org.progresssoft.fxDeals.deal.service.DealService;
import org.progresssoft.fxDeals.shared.exception.DuplicateDealIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
class DealControllerTest {
    @Mock
    private DealService dealService;

    @InjectMocks
    private DealController underTest;

    private DealCreateDTO dealRequestDto;
    private DealResponseDTO dealResponseDto;

    @BeforeEach
    void setup() {
        dealRequestDto = new DealCreateDTO("deal123",
                Currency.getInstance("MAD"),
                Currency.getInstance("USD"),
                LocalDateTime.now(),
                BigDecimal.valueOf(2000)
        );

        dealResponseDto = new DealResponseDTO("deal123",
                Currency.getInstance("MAD"),
                Currency.getInstance("USD"),
                dealRequestDto.timestamp(),
                dealRequestDto.amount());
    }

    @Test
    void givenValidRequest_whenSave_thenReturnCreatedResponse() {
        given(dealService.save(dealRequestDto)).willReturn(dealResponseDto);

        ResponseEntity<DealResponseDTO> actual = underTest.save(dealRequestDto);

        assertThat(actual).isNotNull();
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(actual.getBody()).isEqualTo(dealResponseDto);
        verify(dealService).save(dealRequestDto);
    }

    @Test
    void givenDuplicateDealId_whenSave_thenThrowDuplicateDealIdException() {
        given(dealService.save(any(DealCreateDTO.class)))
                .willThrow(new DuplicateDealIdException("Deal id already exists"));

        assertThatExceptionOfType(DuplicateDealIdException.class)
                .isThrownBy(() -> underTest.save(dealRequestDto))
                .withMessage("Deal id already exists");

        verify(dealService).save(dealRequestDto);
    }
}