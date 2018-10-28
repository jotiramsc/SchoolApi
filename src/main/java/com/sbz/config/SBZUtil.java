package com.sbz.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SBZUtil {

	public static String[] honorifics = { "Mr", "Ms", "Miss", "Mrs", "Mx", "Master", "Sir", "Madam", "Dame", "Lord",
			"Lady", "Dr", "Prof", "Br", "Sr", "Fr", "Rev", "Pr", "Elder" };
	public static String[] states = { "Andaman and Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh", "Assam",
			"Bihar", "Chandigarh", "Chhattisgarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Goa", "Gujarat",
			"Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Lakshadweep",
			"Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Puducherry",
			"Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal" };

	public static boolean isValidMobile(String s) {
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");

		Matcher m = p.matcher(s);
		return (m.find() && m.group().equals(s));
	}

	public static boolean isValidEmail(String email) {
		String emailRegex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public static boolean isValidString(String str, boolean spConsider) {
		if (spConsider) {
			return str.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
		} else {
			return str.matches("[a-zA-z]+(['-][a-zA-Z]+)*");
		}
	}

	public static boolean isValidDate(String str, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		try {
			df.parse(str);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public static Date parseDate(String str, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		try {
			Date d = df.parse(str);
			Date d1=new Date();
			d1.setDate(d.getDate());
			d1.setMonth(d.getMonth()-1);
			d1.setYear(d.getYear());
			return d1;
			

		} catch (ParseException e) {
			return null;
		}
	}

	public static boolean isValidZip(String str) {
		String zipCodePattern = "\\d{6}?";
		return str.matches(zipCodePattern);
	}

	public static String IntegerToRoman(int n) {
		String roman = "";
		int repeat;

		repeat = n / 1000;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "M";
		}
		n = n % 1000;

		repeat = n / 900;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "CM";
		}
		n = n % 900;

		repeat = n / 500;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "D";
		}
		n = n % 500;

		repeat = n / 400;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "CD";
		}
		n = n % 400;

		repeat = n / 100;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "C";
		}
		n = n % 100;

		repeat = n / 90;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "XC";
		}
		n = n % 90;

		repeat = n / 50;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "L";
		}
		n = n % 50;

		repeat = n / 40;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "XL";
		}
		n = n % 40;

		repeat = n / 10;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "X";
		}
		n = n % 10;

		repeat = n / 9;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "IX";
		}
		n = n % 9;

		repeat = n / 5;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "V";
		}
		n = n % 5;

		repeat = n / 4;
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "IV";
		}
		n = n % 4;

		repeat = n / 1; // or simply repeat=n or i<=n in the condition part of
						// the loop
		for (int i = 1; i <= repeat; i++) {
			roman = roman + "I";
		}
		return roman;
	}
}
