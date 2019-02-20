package com.cvt.limitsservice.controller;

import com.cvt.limitsservice.bean.LimitConfiguration;
import com.cvt.limitsservice.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {

    @Autowired
    Configuration configuration;

    @GetMapping("/limit-config")
    public LimitConfiguration retriveLimitFromConfig(){
        return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
    }

}
