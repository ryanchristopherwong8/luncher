package com.lighthouse.luncher.Configuration;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Data;

import java.io.*;

@Data
public class Configuration {
    JsonObject restaurantData;

    public void load() throws Exception {
        this.loadRestaurantData();
    }

    public void loadRestaurantData() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("/restaurantData.json");
        JsonParser jsonParser = new JsonParser();
        this.restaurantData = jsonParser.parse(new InputStreamReader(inputStream)).getAsJsonObject();
    }
}
