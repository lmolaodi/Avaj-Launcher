
package avaj_package.aircraft;

import java.util.HashMap;

import avaj_package.Coordinates;
import avaj_package.WeatherTower;

public class Helicopter extends Aircraft implements Flyable  {

	private WeatherTower tower;
	
	public Helicopter(String name, Coordinates coordinates) {
		super (name, coordinates);
	}

	public void registerTower(WeatherTower weatherTower) {
		this.tower = weatherTower;
		this.tower.register(this);
		System.out.println("Tower response: Helicopter #" + this.name + "(" + this.id + ")" + " registered to weather tower.");
	}
	
	public void updateConditions() {

		String update = this.updateCoordinates(tower.getWeather(this.coordinates), "Balloon");

		System.out.println("Helicopter #" + this.name + "(id: " + this.id + "): " + msg.get(update));

		if (update == "GROUNDED") {
			System.out.println("Helicopter #" + this.name + "(id: " + this.id + "): landing.");

			System.out.println("Current coordinates: Longtitude: [" + this.coordinates.getLongitude() 
				+ "] Latitude: [" + this.coordinates.getLatitude()
				+ "] Height: [" + this.coordinates.getHeight() + "]");
            this.tower.unregister(this);
            System.out.println("Tower response: Helicopter #" + this.name + "(" + this.id + ")" + " unregistered from weather tower.\n");
		}
	}

	private HashMap<String, String> msg = new HashMap<String, String>() {
		{
			put("SUN", "This is hot.");
			put("RAIN", "Its raining, it will be hard to fly");
			put("FOG", "I cant see a damn thing.");
			put("SNOW", "My rotor is going to freeze!");
			put("GROUNDED", "Grounded now!..");
		}};
}
