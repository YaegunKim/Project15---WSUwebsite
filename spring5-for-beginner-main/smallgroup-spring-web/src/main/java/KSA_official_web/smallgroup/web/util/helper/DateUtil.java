package KSA_offical_web.smallgroup.web.util.helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	//
	public static String today() {
		//
		return LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
	}
}