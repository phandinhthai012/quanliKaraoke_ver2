package util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import com.toedter.calendar.JDateChooser;

public class DateFormatter {
	public static String format(LocalDate date) {
		String day = String.valueOf(date.getDayOfMonth());
		String month = String.valueOf(date.getMonthValue());
		String year = String.valueOf(date.getYear());
		if (date.getDayOfMonth() < 10) {
			day = "0" + day;
		}

		if (date.getMonthValue() < 10) {
			month = "0" + month;
		}

		return day + "/" + month + "/" + year;
	}

	public static String format(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		String formattedDate = dateFormat.format(date);
		return formattedDate;
	}

	public static String format(java.util.Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		String formattedDate = dateFormat.format(date);
		return formattedDate;
	}

	public static String formatSql(java.util.Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		String formattedDate = dateFormat.format(date);
		return formattedDate;
	}

	public static String formatSql(LocalDate date) {
		String day = String.valueOf(date.getDayOfMonth());
		String month = String.valueOf(date.getMonthValue());
		String year = String.valueOf(date.getYear());
		if (date.getDayOfMonth() < 10) {
			day = "0" + day;
		}

		if (date.getMonthValue() < 10) {
			month = "0" + month;
		}

		return year + "-" + month + "-" + day;
	}

	public static LocalDate toLocalDate(java.util.Date date) {
		@SuppressWarnings("deprecation")
		LocalDate localDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDate());
		return localDate;
	}

	public static LocalDate toLocalDate(JDateChooser dateChooser) {
		LocalDate localDate = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate;
	}
}
