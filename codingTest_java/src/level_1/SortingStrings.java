package level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @codingTest <Problems> 문자열 내 마음대로 정렬하기
 *
 *	charAt() : 특정 문자열의 위치하는 유니코드 단일문자를 반환
 *	Comparator : Object를 매개변수로 받아서 비교
 */
public class SortingStrings {

	
	public String[] sortingStrings(String[] strings, int n) {
        String[] answer = {};
        return answer;
    }
	
	
	
	
	// [솔루션1] Arrays, Comparator 클래스 사용
	public String[] sortingStrings_1(String[] strings, int n) {
		
		Arrays.sort(strings, new Comparator<String>() { //***
	          @Override
	          public int compare(String s1, String s2){
	              char c1 = s1.charAt(n);
	              char c2 = s2.charAt(n);
	              
	              // n번째 문자가 같을 경우에 원본 스트링을 사전순으로
	              if(c1 == c2){
	                  return s1.compareTo(s2);
	              } else return c1 - c2;
	          }
	      });
	      
	      return strings;
	}
	
	
	
	
	// [솔루션2] ArrayListd, Collections 클래스 사용 , 문자열을 앞으로 옮기는 방법
	public String[] sortingStrings_2(String[] strings, int n) {
		
		String[] answer = {};
		
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arr);
        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }
        return answer;
	}
	
	
	
	
	// [솔루션3] List 클래스 사용한 방법
	public String[] sortingStrings_3(String[] strings, int n) {
		 List<String> list = Arrays.asList(strings);
	     list.sort((a, b) -> {
	         int result = (a.split(""))[n].compareTo((b.split(""))[n]);
	         if(result == 0)
	             return a.compareTo(b);
	         return result;
	     });
	     return list.toArray(new String[0]);
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}