import lejos.utility.*;
import cx.ath.matthew.debug.Debug;
import lejos.hardware.Button;


 public class Main {
	 
	 static drive fahren = new drive();
	 static drive test = new drive();
	 static sensoring sensor = new sensoring();
	 static boolean stop = false;
	
public static void main (String args[]){
	 
	MiniPID pid = new MiniPID(0.65, 0.08, 1.0);
	//MiniPID pid = new MiniPID(1.0, 0.0001, 1.2);
	pid.setOutputLimits(1);

	 
	Button.LEDPattern(1);
	//float offset = sensor.setOffset();
	pid.setSetpoint(0.45);
	Button.LEDPattern(2);
	
	test.UltraRotation();
	
	
	while (Button.ESCAPE.isUp() & stop == false) {
		
		/*float[] rgb = sensor.readRGB();
		Debug.debugout.println("R " + (rgb[0]*255) + " G " + (rgb[1]*255) + " B " + (rgb[2]*255));
		Debug.debugout.println(" ");
		
		Delay.msDelay(10);
		
		if ((rgb[1]*255) > 61 ) {
			//stop = true;
		}*/
		 
		float sensorValue = sensor.readRedMode();
		float pidOut = (float) pid.getOutput(sensorValue);
		
		//System.out.println(pidOut);
		//Debug.debugout.println(pidOut);
		//Debug.debugout.println(" ");
		//System.out.println(" ");
		
		fahren.drive(pidOut, 200);
		
		Delay.msDelay(20); 
	}
	fahren.stop();
}
}