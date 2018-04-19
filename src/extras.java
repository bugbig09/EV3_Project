
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
}
