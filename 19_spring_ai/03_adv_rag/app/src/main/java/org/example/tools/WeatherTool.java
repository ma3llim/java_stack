package org.example.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Component
public class WeatherTool {
    private RestClient restClient;
    @Value("${app.weather.api-key}")
    private String weatherApi;

    public WeatherTool(RestClient restClient) {
        this.restClient = restClient;
    }

    @Tool(description = "Get weather information of given city")
    public String getWeather(@ToolParam(description = "city of which we want to get weather information") String city) {
        var response = restClient
                .get()
                .uri(
                        uriBuilder -> uriBuilder
                                .path("/current.json")
                                .queryParam("key", weatherApi)
                                .queryParam("q", city)
                                .build()
                )
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String, Object>>() {

                });
        System.out.println("response: " + response);
        return response.toString();
    }
}
