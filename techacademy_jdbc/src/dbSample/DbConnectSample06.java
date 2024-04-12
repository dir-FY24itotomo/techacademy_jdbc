package dbSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import dbSample.dao.CountryDAO;
import dbSample.entry.Country;

public class DbConnectSample06{
	public static void main(String[] args) {
		CountryDAO dao = new CountryDAO();
		
		//Get keyword to search data
		System.out.print("Enter the keyword > ");
		String name = KeyIn();
		
		List<Country> list = dao.getCountryFromName(name);
		
		for(Country item : list) {
			System.out.println(item.getName());
			System.out.println(item.getPopulation());
		}
	}
	
	//get keyword from console
	private static String KeyIn() {
		String line = null;
		try {
			BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
			line = key.readLine();
		}catch(IOException e) {
			System.out.println("Keyword is invalid");
		}
		return line;
	}
}