package com.cts.springboot.cts2020;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Data
public class RectangleLombok {
	//@Getter
	//@Setter 
	Double lenght;
	
	//@Getter
	//@Setter
	Double width;
	
	public Double calculateArea(){
		log.info("Calculating area");
		log.debug("Area is {}", lenght*width);
		return lenght*width;
		
		
	}

}
