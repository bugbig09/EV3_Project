
public class extras {

	long scale(long in_Max, long in_Min, long out_Max, long out_Min, long input) {
		long output;
		output = ((out_Max-out_Min)/(in_Max-in_Min))*(input-in_Min)+ out_Min;
		return(output);
	}
}
