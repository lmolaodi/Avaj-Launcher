
package avaj_package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import avaj_package.aircraft.AircraftFactory;
//import avaj_package.WeatherTower;

public class Simulator {
	
	private static int simulationCycles;
	private static BufferedReader buffer;
	private static String currentLine;
	
	private static WeatherTower tower;
	
	public static void main(String[] args) {
		if (args.length < 1) { 
			return;
		}
		
		try {
			startSimulation(new File(args[0]));
			loadAircrafts();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		
		while (simulationCycles-- > 0) {
			tower.changeWeather();
		}
	}

	private static void startSimulation(File file) {
		try {
			buffer = new BufferedReader(new FileReader(file));
			simulationCycles = Integer.parseInt(buffer.readLine());
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	
	private static void loadAircrafts() {
		try {
			String lines[];
			tower = new WeatherTower();
			while ((currentLine = buffer.readLine()) != null) {
				lines = currentLine.split(" ");
				AircraftFactory.newAircraft(lines[0], lines[1], Integer.parseInt(lines[2]),
					Integer.parseInt(lines[3]), Integer.parseInt(lines[4])).registerTower(tower);
			}
			buffer.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}	
}
