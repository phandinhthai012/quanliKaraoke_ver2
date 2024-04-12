package util;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimeFormatter {
	public static String format(LocalTime time) {
		String gioHienTai = String.valueOf(time.getHour());
		String phutHienTai = String.valueOf(time.getMinute());

		if (time.getHour() < 10) {
			gioHienTai = "0" + gioHienTai;
		}

		if (time.getMinute() < 10) {
			phutHienTai = "0" + phutHienTai;
		}

		return gioHienTai + ":" + phutHienTai;
	}

	public static int tinhSoPhut(LocalTime gio1, LocalTime gio2) {
		return (int) gio1.until(gio2, ChronoUnit.MINUTES);
	}

	public static String formatSql(LocalTime gio) {
		return gio.getHour() + ":" + gio.getMinute() + ":" + "00";
	}

	public static int tinhSiGio(LocalTime gio1, LocalTime gio2) {
		return (int) gio1.until(gio2, ChronoUnit.HOURS);
	}
}
