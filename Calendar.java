/**
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {
	// Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2; // 1.1.1900 was a Monday

	public static void main(String args[]) {
		int theyear = Integer.parseInt(args[0]);
		int run = (theyear - 1900) * 365;
		int i = 1900;
		while (i < theyear) {
			if (isLeapYear(i)) {
				run++;
			}
			i++;
		}
		int j = 1;
		while (j <= run) {
			advance();
			j++;
		}
		int save = theyear;

		while (theyear == save) {
			System.out.print(dayOfMonth + "/" + month + "/" + year);
			if (dayOfWeek == 1) {
				System.out.print(" Sunday");
			}
			System.out.println();
			if (dayOfMonth == 31 && month == 12) {
				theyear++;
			}
			advance();
		}
	}

	// Advances the date (day, month, year) and the day-of-the-week.
	// If the month changes, sets the number of days in this month.
	// Side effects: changes the static variables dayOfMonth, month, year,
	// dayOfWeek, nDaysInMonth.
	private static void advance() {
		if (dayOfWeek < 7) {
			dayOfWeek++;
		} else {
			dayOfWeek = 1;
		}
		if (dayOfMonth < nDaysInMonth(month, year)) {
			dayOfMonth++;
		} else {
			dayOfMonth = 1;
			if (month < 12) {
				month++;
			} else {
				month = 1;
				year++;
			}
		}
	}

	// Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
		if (year % 4 == 0) {
			return true;
		} else {
			return false;
		}
	}

	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 | month == 10 | month == 12) {
			return 31;
		} else {
			if (isLeapYear(year)) {
				return 29;
			} else {
				return 28;
			}
		}
	}
}