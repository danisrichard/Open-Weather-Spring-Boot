package com.openweatherproject.openweatherproject.contoller;

import com.openweatherproject.openweatherproject.service.WeatherService;
import com.openweatherproject.openweatherproject.service.impl.CurrentWeatherImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CurrentWeatherPageController {

    @Autowired
    private WeatherService weatherService =  new CurrentWeatherImpl();

    @GetMapping("/index")
    public String weatherByCityName() throws IOException {
        weatherService.getWeatherByCityName("Szeged");
        return "1";
    }

    @GetMapping("/weather-index/{zipcode}")
    public String weatherByZIPCode(@RequestParam("cipcode") int zipcode) throws IOException {
        weatherService.getWeatherByCityName("Szeged");
        return "1";
    }

    @GetMapping("/index2")
    public String weatherByCityId() throws IOException {
        return "1";
    }

}
