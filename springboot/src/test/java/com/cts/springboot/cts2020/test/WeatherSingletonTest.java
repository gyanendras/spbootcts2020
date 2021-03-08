package com.cts.springboot.cts2020.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import com.cts.springboot.cts2020.WeatherSingleton;

class WeatherSingletonTest {
 
	@Test
	void testGetWeather() {
		WeatherSingleton ws = WeatherSingleton.getInstance();
		WeatherSingleton ws2 = WeatherSingleton.getInstance();
		ws.getWeather("Delhi");
		ws2.getWeather("Delhi");
		assertEquals(ws, ws2);
		
}
	
	

}
