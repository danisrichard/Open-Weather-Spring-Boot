package com.openweatherproject.openweatherproject.entity.storage;

public enum CurrentWeatherURL {
    BY_CITY_NAME("https://api.openweathermap.org/data/2.5/weather?q={CITY_NAME}&appid={ID}"),
    BY_CITY_NAME_AND_ID("https://api.openweathermap.org/data/2.5/weather?q={CITY_NAME},{ID}&appid={ID}");

    private final String URL;

    CurrentWeatherURL(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }
}
