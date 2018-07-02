package com.openweatherproject.openweatherproject.entity.storage;

public enum ForeCastWeatherURL {
    BY_CITY_NAME("https://api.openweathermap.org/data/2.5/weather?q={CITY_NAME}&appid={ID}"),
    BY_ZIP_CODE("https://api.openweathermap.org/data/2.5/weather?q={CITY_NAME},{ID}&appid={ID}");

    private final String URL;

    ForeCastWeatherURL(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }}
