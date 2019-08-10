# MultithreadedTrafficLightListenerAndController
Multithreaded Traffic Light Listener and Controller
There's a TrafficLight class as a thread and a Vehicle class as a thread.
A Vehicle object provides a method reference to the TrafficLight object so the TrafficLight object can inform of color changes in the light
The Vehicle object leaves the intersection when the light turns green.
This works, but it needs an array of objects to inform in the TrafficLight class rather than one Vehicle object as currently implemented.
