package com.dystricht.Lab3;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.Draw;

public class Constants {
	
	//double int array for star polygon coords
	public int[][] star = { {0,-1}, {2,-3}, {1,0}, {3,1}, {1,1},
			{0,3}, {-1,1}, {-3,1}, {-1,0}, {-2,-3}, {0,-1} };
	
	//double int array for x and y coords of star polygon
	public static double[][] starPoly = { {0, 2, 1.5, 3, 1, 0, -1, -3, -1.5, -2, 0 }, { -1.5, -3, -0.5, 1, 1, 3, 1, 1, -0.5, -3, -1.5} };
	
	public static void main(String[] args){
		
		StdDraw.setXscale(-500, 500);
		StdDraw.setYscale(-500, 500);
		
		StdDraw.clear(StdDraw.BLACK);
		
		//StdDraw.setPenColor(StdDraw.WHITE);
		//StdDraw.filledPolygon(starPoly[0], starPoly[1]);
		
		bounceStar();
	
		
	}
	
	public static void bounceStar(){
		StdDraw.setPenColor(StdDraw.WHITE);
		
		double[][] starDistort = starPoly;
		for(int i = -5; i <=5; i++){
			if(i==0) continue;
			
			StdDraw.clear(StdDraw.BLACK);
			
			for(int j=0; j<starPoly[0].length; j++){
				//StdDraw.clear(StdDraw.BLACK);
				starDistort[0][j] = starPoly[0][j] * Math.abs(i);
				starDistort[1][j] = starPoly[1][j] * Math.abs(i);

			}
			StdDraw.filledPolygon(starDistort[0], starDistort[1]);
			StdDraw.pause(30);

		}
	}
}
