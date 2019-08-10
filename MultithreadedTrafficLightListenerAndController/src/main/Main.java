/*
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 */
package main;

import trafficLight.TrafficLight;
import vehicle.Vehicle;

public class Main {

	public static void main(String[] args) {
		TrafficLight trafficLight = new TrafficLight("Northbound Main Street at Elm Street");
		Vehicle corvette = new Vehicle("1F-2E-3D-4C-5B-6A", trafficLight);

		trafficLight.addTrafficLightListener(corvette);
		trafficLight.start();		// JVM will call trafficLight.run()
		corvette.start();
		// Wait for the corvette to get out of here
		try {
			corvette.join();
		} catch (Exception ex) {
			System.out.println("The corvette is gone. We don't care about it any more");
			trafficLight.removeTrafficListener();		// The corvette is gone, tell the Traffic Light to stop talking to it
		}
		try {trafficLight.join();} catch (Exception ex) {}
		
		// This method will continue until the threads we joined, above, have terminated
		
		System.out.println("main method is complete.");

	}
}
