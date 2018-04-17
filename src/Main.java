import lejos.hardware.Brick;
import lejos.utility.*;

 public class Main {
	 
	 static drive fahren = new drive();

public static void main (String args[]){
	fahren.ride(100, 1, 0);
	Delay.msDelay(2000);
	fahren.ride(100, 1, -90);
	Delay.msDelay(2000);
	fahren.ride(100, 1, 90);
	Delay.msDelay(2000);
	
 }

 }