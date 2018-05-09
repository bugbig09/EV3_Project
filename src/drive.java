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
	RegulatedMotor motorC = new EV3MediumRegulatedMotor(MotorPort.C);

public void stop() {
	motorA.stop();
	motorB.stop();
}
	
public void UltraRotation () {
	if (motorC.getTachoCount() == 0) {
		motorC.rotateTo(-90);
	}
	else if (motorC.getTachoCount() == -90) {
		motorC.rotateTo(90);
	}
	else if (motorC.getTachoCount() == 90) {
		motorC.rotateTo(-90);
	}
}

public void ride(float direction, float speed) {
	float scaledDirection = extras.scale(1, -1, speed, -speed, direction);
	motorA.setSpeed((int) (speed - scaledDirection));
	motorB.setSpeed((int) (speed + scaledDirection));
	motorA.forward();
	motorB.forward();
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
			
			if (direction < 0.2f) {
				
				helpA = (1 - (2f*direction));
				speedA = speed * helpA;
				//System.out.println("helpA " + helpA);
				//System.out.println("R slow " + speedA);
				motorA.forward();
				motorA.setSpeed((int) speedA);
				
			}
			
			if (direction == 0.2f) {
			//System.out.println("R stillstand");
				motorA.stop();
			}
			
			if (direction > 0.2f) {
				
				helpA = ((2)*(direction - 0.2f));
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
			
			if (direction > -0.2f) {
				
				helpB = (1 - (-2f*direction));
				speedB = speed * helpB;
				//System.out.println("L slow " + speedB);
				motorB.forward();
				motorB.setSpeed((int) speedB);
				
			}
			
			if (direction == 0.2f) {
			//System.out.println("L stillstand");
				motorB.stop();
			}
			
			if (direction < -0.2f) {
				
				helpB = (-2*(direction + 0.2f));
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
