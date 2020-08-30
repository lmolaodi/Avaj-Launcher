
package avaj_package.aircraft;

import java.util.HashMap;

import avaj_package.Coordinates;
import avaj_package.WeatherTower;

public class JetPlane extends Aircraft implements Flyable  {

	private WeatherTower tower;
	
	public JetPlane(String name, Coordinates coordinates) {
		super (name, coordinates);
	}

	public void registerTower(WeatherTower weatherTower) {
		this.tower = weatherTower;
		this.tower.register(this);
		System.out.println("Tower response: JetPlane #" + this.name + "(id: " + this.id + ")" + " registered to weather tower.");
	}

	public void updateConditions() {
		String update = this.updateCoordinates(tower.getWeather(this.coordinates), "JetPlane");

		System.out.println("JetPlane #" + this.name + "(id: " + this.id + "): " + msg.get(update));
		if (update == "GROUNDED") {
			System.out.println("JetPlane #" + this.name + "(id: " + this.id + "): landing.");
			System.out.println("Current coordinates: Longtitude: [" + this.coordinates.getLongitude() 
				+ "] Latitude: [" + this.coordinates.getLatitude()
				+ "] Height: [" + this.coordinates.getHeight() + "]");
            this.tower.unregister(this);
            System.out.println("Tower response: JetPlane #" + this.name + "(id: " + this.id + ")" + " unregistered from weather tower.\n");
		}
	}

	HashMap<String, String> msg = new HashMap<String, String>()
		{{
			put("SUN", "beautiful sky!");
			put("RAIN", "Its raining. Better watch out for the lightining!");
			put("FOG", "Good thing I installed these fog lights!");
			put("SNOW", "I need windshield wipers.");
			put("GROUNDED", "landing as safely as I can.");
		}};
}
