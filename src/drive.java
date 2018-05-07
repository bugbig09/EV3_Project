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
	
	int MaxSpeed = 200;
	int SpeedOutA = 0;
	int SpeedOutB = 0;
	int scaledSpeed;
	int scaledRotation;
	
void ride(float speed, float direction) {
	int scaledSpeed = (int) extras.scale(100, 0, MaxSpeed, 0, speed);
	int scaledDirection = (int) extras.scale(1, -1, MaxSpeed, 0, direction);

	motorA.setSpeed(scaledSpeed + scaledDirection);
	motorB.setSpeed(scaledSpeed - scaledDirection);
	
	motorA.forward();
	motorB.forward();
	
}
	
void ride2(float speed, float direction, float rotation) {

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
	scaledRotation = (int) extras.scale(1, -1, 100, 0, rotation);
	
	switch ((int)direction) {
	case -1:
		
		break;
		
	case 1:
		/*SpeedOutA = ((scaledSpeed*scaledRotation)/100);
		SpeedOutB = (scaledSpeed - SpeedOutA);

		motorA.setSpeed(SpeedOutA);
		motorB.setSpeed(SpeedOutB);
		
		motorA.forward();
		motorB.forward();*/
		
		if (scaledRotation < 20) {
			SpeedOutA = (scaledSpeed-((scaledSpeed*scaledRotation)/100));
			SpeedOutB = ((scaledSpeed*scaledRotation)/100);
			
			motorA.setSpeed(SpeedOutA);
			motorB.setSpeed(SpeedOutB);
			
			motorA.backward();
			motorB.forward();
		}
		
		else if (scaledRotation > 80) {
			SpeedOutA = ((scaledSpeed*scaledRotation)/100);
			SpeedOutB = (SpeedOutA);
			
			motorA.setSpeed(SpeedOutA);
			motorB.setSpeed(SpeedOutB);
			
			motorA.forward();
			motorB.backward();
		}
		
		else {
			SpeedOutA = ((scaledSpeed*scaledRotation)/100);
			SpeedOutB = (scaledSpeed - SpeedOutA);

			motorA.setSpeed(SpeedOutA);
			motorB.setSpeed(SpeedOutB);
		
			motorA.forward();
			motorB.forward();
		}
		
		break;

	default:
		motorA.stop();
		motorB.stop();
		
		break;
	}
}

void stop() {
	motorA.stop();
	motorB.stop();
}

public void drive(float direction, float speed) {
	float speedA;
	float speedB;
	float helpA;
	float helpB;
	
	//System.out.println(direction);
	//System.out.println(speed);
	//Motor A (Rechts) Steuerung
	
	if (direction > 1) {
		direction = 1;
	}
	
	if (direction < -1) {
		direction = -1;
	}
	
	if (direction <= 1f && direction >= -1f) {
	
		if (direction > 0) {
			
			if (direction < 0.5f) {
				
				helpA = 1 - (2*direction);
				speedA = speed * helpA;
				//System.out.println("helpA " + helpA);
				//System.out.println("R slow " + speedA);
				motorA.forward();
				motorA.setSpeed((int) speedA);
				
			}
			
			if (direction == 0.5f) {
				//System.out.println("R stillstand");
				motorA.stop();
			}
			
			if (direction > 0.5f) {
				
				helpA = ((2)*(direction - 0.5f));
				speedA = speed * helpA;
				//System.out.println("R back " + speedA);
				motorA.backward();
				motorA.setSpeed((int) speedA);		
			
			}
		}
		else {
			
			speedA = speed;	
			//System.out.println("straight A " + speedA);
			motorA.forward();
			motorA.setSpeed((int) speedA);
			
		}
		
		//Motor B (Links) Steuerung
		if (direction < 0) {
			
			if (direction > -0.5f) {
				
				helpB = 1 - (-2*direction);
				speedB = speed * helpB;
				//System.out.println("L slow " + speedB);
				motorB.forward();
				motorB.setSpeed((int) speedB);
				
			}
			
			if (direction == 0.5f) {
				//System.out.println("L stillstand");
				motorB.stop();
			}
			
			if (direction < -0.5f) {
				
				helpB = (-2*(direction + 0.5f));
				speedB = speed * helpB;
				//System.out.println("L Back " + speedB);
				motorB.backward();
				motorB.setSpeed((int) speedB);	
				
			}
		}
		
		else {
			
			speedB = speed;	
			//System.out.println("straigt B " + speedB);
			motorB.forward();
			motorB.setSpeed((int) speedB);
			
		}
		
	} 
	else {
		motorA.stop();
		motorB.stop();
	}
}
}
