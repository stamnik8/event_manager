package org.app.event_manager.web.adapters.weather;

import org.app.event_manager.web.adapters.weather.model.Weather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;

@Service
public class WeatherAdapter {

    public String getWeather(ZonedDateTime time, String lon, String lat) {
        RestTemplate restTemplate = new RestTemplate();
        Long timeStamp = time.toEpochSecond();
        Weather weather = restTemplate.getForObject(
                "https://api.darksky.net/forecast/ea361bd861ae17ffd96c56de67cb59e7/"+lat+","+lon+"," + timeStamp, Weather.class);
        return weather.getHourly().getData().get(0).getSummary();
    }
}
