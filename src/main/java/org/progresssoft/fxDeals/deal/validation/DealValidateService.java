package org.progresssoft.fxDeals.deal.validation;

import org.springframework.stereotype.Service;

@Service
public interface DealValidateService {
    void SaveValidateDuplicated(String id);
}
