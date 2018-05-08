import lejos.utility.*;
import lejos.hardware.Button;


 public class Main {
	 
	 static drive fahren = new drive();
	 static sensoring sensor = new sensoring();
	 static boolean stop = false;
	
public static void main (String args[]){
	 
	MiniPID pid = new MiniPID(1.2, 0.001, 0.3);
	//MiniPID pid = new MiniPID(1.0, 0.0001, 1.2);
	pid.setOutputLimits(1);

	 
	Button.LEDPattern(1);
	//float offset = sensor.setOffset();
	pid.setSetpoint(0.505);
	Button.LEDPattern(2);
	
	
	while (Button.ESCAPE.isUp() & stop == false) {
		
		/*System.out.println(sensor.readColorID());
		if (sensor.readColorID() == 13) {
			//stop = true;
		}*/
		 
		float sensorValue = sensor.readRedMode();
		float pidOut = (float) pid.getOutput(sensorValue);
		
		//System.out.println(pidOut);
		System.out.println(" ");
		
		fahren.ride(pidOut, 100);
		
		Delay.msDelay(50); 
	}
	fahren.stop();
}
}