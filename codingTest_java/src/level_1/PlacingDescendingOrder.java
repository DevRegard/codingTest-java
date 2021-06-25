package level_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @codingTest <Problems> ���ڿ� ������������ ��ġ�ϱ� [1-27]
 *
 *	toCharArray() : String(���ڿ�)�� char�� �迭�� �ٲ۴�.
 *	StringBuilder() : ���氡�������� ����ȭ�� ������� �ʴ´�. ��Ƽ������ȯ�濡�� �� ���� ���� -> �ӵ��� ���� ���� ����
 *	StringBuffer() : thread-safe ȯ�濡�� ���氡��������, multiple thread ȯ�濡�� ������ Ŭ����
 *					  ��, web�̳� ����ȯ��� ���� �񵿱�� �۵��ϴ� ���� StringBuffer�� �ξ� �����ϴ�.
 *
 *	<�ӵ�> StringBuilder() > StringBuffer()
 *	<������> StringBuilder() < StringBuffer(); 
 *	/// ���� �۾��� �Ҷ��� builder�� ������, �� �� �̻���ʹ� Buffer�� ����ϴ� ���� ����.
 *
 *	reverse() : ���ڿ� ������
 *	toString() : �⺻ ������ �ؽ��ڵ� ��� (�������ؼ� ��밡��)
 *
 *	Stream :
 */
public class PlacingDescendingOrder {

	
	public String placingDescendingOrder(String s) {
        String answer = "";
        return answer;
    }
	
	
	
	
	// [�ַ��1] Collections, Arrays Ŭ���� ����� ���
	public String placingDescendingOrder_1(String s) {
		Character [] arr = new Character [s.length()];
		for(int i=0; i<arr.length; i++) {
			arr[i] = s.charAt(i);
		}
		Arrays.sort(arr,Collections.reverseOrder());
		s = "";
		for(int i=0; i<arr.length; i++) {
			s += arr[i];
		}
		return s;
	}
	
	
	
	
	// [�ַ��2] ������ �迭�� �����ϰ�, �״�� �����ϱ�
	public String placingDescendingOrder_2(String s) {
		char[] sol = s.toCharArray(); //������ �迭
	    Arrays.sort(sol);
	    return new StringBuilder(new String(sol)).reverse().toString(); //**
	}
	
	
	
	
	// [�ַ��3] Stream Ŭ������ ����� ���
	public String placingDescendingOrder_3(String s) {
		return Stream.of(s.split(""))
			    .sorted(Comparator.reverseOrder())
			    .collect(Collectors.joining());
	}
	
	
	
	
	
	public static void main(String[] args) {
		PlacingDescendingOrder pdo = new PlacingDescendingOrder();
		System.out.println(pdo.toString()); //�⺻ ������ �ؽ��ڵ� ���
	}

}
