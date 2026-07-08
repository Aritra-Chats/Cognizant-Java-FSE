package org.cognizant.springlearn.service;

import org.cognizant.springlearn.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    static final ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
    public static Country getCountry(@PathVariable String code) {
        return context.getBeansOfType(Country.class).values()
                    .stream().filter(country -> country.getCode().equalsIgnoreCase(code))
                    .findFirst().orElse(null);
    }

}
