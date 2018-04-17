import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.robotics.RegulatedMotor;

public class drive {
	/*
	 * Einbinden der Klassen
	 * Definieren der Motoren
	 * Variablen definition
	 */
	static extras extras = new extras();

	RegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
	RegulatedMotor motorB = new EV3LargeRegulatedMotor(MotorPort.B);
	
	int MaxSpeed = 500;
	int SpeedOutA = 0;
	int SpeedOutB = 0;
	int scaledSpeed;
	int scaledRotation;
	
void ride(int speed, int direction, int rotation) {

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
	scaledRotation = rotation; /*(int) extras.scale(90, -90, 100, 0, rotation);*/
	
	switch (direction) {
	case -1:
		
		break;
		
	case 1:
		SpeedOutA = (scaledSpeed*scaledRotation/100);
		SpeedOutB = (scaledSpeed - SpeedOutA);
		LCD.drawString("SpeedA", 0, 0);
		LCD.drawInt(SpeedOutA, 0, 1);
		LCD.drawString("SpeedB", 0, 2);
		LCD.drawInt(SpeedOutB, 0, 3);
		LCD.drawInt(scaledSpeed, 0, 4);
		LCD.drawInt(scaledRotation, 0, 5);
		
		
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
