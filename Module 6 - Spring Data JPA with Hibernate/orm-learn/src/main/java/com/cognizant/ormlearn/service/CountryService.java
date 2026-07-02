package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.CountryRepository;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country getCountryByCode(String code) throws CountryNotFoundException {
        return countryRepository.findById(code).orElseThrow(() -> new CountryNotFoundException(code));
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(String code, Country updatedCountry) {
        Country country = countryRepository.findById(code).orElse(null);
        if(country == null)
            countryRepository.save(updatedCountry);
        else {
            country.setCode(updatedCountry.getCode());
            country.setName(updatedCountry.getName());
            countryRepository.save(country);
        }
    }

    @Transactional
    public Country deleteCountry(String code) {
        Country country = countryRepository.findById(code).orElse(null);
        if(country == null)
            return null;
        countryRepository.deleteById(code);
        return country;
    }

    @Transactional
    public List<Country> deleteAllCountries() {
        List<Country> countryList = countryRepository.findAll();
        countryRepository.deleteAll(countryList);
        return countryList;
    }

    @Transactional
    public List<Country> getCountryByName(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name);
    }
}
