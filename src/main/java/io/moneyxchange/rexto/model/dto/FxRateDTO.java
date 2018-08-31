package io.moneyxchange.rexto.model.dto;

import io.moneyxchange.rexto.model.dao.FxRate;
import org.springframework.stereotype.Component;

@Component
public class FxRateDTO {
    private String id;
    private String source;
    private String target;
    private Double exchangeRate;

    public static FxRateDTO createNewInstance(){
        return new FxRateDTO();
    }

    public FxRateDTO() {
    }

    public FxRateDTO toFxRateDTO(FxRate fxRate) {
        this.setId(fxRate.getId());
        this.setSource(fxRate.getSourceCurrency());
        this.setTarget(fxRate.getTargetCurrency());
        this.setExchangeRate(fxRate.getExchangeRate());

        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
