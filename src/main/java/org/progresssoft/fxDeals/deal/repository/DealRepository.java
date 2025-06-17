package org.progresssoft.fxDeals.deal.repository;

import org.progresssoft.fxDeals.deal.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends JpaRepository<Deal, Integer> {
}
