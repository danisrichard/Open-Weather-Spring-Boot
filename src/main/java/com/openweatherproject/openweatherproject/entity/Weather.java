package com.openweatherproject.openweatherproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Weather.WeatherBuilder.class)
final public class Weather {
    private String cityName;

    private Weather(WeatherBuilder weatherBuilder) {
        this.cityName = weatherBuilder.cityName;
    }

    public String getCityName() {
        return cityName;
    }

    @JsonPOJOBuilder(buildMethodName = "createWeather", withPrefix = "set")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WeatherBuilder {

        private String cityName;
        private String speed;

        public WeatherBuilder setName(String name){
            this.cityName = name;
            return this;
        }

        public WeatherBuilder setSpeed(String speed){
            this.speed = speed;
            return this;
        }

        public Weather createWeather(){
            return new Weather(this);
        }
    }

    @Override
    public String toString() {
        return "Weather{" +
                "cityName='" + cityName + '\'' +
                '}';
    }
}
