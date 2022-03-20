package com.lambda.winterbe;

public class StringTesting {

	public static void main(String[] args) 
	{
		System.out.println(getUserType("cypresstesting+4255790050@tonenetworks.com"));
		System.out.println(getUserType("4255790050@tonenetworkscypresstesting.com"));
		System.out.println(getUserType("mia@tonenetworks.com"));
		System.out.println(getUserType("4255790050cypresstesting@tonenetworks.com"));
		System.out.println(getUserType("cypresstestin+4255790050@tonenetworks.com"));
		System.out.println(getUserType("ypresstesting+4255790050@tonenetworks.com"));
		System.out.println(getUserType("cypresstesting+4255790050@tonenetworks.com"));
		
		
	}
	
	public static String getUserType(String toAddress)
	{
		if (toAddress != null && toAddress.contains("cypresstesting")) 
			return toAddress + " : User is cypress testing user "; 
		else
			return toAddress + " : User is regular user";

	}

}
