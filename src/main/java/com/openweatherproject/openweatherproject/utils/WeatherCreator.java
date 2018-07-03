package com.openweatherproject.openweatherproject.utils;

import com.openweatherproject.openweatherproject.entity.Weather;
import com.openweatherproject.openweatherproject.entity.storage.CurrentWeatherURL;
import com.openweatherproject.openweatherproject.entity.storage.ForeCastWeatherURL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.io.IOException;
import java.net.URI;

@Component
public class WeatherCreator {

    private static final Logger logger = LogManager.getLogger(WeatherCreator.class);

    @Value("${api.key}")
    private String API_KEY;

    public Weather createWeatherFromURL(String location, Enum urlLink) throws IOException {
        if(checkEnum(urlLink) || location == null ){
            throw new IllegalArgumentException("Not valid input");
        }

        URI uri = new UriTemplate(CurrentWeatherURL.BY_CITY_NAME.getURL()).expand("Szeged", API_KEY);

        RestTemplate restTemplate = new RestTemplate();
        String restResourceURL = uri.toString();

        return restTemplate.getForObject(restResourceURL,Weather.class);
    }

    private boolean checkEnum(Enum urlLink) {
        return !(urlLink instanceof CurrentWeatherURL || urlLink instanceof ForeCastWeatherURL);
    }

}
