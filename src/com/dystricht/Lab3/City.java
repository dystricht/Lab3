package com.dystricht.Lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;

public class City {

	static String citiesFile = "file:rsc/world_cities.txt";
	static String citiesOutFile = "rsc/cities_out.txt";
	
	public static ArrayList<City> worldCities = new ArrayList<City>();

	String countryCode;
	String name;
	String region;
	int population;
	double latitude, longitude;

	public City(String countryCode, String name, String region, int population, double latitude, double longitude) {

		this.countryCode = countryCode;
		this.name = name;
		this.region = region;
		this.population = population;
		this.latitude = latitude;
		this.longitude = longitude;

	}

	@Override
	/**
	 * @return City name, City population, City latitude, City longitude
	 * 
	 */
	public String toString() {

		String descr = (this.name + ", " + this.population + ", " + this.latitude + ", " + this.longitude);

		return descr;

	}

	/**
	 * Creates a city object from a specifically formatted String input from
	 * world_cities.txt
	 * 
	 * @param cityString
	 *            a line from world_cities.txt. String format:
	 *            CountryCode,Name,Region,Population,Latitude,Longitude
	 * @return City object constructed from String cityString
	 */
	public static City getFromString(String cityString) {

		String[] values = cityString.split(",");

		String CountryCode = values[0];
		String Name = values[1];
		String Region = values[2];
		int Population = Integer.valueOf(values[3]);
		double Latitude = Double.valueOf(values[4]);
		double Longitude = Double.valueOf(values[5]);

		City StrungCity = new City(CountryCode, Name, Region, Population, Latitude, Longitude);

		return StrungCity;

	}

	public static void addAllCities() {

	}

	public String getName() {

		return this.name;
	}

	/**
	 * Demo method for class City
	 * 
	 */
	public static void main(String[] args) {

		// ArrayList for storing each city.
		// Told to use normal arrays, but I missed that part. Will update for
		// complete lab submission.

		// Data in from .txt file
		In in = new In(citiesFile);

		// initialize an empty string for reading the file
		String readCities = "";

		// read the file into the string
		while (!in.isEmpty()) {
			readCities = in.readAll();
		}
		in.close();

		// Chop that string up into lines (by city).
		// split returns an array of strings. one index for each line in this
		// case
		String[] cityLines = readCities.split("\n");

		// Create a new City from each line, add to final ArrayList of Cities
		for (int i = 0; i < cityLines.length; i++) {

			worldCities.add(City.getFromString(cityLines[i]));

		}

		// start a new file output stream
		Out out = new Out(citiesOutFile);

		// output each City description to file
		for (City c : worldCities) {

			out.println(c.toString());
		}
		out.close();

		// Sort Alphabetically

		// create array of City out of arrayList for easier sorting
		City[] cityArray = worldCities.toArray(new City[worldCities.size()]);

		// quickSort(cityArray);

		// sort Alphabetically

		int[] byPop = new int[worldCities.size()];

		for (int i = 0; i < worldCities.size(); i++) {
			byPop[i] = worldCities.get(i).population;
		}
		// City.quicksort(cityArray, 0, cityArray.length-1);

	}

	public static void partition(int[] theList, int lowIndex, int highIndex, String field) {

		int pivot = highIndex;

		int p = lowIndex;
		int r = highIndex;
		while (p <= r) {

			while (theList[p] < pivot) {
				p++;
			}
			while (theList[r] > pivot) {
				r--;
			}
			if (p <= r) {
				exchangeNums(theList, p, r);
				// move index to next position on both sides
				p++;
				r--;
			}
		}

		if (lowIndex < r) {
			quicksort(theList, lowIndex, r, field);
		}
		if (p < highIndex) {
			quicksort(theList, p, highIndex, field);
		}

	}

	public static void quicksort(int[] theList, int lowIndex, int highIndex, String field) {

		if (theList.length == 1)
			return;

		else {
			partition(theList, lowIndex, highIndex, field);
		}
	}

	public static void exchangeNums(int[] theList, int i, int j) {
		int temp = theList[i];
		theList[i] = theList[j];
		theList[j] = temp;
	}

	public int compareToName(City c) {

		return this.name.toLowerCase().compareTo(c.name.toLowerCase());
	}

	public int compareToPopulation(City c) {
		return population;

	}

	public int compareToLatitude(City c) {
		return population;

	}
}
