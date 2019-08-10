/**
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
package trafficLight;

import trafficLight.TrafficLight.TRAFFIC_LIGHT_COLOR;

public interface TrafficLightListener {
	public void inform(TRAFFIC_LIGHT_COLOR trafficLightColor);
}
