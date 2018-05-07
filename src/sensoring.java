import lejos.hardware.sensor.*;
import lejos.hardware.Button;
import lejos.hardware.port.*;
import lejos.robotics.SampleProvider;
import lejos.robotics.filter.*;
import lejos.utility.Delay;

public class sensoring {
	
	EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S1);
	
	float[] readRGB() {
		SampleProvider colorRGBSensor = new MeanFilter(colorSensor.getMode("RGB"), 10);
		int sampleSize = colorRGBSensor.sampleSize();
		float[] colorSample = new float[sampleSize];
		colorRGBSensor.fetchSample(colorSample, 0);
		
	return colorSample;
	}
	
	
	float readRedMode() {
		SampleProvider redSensor = new MeanFilter(colorSensor.getRedMode(), 5);
		int sampleSize = colorSensor.sampleSize();
		float[] redSample = new float[sampleSize];
		redSensor.fetchSample(redSample, 0);
		
	return redSample[0];
	}
	
	float setOffset() {
		System.out.println("Weiss setzen");
		Button.ENTER.waitForPress();
		float white = readRedMode();
		System.out.println("Weiss ist auf" + white + "gesetzt");
		System.out.println("Schwarz setzen");
		Button.ENTER.waitForPress();
		float black = readRedMode();
		System.out.println("Schwarz ist auf" + black + "gesetzt");
		float offset = (white+black)/2;
		System.out.println("Offset ist auf" + offset + "gesetzt");
		Button.ENTER.waitForPress();
		
	return offset;
	}
}
