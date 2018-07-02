package com.openweatherproject.openweatherproject.service.impl;

import com.openweatherproject.openweatherproject.entity.Weather;
import com.openweatherproject.openweatherproject.service.WeatherService;
import com.openweatherproject.openweatherproject.utils.WeatherCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import java.io.IOException;

public class ForeCastWeatherImpl implements WeatherService {

     @Autowired
     private WeatherCreator weatherCreator;

    @Override
    @Cacheable("forecast_cityname")
    public Weather getWeatherByCityName(String cityName) throws IOException {
        return null;
    }

    @Override
    @Cacheable("forecast_zipcode")
    public Weather getWeatherByZIPCode(String zipCode) throws IOException {
        return null;
    }
}
