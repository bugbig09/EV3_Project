import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.robotics.RegulatedMotor;
public class drive {
	/*
	 * Einbinden der Extras Klasse
	 */
	extras extras = new extras();

	RegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
	RegulatedMotor motorB = new EV3LargeRegulatedMotor(MotorPort.B);
	
void ride(byte speed, byte direction, byte rotation) {

	/**
 * Direction ist für die Fahrrichtung.
 * 1 für vorwärts
 * 0 für bremsen
 * -1 für rückwärts	
 * 
 * Speed ist für die Bewegungsgeschwindigkeit
 * wird mit zur rotation zugerechnet
 * Bereich: 0-100
 * 
 * Rotation gibt den Winkel für die Kurven an.
 * Bereich -90 - 90 Grad
 * -90 steht für links, 90 für rechts
 */
	
	/* Variablen definition
	 * Werte in die Bereiche skalieren
	 */
	long scaledSpeed;
	long scaledRotation;

	scaledSpeed = extras.scale(100, 0, 500, 0, speed);
	scaledRotation = extras.scale(90, -90, out_Max, out_Min, input)
	
	switch (direction) {
	case -1:
		
		break;
		
	case 1:
		motorA.setSpeed(speed);
		motorA.forward();
		
		break;

	default:
		motorA.stop();
		motorB.stop();
		
		break;
	}
}
}