package com.dystricht.Lab3;

import java.util.ArrayList;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;

public class CityLab {

	static String citiesFile = "file:rsc/world_cities.txt";
	static String citiesOutFile = "rsc/cities_out.txt";
	
	static boolean running = true;
	
	public static ArrayList<City> worldCities = new ArrayList<City>();
	
	/**
	 * Demonstration of City class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		//ArrayList for storing each city.
		//Told to use normal arrays, but I missed that part. Will update for complete lab submission.

		//Data in from .txt file
		In in = new In(citiesFile);
		
		//initialize an empty string for reading the file
		String readCities = "";
		
		//read the file into the string
		while (!in.isEmpty()) {
			readCities = in.readAll();
		}
		in.close();
		

		//Chop that string up into lines (by city).
		//split returns an array of strings. one index for each line in this case
		String[] cityLines = readCities.split("\n");

		//Create a new City from each line, add to final ArrayList of Cities
		for (int i = 0; i < cityLines.length; i++) {

			worldCities.add(City.getFromString(cityLines[i]));
			
		}		
		
		while(running){
			
			updateAnim();
			draw();
		}
		
	}
	
	public static void quickSort(City[] list){
		
		//quickSort(list, 0, list.length-1);
	}
	
	public static void draw(){
		
	}
	
	public static void updateAnim(){
		
	}


}
