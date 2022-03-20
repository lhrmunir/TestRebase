package com.functionalinterface.fiConsumer.foreach;

import java.util.function.Consumer;

class CityConsumer implements Consumer<String>{

	@Override
	public void accept(String t) {
		System.out.println("This class implements Consumer<String> : " + t);
	}
	
}
