import lejos.utility.*;
import lejos.hardware.lcd.*;
import lejos.hardware.Button;

 public class Main {
	 
	 static drive fahren = new drive();
	 static sensoring sensor = new sensoring();
	 static pid pidLeft = new pid();
	 static pid pidRight = new pid();
	 
	 static boolean WhiteSet = false;
	 static boolean BlackSet = false;
	
public static void main (String args[]){
		int Offset = (int) sensor.setOffsetBW();
		System.out.println(Offset);
		Button.ENTER.waitForPress();
	
	while (Button.ESCAPE.isUp()) {
		float[] RGB = sensor.readRGB();
		
		

			System.out.println(pidLeft.PID(1000, 100, 10000, Offset, (Math.round((RGB[0]+RGB[1]+RGB[2])*1000)/3)));
			Delay.msDelay(500);
		}
	}

	
	/*fahren.ride(100, 1, 0);
	Delay.msDelay(2000);
	fahren.ride(100, 1, -10);
	Delay.msDelay(5000);
	fahren.ride(100, 1, 5);
	Delay.msDelay(5000); */
 }