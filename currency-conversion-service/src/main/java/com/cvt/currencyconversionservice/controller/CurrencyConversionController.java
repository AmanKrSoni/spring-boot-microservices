package com.cvt.currencyconversionservice.controller;

import com.cvt.currencyconversionservice.conversion.CurrencyConversionBean;
import com.cvt.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {


    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Autowired
    CurrencyExchangeServiceProxy proxy;

    @Autowired
    Environment environment;


    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean currencyConversionBean(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
    ){
        int port=Integer.parseInt(environment.getProperty("local.server.port"));

        //feign problem-1
        Map<String,String> map=new HashMap<>();
        map.put("from",from);
        map.put("to",to);
        // Now CurrencyConversion is talking to the CurrencyExchange Service
        ResponseEntity<CurrencyConversionBean> responseEntity =new RestTemplate()
                .getForEntity(
                        "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                        CurrencyConversionBean.class,
                        map
                        );
        CurrencyConversionBean bean=responseEntity.getBody();
        return new CurrencyConversionBean(
                bean.getId(),from,to,bean.getConversionMultiple(),
                quantity,quantity.multiply(bean.getConversionMultiple()),bean.getPort());

    }

    //Feign Method
    @GetMapping("/feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean currencyConversionBeanFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
             ){
        int port=Integer.parseInt(environment.getProperty("local.server.port"));

        CurrencyConversionBean bean=proxy.currencyExchangeFromTo(from,to);
     CurrencyConversionBean result= new CurrencyConversionBean(
                bean.getId(),from,to,bean.getConversionMultiple(),
                quantity,quantity.multiply(bean.getConversionMultiple()),bean.getPort());

     logger.info("{}",result);
     return result;

    }
}
