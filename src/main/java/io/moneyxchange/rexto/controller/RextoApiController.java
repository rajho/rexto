package io.moneyxchange.rexto.controller;

import io.moneyxchange.rexto.model.dao.FxRate;
import io.moneyxchange.rexto.model.dto.ConvertDTO;
import io.moneyxchange.rexto.model.dto.FxRateDTO;
import io.moneyxchange.rexto.repository.FxRateRepository;
import io.moneyxchange.rexto.util.BadDataException;
import io.moneyxchange.rexto.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/latest")
public class RextoApiController {

    @Autowired
    FxRateRepository fxRateRepository;

    @GetMapping("/convert")
    public ResponseEntity<ConvertDTO> convert(@RequestParam String q){
        String sourceCurrency, targetCurrency;
        HttpHeaders headers = new HttpHeaders();
        ConvertDTO convertDTOResponse = ConvertDTO.createNewInstance();

        try{
            if (q == null){
                throw new BadDataException("Currencies not sent, or sent with a wrong format!");
            }

            String[] currencies = q.split("_", 2);

            if (currencies.length == 2) {
                sourceCurrency = currencies[0];
                targetCurrency = currencies[1];
            } else {
                throw new BadDataException("ErrSource and target currencies are required. Looks like only 1 or none were sent.");
            }

            Utils.validateExchangeRate(sourceCurrency, targetCurrency);

            List<FxRate> fxRates= fxRateRepository.findBySourceCurrencyEqualsAndTargetCurrencyEquals(sourceCurrency, targetCurrency);
            FxRateDTO fxRateResult = fxRates.get(0).toFxRateDTO();

            convertDTOResponse.setResults(fxRateResult);
        } catch (BadDataException e) {
            convertDTOResponse.setError(e.getMessage());
            return new ResponseEntity<>(convertDTOResponse, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return new ResponseEntity<>(convertDTOResponse, headers, HttpStatus.OK);
    }

}
