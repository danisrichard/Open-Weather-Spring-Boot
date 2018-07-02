package com.openweatherproject.openweatherproject.service;

import com.openweatherproject.openweatherproject.entity.Weather;

import java.io.IOException;

public interface WeatherService {

    Weather getWeatherByCityName(String cityName) throws IOException;

    Weather getWeatherByZIPCode(int zipCode) throws IOException;
}
