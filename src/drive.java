import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.robotics.RegulatedMotor;

public class drive {
	/*
	 * Einbinden der Klassen
	 * Definieren der Motoren
	 * Variablen definition
	 */
	extras extras = new extras();

	RegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
	RegulatedMotor motorB = new EV3LargeRegulatedMotor(MotorPort.B);
	
	int MaxSpeed = 500;
	int SpeedOutA = 0;
	int SpeedOutB = 0;
	int scaledSpeed;
	int scaledRotation;
	
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
	
	/* 
	 * Werte in die Bereiche skalieren
	 */

	scaledSpeed = (int) extras.scale(100, 0, MaxSpeed, 0, speed);
	scaledRotation = (int) extras.scale(90, -90, 100, 0, rotation);
	
	switch (direction) {
	case -1:
		
		break;
		
	case 1:
		SpeedOutA = (scaledSpeed*scaledRotation)/100;
		SpeedOutB = scaledSpeed - SpeedOutA;
		
		motorA.setSpeed(SpeedOutA);
		motorB.setSpeed(SpeedOutB);
		motorA.forward();
		motorB.forward();
		
		break;

	default:
		motorA.stop();
		motorB.stop();
		
		break;
	}
}
}
