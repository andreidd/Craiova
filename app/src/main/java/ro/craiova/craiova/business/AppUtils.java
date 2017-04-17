package ro.craiova.craiova.business;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Andrei.
 */

public class AppUtils {

	public static final String DATE_FORMAT_HUMAN_READABLE = "EEEE, MMM dd 'la' hh:mm";

	public static final SimpleDateFormat humanReadableDateFormat = new SimpleDateFormat(DATE_FORMAT_HUMAN_READABLE);

	public static String formatHumanReadableDate(Date date) {
		return humanReadableDateFormat.format(date);
	}

}
