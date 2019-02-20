package com.cvt.currencyconversionservice.proxy;

import com.cvt.currencyconversionservice.conversion.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Feign proxy of the services is created to call the microservices

//@FeignClient(name ="currency-exchange-service" ,url ="localhost:8000" )
//@FeignClient(name ="currency-exchange-service")
@RibbonClient(name ="currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
public interface CurrencyExchangeServiceProxy {

   // @GetMapping("/currency-exchange/from/{from}/to/{to}")
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean currencyExchangeFromTo(
            @PathVariable(value = "from") String from,
            @PathVariable(value = "to") String to
    );

}
