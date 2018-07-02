package com.openweatherproject.openweatherproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData implements Serializable {

    private String name;
    private HashMap<String,Object> main;
    private HashMap<String,Object> rain;
    private Object[] weather;

    public WeatherData() {
    }

    public HashMap<String, Object> getRain() {
        return rain;
    }

    public void setRain(HashMap<String, Object> rain) {
        this.rain = rain;
    }

    public Object[] getWeather() {
        return weather;
    }

    public void setWeather(Object[] weather) {
        this.weather = weather;
    }

    public void setMain(HashMap<String, Object> main) {
        this.main = main;
    }

    public HashMap<String, Object> getMain() {
        return main;
    }

    public void setMain(String key,Object value) {
        this.main.put(key,value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
