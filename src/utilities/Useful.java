package utilities;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Useful {

	static NumberFormat valueFormat = new DecimalFormat("R$ #,##0.00");
	
	public static String doubleToString(Double value) {
		return valueFormat.format(value);
	}
	
}
