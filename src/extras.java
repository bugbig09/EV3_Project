
public class extras {
	
	
	float scale(float in_Max, float in_Min, float out_Max, float out_Min, float input) {
		float output;
		if (in_Min<0) {
			in_Min=-in_Min;
			output = ((out_Max-(out_Min))/(in_Max+in_Min))*((input)+in_Min)+(out_Min);
			return(output);
		}
		else {
			output = ((out_Max-out_Min)/(in_Max-in_Min))*(input-in_Min)+out_Min;
			return(output);
		}
	}
	
	/*
	Kp = 1000				! REMEMBER we are using Kp*100 so this is really 10
	Ki = 100				! REMEMBER we are using Ki*100 so this is really 1 !
	Kd = 10000 				! REMEMBER we are using Kd*100 so this is really 100!
	offset = 45	
	Tp = 50 				! Initialize the variables
	integral = 0 			! the place where we will store our integral
	lastError = 0 			! the place where we will store the last error value
	derivative = 0 			! the place where we will store the derivative
	
Loop forever	
	LightValue = read light sensor					! what is the current light reading?
	error = LightValue - offset						! calculate the error by subtracting the offset 
	integral = integral + error						! calculate the integral
	derivative = error - lastError					! calculate the derivative
	Turn = Kp*error + Ki*integral + Kd*derivative 	! the "P term" the "I term" and the "D term"
	Turn = Turn/100									! Remember to undo the affect of the factor of 100 in Kp, Ki, Kd
	powerA = Tp + Turn								! Power Motor A
	powerC = Tp - Turn								! Power Motor C
	MOTOR A direction=forward power=PowerA 			! actually issue the command in a MOTOR block
	MOTOR C direction=forward power=PowerC 			! same for the other motor but using the other power level 
	lastError = error 								! save the current error so it can be the lastError next time around
end loop forever                      				! done with loop, go back and do it again.
	 */
	

}
