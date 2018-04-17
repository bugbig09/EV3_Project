import lejos.hardware.Brick;
import lejos.utility.*;

 public class Main {
	 
	 static drive fahren = new drive();

public static void main (String args[]){
	fahren.ride(100, 1, 50);
	Delay.msDelay(2000);
	fahren.ride(100, 1, 20);
	Delay.msDelay(2000);
	fahren.ride(100, 1, 80);
	Delay.msDelay(2000);
	
 }

 }