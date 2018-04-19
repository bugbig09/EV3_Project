
public class pid {
	
	/**
	 * Pwert 1000 = 10
	 * Iwert 100 = 1		Werte werden durch 100 geteilt
	 * Dwert 10000 = 100
	 */
	
	
	int integral = 0;
	int lastError = 0;
	int derivative = 0;
	int error;
	int output;
	
	int PID(int Pwert, int Iwert, int Dwert, int offset, int input) {
		error = (input - offset);
		integral = (integral + error);
		derivative = (error - lastError);
		output = ((Pwert*error) + (Iwert*integral) + (Dwert*derivative));
		output = (output/100);
		lastError = error;
		return(output);
	}
}
