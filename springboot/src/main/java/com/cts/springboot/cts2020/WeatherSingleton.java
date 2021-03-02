package com.cts.springboot.cts2020;

import java.util.HashMap;

import lombok.Data;

public class WeatherSingleton {
	HashMap<String,String> locWeather = new HashMap<String,String>();
	private static WeatherSingleton weatherObj ;
	private WeatherSingleton(){
		locWeather.put("Delhi", "Cold");
		locWeather.put("Hyd", "Moderate");
		
	}
	
	public static WeatherSingleton getInstance() {
		if(weatherObj==null) weatherObj =new WeatherSingleton() ;
		return weatherObj;
	}
	
	public String getWeather(String loc){
		return locWeather.get(loc);
		
		
	}

}
