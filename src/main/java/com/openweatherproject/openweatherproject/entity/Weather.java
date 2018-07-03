package com.openweatherproject.openweatherproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.openweatherproject.openweatherproject.utils.WeatherCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable {

    private static final Logger logger = LogManager.getLogger(Weather.class);

    @JsonProperty("name")
    private String cityName;
    @JsonProperty("weather")
    private MainData mainData;
    private WindData windData;

    public Weather() {
    }

    public MainData getMainData() {
        return mainData;
    }

    public void setMainData(String[] mainValues) {
        Arrays.stream(mainValues).forEach(logger::info);
        HashMap<String,String> mainDatas = new HashMap<>();

    }

    public WindData getWindData() {
        return windData;
    }

    public void setWindData(WindData windData) {
        this.windData = windData;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
