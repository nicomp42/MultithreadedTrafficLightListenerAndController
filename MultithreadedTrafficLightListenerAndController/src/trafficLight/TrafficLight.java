/*
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
package trafficLight;
public class TrafficLight extends Thread {
	public enum TRAFFIC_LIGHT_COLOR {unknown, red, yellow, green, flashingRed};
	private String location;
	private TRAFFIC_LIGHT_COLOR trafficLightColor;
	TrafficLightListener trafficLightListener;	// This falls apart when more than one vehicle is waiting at the same time, but we can fix that with an array of these objects
	
	public TrafficLight(String location) {
		this.location = location;
		trafficLightColor = TRAFFIC_LIGHT_COLOR.unknown;
	}
	public String getLocation() {return location;}
	/**
	 * Tell the Traffic Light that there is a vehicle waiting for information
	 * @param trafficLightListener
	 */
	public void addTrafficLightListener(TrafficLightListener trafficLightListener) {
		this.trafficLightListener = trafficLightListener;
	}
	/**
	 * The vehicle has left the intersection and we don't have to talk to it any more
	 * @param trafficLightListener
	 */
	public void removeTrafficListener() {
		this.trafficLightListener = null;
	}
	
	public void run() {
		System.out.println("Traffic Light at location " + location);
		while (true) {
//			try {Thread.sleep(3000);}catch(Exception ex) {}
			cycle();
			broadcast();
		}
	}
	/**
	 * Inform the listener of our current color
	 */
	private void broadcast() {
		if (trafficLightListener != null) {
			System.out.println("Traffic Light at location " + location + " is broadcasting the current color");
			trafficLightListener.inform(trafficLightColor);
		}
	}
	/**
	 * It's time to change color
	 * @return The new color
	 */
	private TRAFFIC_LIGHT_COLOR cycle() {
		switch (trafficLightColor) {
		case unknown:
			System.out.println("Traffic Light at location " + location + " has changed from unknown to red");
			trafficLightColor = TRAFFIC_LIGHT_COLOR.red;				
			break;
			
		case red:
			try {Thread.sleep(5000);}catch(Exception ex) {}		// Stay red for 5 seconds
			trafficLightColor = TRAFFIC_LIGHT_COLOR.green;
			System.out.println("Traffic Light at location " + location + " has changed from red to green.");
			break;
			
		case yellow:
			try {Thread.sleep(3000);}catch(Exception ex) {}		// Stay yellow for 3 seconds
			trafficLightColor = TRAFFIC_LIGHT_COLOR.red;
			System.out.println("Traffic Light at location " + location + " has changed from yellow to red.");
			break;
			
		case green:
			try {Thread.sleep(6000);}catch(Exception ex) {}		// Stay green for 6 seconds
			trafficLightColor = TRAFFIC_LIGHT_COLOR.yellow;
			System.out.println("Traffic Light at location " + location + " has changed from green to yellow.");
			break;
			
		default:
			// Uh oh. Something is wrong. Flash red until forever!
			try {Thread.sleep(1000);}catch(Exception ex) {}		// Stay flashing for 1 second
			trafficLightColor = TRAFFIC_LIGHT_COLOR.flashingRed;
			System.out.println("Traffic Light at location " + location + " has changed to flashing red.");
			break;
		}
		return trafficLightColor;
	}
}
