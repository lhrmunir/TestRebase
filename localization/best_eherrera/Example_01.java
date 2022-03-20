package com.localization.best_eherrera;

// https://ocpj8.javastudyguide.com/ch30.html

import java.util.Arrays;
import java.util.Locale;

public class Example_01 {

	public static void main(String[] args) 
	{
		Locale locale = Locale.getDefault();

		System.out.println("Country Code: "  + locale.getCountry());
		System.out.println("Country Name: "	 + locale.getDisplayCountry());
		System.out.println("Language Code: " + locale.getLanguage());
		System.out.println("Language Name: " + locale.getDisplayLanguage());
		
		// ---------------------------------------------------------------------------------------------
		Locale [] locales = Locale.getAvailableLocales();
		Arrays.stream(locales).forEach(System.out::println);
		
		// ---------------------------------------------------------------------------------------------
		Locale chinese = new Locale("zh");
		// Locale CHINA = new Locale("zh", "CN");
		Locale CHINA = new Locale("ur", "PK");
		
		System.out.println("Country Code: "  + CHINA.getCountry());
		System.out.println("Country Name: "	 + CHINA.getDisplayCountry());
		System.out.println("Language Code: " + CHINA.getLanguage());
		System.out.println("Language Name: " + CHINA.getDisplayLanguage());
		
		/* --- OUTPUT ---------
		  		Country Code: CN
				Country Name: China
				Language Code: zh
				Language Name: Chinese
				-------------------------
				Country Code: PK
				Country Name: Pakistan
				Language Code: ur
				Language Name: Urdu
		 */
		
		// ---------------------------------------------------------------------------------------------
		
		
		
		
		// ---------------------------------------------------------------------------------------------
		
		
		
		// ---------------------------------------------------------------------------------------------
		
		
		
		// ---------------------------------------------------------------------------------------------
	}

}
