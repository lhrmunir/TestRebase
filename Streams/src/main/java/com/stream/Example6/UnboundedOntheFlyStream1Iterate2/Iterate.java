package com.stream.Example6.UnboundedOntheFlyStream1Iterate2;

import java.util.stream.Stream;

public class Iterate {
	public static void main(String[] args) {

		MyClass myClass = new MyClass();
		myClass.a0 = -1;
		myClass.a1 = 1;

		// multiply by 2
		Stream.iterate(myClass, p -> {
			int i = p.a0;
			p.a0 = p.a1;
			p.a1 = (p.a0 + i);
			return p;
		}).limit(10).skip(2).forEach(p -> System.out.println(p.a1));

	}

}
