package com.openweatherproject.openweatherproject.service.impl;

import com.openweatherproject.openweatherproject.entity.WeatherData;
import com.openweatherproject.openweatherproject.service.WeatherService;
import com.openweatherproject.openweatherproject.utils.WeatherCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ForeCastWeatherImpl implements WeatherService {

     @Autowired
     private WeatherCreator weatherCreator;

    @Override
    @Cacheable("forecast_cityname")
    public WeatherData getWeatherByCityName(String cityName) throws IOException {
        return null;
    }

    @Override
    @Cacheable("forecast_zipcode")
    public WeatherData getWeatherByZIPCode(String zipCode) throws IOException {
        return null;
    }
}
