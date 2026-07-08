package org.cognizant.springlearn.controller;

import org.cognizant.springlearn.Country;
import org.cognizant.springlearn.service.CountryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {
    private ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
    @RequestMapping("/countries")
    public List<Country> getAllCountries() {
        return new ArrayList<>(context.getBeansOfType(Country.class).values());
    }

    @GetMapping("/country/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        return CountryService.getCountry(code);
    }
}
