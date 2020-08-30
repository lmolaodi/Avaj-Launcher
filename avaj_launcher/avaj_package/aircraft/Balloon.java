package avaj_package.aircraft;

import java.util.HashMap;
import avaj_package.Coordinates;
import avaj_package.WeatherTower;

public class Balloon extends Aircraft implements Flyable  {

	private WeatherTower tower;

	public Balloon(String name, Coordinates coordinates) {
		super (name, coordinates);
	}

	public void registerTower(WeatherTower weatherTower) {
		this.tower = weatherTower;
		this.tower.register(this);
		System.out.println("Tower response: Balloon #" + this.name + "(id: " + this.id + ")" + " registered to weather tower.");
	}

	public void updateConditions() {
		String update = this.updateCoordinates(tower.getWeather(this.coordinates), "Balloon");
		System.out.println("Balloon #" + this.name + "(id: " + this.id + "): " + msg.get(update));
		if (update == "GROUNDED") {
			System.out.println("Balloon #" + this.name + "(id: " + this.id + "): landing.");
			System.out.println("Current coordinates: Longtitude: [" + this.coordinates.getLongitude() 
				+ "] Latitude: [" + this.coordinates.getLatitude()
				+ "] Height: [" + this.coordinates.getHeight() + "]");
            this.tower.unregister(this);
            System.out.println("Tower response: Balloon #" + this.name + "(id: " + this.id + ")" + " unregistered from weather tower.\n");
		}
	}	
	
	private HashMap<String, String> msg = new HashMap<String, String>() {
	{
		put("SUN", "Lets enjoy the good weather and take some pics");
		put("RAIN", "Damn you rain!!!");
		put("FOG", "I cant see a damn thing.");
		put("SNOW", "Its snowing we are gonna crash!!...");
		put("GROUNDED", "Landing!");
	}};
}
