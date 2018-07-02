package com.openweatherproject.openweatherproject.service;

import com.openweatherproject.openweatherproject.entity.WeatherData;

import java.io.IOException;

public interface WeatherService {

    WeatherData getWeatherByCityName(String cityName) throws IOException;

    WeatherData getWeatherByZIPCode(String zipCode) throws IOException;
}
