import lejos.utility.*;

 public class Main {
	 
	 static drive fahren = new drive();

public static void main (String args[]){
	fahren.ride(100, 1, 0);
	Delay.msDelay(2000);
	fahren.ride(100, 1, -10);
	Delay.msDelay(5000);
	fahren.ride(100, 1, 5);
	Delay.msDelay(5000);
	
 	}
 }