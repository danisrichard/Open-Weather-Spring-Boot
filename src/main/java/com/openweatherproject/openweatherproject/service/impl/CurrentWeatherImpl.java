package com.openweatherproject.openweatherproject.service.impl;

import com.openweatherproject.openweatherproject.entity.Weather;
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
    @Cacheable("weather_city")
    public Weather getWeatherByCityName(String cityName) throws IOException {
        Weather weather = weatherCreator.createWeatherFromURL(cityName);

        logger.info(weather.toString());

        return null;
    }

    @Override
    public Weather getWeatherByZIPCode(int zipCode) throws IOException {
        return null;
    }
}
