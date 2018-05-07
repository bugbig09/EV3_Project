import lejos.utility.*;
import lejos.hardware.Button;


 public class Main {
	 
	 static drive fahren = new drive();
	 static sensoring sensor = new sensoring();
	
public static void main (String args[]){
	 MiniPID pid = new MiniPID(1.0, 0.15, 0.3);
	 //MiniPID pid = new MiniPID(1.5, 0.2, 0.5);
	 pid.setOutputLimits(1);
	 Button.LEDPattern(1);
	 //float offset = sensor.setOffset();
	 Button.LEDPattern(2);
	 
	 while (Button.ESCAPE.isUp()) {
		pid.setSetpoint(0.445);
		
		float sensorValue = sensor.readRedMode();
		
		float pidOut = (float) pid.getOutput(sensorValue);
		System.out.println(pidOut);
		System.out.println(" ");
		
		fahren.drive(pidOut, 200);
		
		Delay.msDelay(50);
	}
}
	
	/*fahren.ride(100, 1, 0);
	Delay.msDelay(2000);
	fahren.ride(100, 1, -10);
	Delay.msDelay(5000);
	fahren.ride(100, 1, 5);
	Delay.msDelay(5000); */
 }