package level_1;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

/**
 * @codingTest 2016년
 *
 */
public class Year2016 {
	
	public String year2016(int a, int b) {
		
		String answer = "";
		
		int[] monthDay = {31,29,31,30,31,30,31,31,30,31,30,31};
		
		for (int i = 0; i < a; i++) { //a-1월 만큼 반복 
			b += monthDay[i-1]; //절대일수 구하기
		}
		
		switch (b % 7) {
		case 3: answer = "SUN"; break;
		case 4: answer = "MON"; break;
		case 5: answer = "TUE"; break;
		case 6: answer = "WED"; break;
		case 0: answer = "THU"; break;
		case 1: answer = "FRI"; break;
		case 2: answer = "SAT"; break;
		
		}
		return answer;
		
	}
	
	
	public String year2016_1(int a, int b) {
		String answer = "";
        
        String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        String[] year = new String[366];
        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
        int want_day = 0;
        
        //1월 1일이 금요일이기에 (i+5)를 하여 금요일을 시작으로 만들었다.
        for(int i=0; i<year.length; i++) {
            year[i] =  day[(i+5)%7];
        }
        
        for(int i=0; i<a-1; i++) {
            want_day += month[i]; 
        }
        
        //1월 1일도 하루 지난 것으로 되어서 -1을 해야한다!
        want_day += b-1;
        
        answer = year[want_day];
        
        return answer;
	}
	
	
	
	public String year2016_2(int month, int day) {
		
		Calendar cal = new Calendar.Builder().setCalendarType("iso8601")
				.setDate(2016, month - 1, day).build();
		
		return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
	}
	
	
	
	public String year2016_3(int a, int b) {
		String answer = " ";
		
		int[] monthDay= {31,29,31,30,31,30,31,31,30,31,30,31};
		for (int i = 1; i < a; i++) {
			b += monthDay[i-1];
		}
		
		switch (b % 7) {
		case 3 : answer = "SUN"; break;
		case 4 : answer = "MON"; break;
		case 5 : answer = "TUE"; break;
		case 6 : answer = "WED"; break;
		case 0 : answer = "THU"; break;
		case 1 : answer = "FRI"; break;
		case 2 : answer = "SAT"; break;
		}
				
		return answer;
	}
	
	
	
	public String year2016_4(int a, int b) {
			
		return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0,3);
	}
	
	
	
	public String year2016_5(int a, int b) {
		String answer = "";
		
		int[] c = {31,29,31,30,31,30,31,31,30,31,30,31};
		String[] MM = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
		int Adate = 0;
		
		for (int i = 0; i < a-1; i++) {
			Adate += c[i];
		}
		
		Adate += b-1;
		answer = MM[Adate % 7];

		
		return answer;
	}
	
	
	
	public static void main(String[] args) {
		Year2016 yy = new Year2016();
		System.out.println(yy.year2016(5, 24));
		System.out.println(yy.year2016_1(5, 24));
		System.out.println(yy.year2016_2(5, 24));
		System.out.println(yy.year2016_3(5, 24));
		System.out.println(yy.year2016_4(5, 24));
		System.out.println(yy.year2016_5(5, 24));
	}
	
}
