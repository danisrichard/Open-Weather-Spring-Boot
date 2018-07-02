package com.openweatherproject.openweatherproject.contoller;

import com.openweatherproject.openweatherproject.entity.WeatherData;
import com.openweatherproject.openweatherproject.service.impl.CurrentWeatherImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class CurrentWeatherPageController {

    @Autowired
    private CurrentWeatherImpl weatherService;

    @RequestMapping(value = "/current-weather/{city}", method = RequestMethod.GET)
    public WeatherData weatherByCityName(@PathVariable("city") String city) throws IOException {
        return weatherService.getWeatherByCityName(city);
    }

    @GetMapping("/weather-index/{zipcode}")
    public String weatherByZIPCode(@RequestParam("zipcode") int zipcode) throws IOException {
        weatherService.getWeatherByCityName("Szeged");
        return "1";
    }

    @GetMapping("/index2")
    public String weatherByCityId() throws IOException {
        return "1";
    }

}
