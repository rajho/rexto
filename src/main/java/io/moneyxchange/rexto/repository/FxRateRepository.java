package io.moneyxchange.rexto.repository;


import io.moneyxchange.rexto.model.dao.FxRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FxRateRepository extends JpaRepository<FxRate, Integer>{

    List<FxRate> findBySourceCurrencyEqualsAndTargetCurrencyEquals(String sourceCurrency, String targetCurrency);

}
