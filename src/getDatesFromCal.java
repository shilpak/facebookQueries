import java.text.SimpleDateFormat;
import java.util.Calendar;

public class getDatesFromCal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getCurrentDate();
		getSevenDaysAfterCurrentDate();

	}
	
	public static void getCurrentDate() {
		SimpleDateFormat formattedDate = new SimpleDateFormat("EEEE, dd MMM yyyy");            
		Calendar cal = Calendar.getInstance();  
		String currentDate = formattedDate.format(cal.getTime());
		System.out.println(currentDate);
		//return currentDate;
	}
	
	public static void getSevenDaysAfterCurrentDate() {
		SimpleDateFormat formattedDate = new SimpleDateFormat("EEEE, dd MMM yyyy");            
		Calendar cal = Calendar.getInstance();  
		cal.add(Calendar.DAY_OF_MONTH, 7);
		String sevenplusreturnDate = formattedDate.format(cal.getTime());
		System.out.println(sevenplusreturnDate);
	}

}
