package util;

import java.text.DecimalFormat;

public class MoneyFormatter {
	public static String format(double tien) {
		if (tien == 0) {
			return new String("0 VND");
		}
		return new String(new DecimalFormat("#,### VND").format(tien));
	}

	public static String format1(double tien) {
		if (tien == 0) {
			return new String("0.00 VND");
		}
		return new String(new DecimalFormat("#,###").format(tien));
	}
}
