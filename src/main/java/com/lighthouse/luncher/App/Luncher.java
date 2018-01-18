package com.lighthouse.luncher.App;

import com.lighthouse.luncher.Configuration.Configuration;
import com.google.gson.JsonObject;
import lombok.Data;

import java.util.*;

@Data
public class Luncher {
    Configuration configuration;

    public Luncher(Configuration configuration) {
        this.configuration = configuration;
    }

    public List<String> getChoices() throws Exception{
        List<String> choices = new ArrayList<String>();
        JsonObject restaurantData = this.getConfiguration().getRestaurantData();
        for(String name : restaurantData.keySet()) {
            JsonObject restaurantObj = restaurantData.getAsJsonObject(name);
            int probability = restaurantObj.get("votes").getAsInt();
            for(int i = 0; i < probability; i++) {
                choices.add(name);
            }
        }
        Collections.shuffle(choices);
        return choices;
    }

    public String run() throws Exception{
       List<String> choices = this.getChoices();
       return choices.get((int)(Math.random() * choices.size()));
    }
}
