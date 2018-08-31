package io.moneyxchange.rexto.model.dao;

import io.moneyxchange.rexto.model.dto.FxRateDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
public class FxRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name="source_currency")
    private String sourceCurrency;

    @Column(name="target_currency")
    private String targetCurrency;

    @Column(name="exchange_rate")
    private Double exchangeRate;

    @Column(name="valid_from_date")
    private Date validFromDate;

    @Column(name="valid_to_date")
    private Date validToDate;

    public FxRate() {
    }

    public FxRateDTO toFxRateDTO(){
        FxRateDTO fxRateDTO = FxRateDTO.createNewInstance();
        fxRateDTO.setId(this.getId());
        fxRateDTO.setSource(this.getSourceCurrency());
        fxRateDTO.setTarget(this.getTargetCurrency());
        fxRateDTO.setExchangeRate(this.getExchangeRate());

        return fxRateDTO;
    }

    public FxRate(String id, String sourceCurrency, String targetCurrency, Double exchangeRate, Date validFromDate, Date validToDate) {
        this.id = id;
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.exchangeRate = exchangeRate;
        this.validFromDate = validFromDate;
        this.validToDate = validToDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Date getValidFromDate() {
        return validFromDate;
    }

    public void setValidFromDate(Date validFromDate) {
        this.validFromDate = validFromDate;
    }

    public Date getValidToDate() {
        return validToDate;
    }

    public void setValidToDate(Date validToDate) {
        this.validToDate = validToDate;
    }

    @Override
    public String toString() {
        return "FxRate{" +
                "id='" + id +
                ",sourceCurrency=" + sourceCurrency + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", exchangeRate='" + exchangeRate.toString() + '\'' +
                ", validFromDate='" + validFromDate.toString() + '\'' +
                ", validToDate='" + validToDate.toString() + '\'' +
                '}';
    }
}
