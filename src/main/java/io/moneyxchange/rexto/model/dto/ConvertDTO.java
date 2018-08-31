package io.moneyxchange.rexto.model.dto;

public class ConvertDTO {
    private FxRateDTO results;
    private String error;

    public static ConvertDTO createNewInstance(){
        return new ConvertDTO();
    }

    public FxRateDTO getResults() {
        return results;
    }

    public void setResults(FxRateDTO results) {
        this.results = results;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
