package com.openweatherproject.openweatherproject.service.impl;

import com.openweatherproject.openweatherproject.entity.WeatherData;
import com.openweatherproject.openweatherproject.entity.storage.CurrentWeatherURL;
import com.openweatherproject.openweatherproject.service.WeatherService;
import com.openweatherproject.openweatherproject.utils.WeatherCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CurrentWeatherImpl implements WeatherService {

    private static final Logger logger = LogManager.getLogger(CurrentWeatherImpl.class);

    @Autowired
    private WeatherCreator weatherCreator;

    @Override
    @Cacheable("current_weather_city")
    public WeatherData getWeatherByCityName(String cityName) throws IOException {
        return weatherCreator.createWeatherFromURL(cityName, CurrentWeatherURL.BY_CITY_NAME);
    }

    @Override
    @Cacheable("current_weather_zip")
    public WeatherData getWeatherByZIPCode(String zipCode) throws IOException {
        return weatherCreator.createWeatherFromURL(zipCode, CurrentWeatherURL.BY_CITY_NAME);
    }
}
