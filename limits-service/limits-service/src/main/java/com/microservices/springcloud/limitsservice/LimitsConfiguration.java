package com.microservices.springcloud.limitsservice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LimitsConfiguration {
	private int maximum;
	private int minimum;

	protected LimitsConfiguration() {
		
	}

}