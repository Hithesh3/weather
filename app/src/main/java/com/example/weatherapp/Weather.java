package com.example.weatherapp;

import org.json.JSONException;
import org.json.JSONObject;

public class Weather {
    private String temperature, weatherIcon, city, weatherType;
    private int condition;

    public static Weather fromJson(JSONObject jsonObject) {
        try {
            Weather weather = new Weather();
            weather.city = jsonObject.getString("name");
            weather.condition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weather.weatherType = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weather.weatherIcon = jsonObject.getJSONArray("weather").getJSONObject(0).getString("icon");
            double tempResult = jsonObject.getJSONObject("main").getDouble("temp") - 273.15;
            int roundedValue = (int) Math.rint(tempResult);
            weather.temperature = Integer.toString(roundedValue);
            return weather;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getTemperature() {
        return temperature + "°C";
    }

    public String getIcon() {
        return weatherIcon;
    }

    public String getCity() {
        return city;
    }

    public String getWeatherType() {
        return weatherType;
    }

}
