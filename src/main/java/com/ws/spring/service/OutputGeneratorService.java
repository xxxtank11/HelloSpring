package com.ws.spring.service;

import com.ws.spring.IOutputGenerator;

public class OutputGeneratorService {

	IOutputGenerator outputGenerator;
	
	public void setOutputGenerator(IOutputGenerator outputGenerator) {
		this.outputGenerator = outputGenerator;
	}

	public void generateOutput(){
		outputGenerator.generateOutput();
	}
	
	
}
