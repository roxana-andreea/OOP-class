package liceu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	public static Date parseDate(String s) {
		try {
			return format.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String dateToString(Date date) {
		return format.format(date);
	}
}
