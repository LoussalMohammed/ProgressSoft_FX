package org.progresssoft.fxDeals.deal.mapper.request;

import org.mapstruct.Mapper;
import org.progresssoft.fxDeals.deal.dto.request.DealCreateDTO;
import org.progresssoft.fxDeals.deal.dto.resonse.DealResponseDTO;
import org.progresssoft.fxDeals.deal.entity.Deal;

@Mapper(componentModel = "spring")
public interface DealRequestMapper {
    Deal toEntity(DealCreateDTO dto);

    DealResponseDTO toResponseEntity(Deal deal);
}
