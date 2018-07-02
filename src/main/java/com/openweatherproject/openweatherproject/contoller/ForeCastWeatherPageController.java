package com.openweatherproject.openweatherproject.contoller;

import com.openweatherproject.openweatherproject.service.impl.CurrentWeatherImpl;
import com.openweatherproject.openweatherproject.service.impl.ForeCastWeatherImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForeCastWeatherPageController {

    @Autowired
    ForeCastWeatherImpl currentWeather;
    

}
