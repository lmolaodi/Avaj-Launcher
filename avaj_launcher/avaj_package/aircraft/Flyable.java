
package avaj_package.aircraft;

import avaj_package.WeatherTower;

public interface Flyable {
	
	void updateConditions();
    void registerTower(WeatherTower weatherTower);
    
}
