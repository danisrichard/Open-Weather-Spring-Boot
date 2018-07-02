package com.openweatherproject.openweatherproject.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.openweatherproject.openweatherproject.entity.Weather;
import com.openweatherproject.openweatherproject.entity.storage.CurrentWeatherURL;
import com.openweatherproject.openweatherproject.entity.storage.ForeCastWeatherURL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

@Component
public class WeatherCreator {

    private static final Logger logger = LogManager.getLogger(WeatherCreator.class);

    @Value("${api.key}")
    private String API_KEY;

    public Weather createWeatherFromURL(String location,Enum urlLink) throws IOException {
        if(checkEnum(urlLink)){
            throw new IllegalArgumentException("Not valid Enum classes");
        }

        URL url = getUrl();
        URLConnection request = url.openConnection();
        request.connect();
        String jsonInString = getJson(request);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonInString,Weather.class);
    }

    private boolean checkEnum(Enum urlLink) {
        return !(urlLink instanceof CurrentWeatherURL || urlLink instanceof ForeCastWeatherURL);
    }

    private String getJson(URLConnection request) throws IOException {
        JsonParser jp = new JsonParser ();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        return root.getAsJsonObject().toString();
    }

    private URL getUrl() throws MalformedURLException {
        URI uri = new UriTemplate(CurrentWeatherURL.BY_CITY_NAME.getURL()).expand("Szeged", API_KEY);
        return new URL(uri.toString());
    }

}
