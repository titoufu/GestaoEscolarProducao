package utilAlerts;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.DatePicker;

public class DateUtil {
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static DateTimeFormatter formatterLong = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public static String dateShort(LocalDate localDate) {
		String data = localDate.format(formatter);
		return data;
	}

	public static String dateLong(LocalDate localDate) {

		String data = localDate.format(formatterLong);
		return data;
	}

	public static String datePicherShort(DatePicker datePicker) {
		LocalDate date = datePicker.getValue();
		String data = dateShort(date);
		return data;
	}

	public static String datePicherLong(DatePicker datePicker) {
		LocalDate date = datePicker.getValue();
		String data = dateLong(date);
		return data;
	}

	public static LocalDate fromStringToLocalDate(String dateString) {
		if (dateString == null || dateString.trim().isEmpty()) {
			return null;
		}
		return LocalDate.parse(dateString, formatter);
	}

	public static String fromDateToString(Date date) {
		DateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
		String date_string = date_format.format(date);
		return date_string;
	}
}
