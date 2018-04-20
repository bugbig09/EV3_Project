import lejos.hardware.sensor.*;
import lejos.hardware.Button;
import lejos.hardware.port.*;
import lejos.robotics.SampleProvider;

public class sensoring {
	
	SensorModes colorSensor = new EV3ColorSensor(SensorPort.S1);
	
	float[] readRGB() {
		SampleProvider colorRGBSensor = colorSensor.getMode("RGB");
		int sampleSize = colorRGBSensor.sampleSize();
		float[] colorSample = new float[sampleSize];
		
		colorRGBSensor.fetchSample(colorSample, 0);
	return colorSample;
	}
	
	float setOffsetBW() {
		float[] RGB;
		
		System.out.println("Weiß festlegen");
		Button.ENTER.waitForPress();
		RGB = readRGB();
		float White = (Math.round(((RGB[0]+RGB[1]+RGB[2])*1000)/3));
		System.out.println("Gesetzt auf " + White);
		Button.ENTER.waitForPress();
		System.out.println("Schwarz festlegen");
		Button.ENTER.waitForPress();
		RGB = readRGB();
		float Black = (Math.round(((RGB[0]+RGB[1]+RGB[2])*1000)/3));
		System.out.println("Gesetzt auf " + Black);
		Button.ENTER.waitForPress();
		return((White+Black)/2);
	}
}
