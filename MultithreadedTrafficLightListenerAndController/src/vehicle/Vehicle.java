/*
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
package vehicle;
import trafficLight.TrafficLight;
import trafficLight.TrafficLight.TRAFFIC_LIGHT_COLOR;
import trafficLight.TrafficLightListener;

/*
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
public class Vehicle extends Thread implements TrafficLightListener {
	private String MACAddress;
	Boolean waitForGreenLight;		// When this is true, the vehicle is waiting at the intersection for the light to turn green
	public Vehicle(String MACAddress, TrafficLight trafficLight) {
		this.MACAddress = MACAddress;
		waitForGreenLight = true;
	}
	public void run() {
		System.out.println("The vehicle with MAC Address " + MACAddress + " is at the traffic light waiting for green.");
		
		// Wait forever for the traffic light to turn green.
		while(waitForGreenLight) {
			try {Thread.sleep(500);} catch (Exception ex) {}
		}
		System.out.println("The vehicle with MAC Address " + MACAddress + " is exiting the run method.");
		return;
	}
	/**
	 * A Traffic Light object will call this method and we will be informed of the current color of the traffic light
	 */
	public void inform(TRAFFIC_LIGHT_COLOR trafficLightColor) {
		if (trafficLightColor == TRAFFIC_LIGHT_COLOR.green) {
			System.out.println("The vehicle with MAC Address " + MACAddress + " is leaving the intersection because the light is now green.");
			waitForGreenLight = false;
		}
	}
}
