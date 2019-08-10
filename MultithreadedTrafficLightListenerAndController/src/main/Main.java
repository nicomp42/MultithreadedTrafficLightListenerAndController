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

		trafficLight.start();		// JVM will call trafficLight.run()
		try {Thread.sleep(1000);} catch(Exception ex) {}		// Wait for the traffic light to sort itself out. 
		try {
			corvette.start();										// Here comes a Corvette
			trafficLight.join();									// We are stuck here until the trafficLight thread ends!
		} catch (Exception ex) {
			
		}

		// This method will continue until the threads we joined, above, have terminated
		
		System.out.println("main method is complete.");

	}
}
