
package avaj_package.aircraft;

import avaj_package.Coordinates;

public class AircraftFactory {

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		
		if ((longitude < 0) || (latitude < 0) || (height < 0)) {
			System.out.println("Error: negative longitude, latitude or height");
		}
		
		if (height > 100) {
			height = 100;
		}
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		
		if (type.toLowerCase().equals("helicopter")) {
			System.out.println(type + " " + name + " created.");
			return new Helicopter(name, coordinates);
		}
		else if (type.toLowerCase().equals("jetplane")) {
			System.out.println(type + " " + name + "  created.");
			return new JetPlane(name, coordinates);
		}
		else if (type.toLowerCase().equals("balloon") || type.toLowerCase().equals("baloon") ) {
			System.out.println(type + " " + name + "  created.");
			return new Balloon(name, coordinates);
		}
		return null;
	}
}
