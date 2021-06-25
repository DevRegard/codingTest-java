package level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @codingTest <Problems> ���ڿ� �� ������� �����ϱ�
 *
 *	charAt() : Ư�� ���ڿ��� ��ġ�ϴ� �����ڵ� ���Ϲ��ڸ� ��ȯ
 *	Comparator : Object�� �Ű������� �޾Ƽ� ��
 */
public class SortingStrings {

	
	public String[] sortingStrings(String[] strings, int n) {
        String[] answer = {};
        return answer;
    }
	
	
	
	
	// [�ַ��1] Arrays, Comparator Ŭ���� ���
	public String[] sortingStrings_1(String[] strings, int n) {
		
		Arrays.sort(strings, new Comparator<String>() { //***
	          @Override
	          public int compare(String s1, String s2){
	              char c1 = s1.charAt(n);
	              char c2 = s2.charAt(n);
	              
	              // n��° ���ڰ� ���� ��쿡 ���� ��Ʈ���� ����������
	              if(c1 == c2){
	                  return s1.compareTo(s2);
	              } else return c1 - c2;
	          }
	      });
	      
	      return strings;
	}
	
	
	
	
	// [�ַ��2] ArrayListd, Collections Ŭ���� ��� , ���ڿ��� ������ �ű�� ���
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
	
	
	
	
	// [�ַ��3] List Ŭ���� ����� ���
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