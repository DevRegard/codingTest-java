package level_1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @codingTest <Problems> ������ �������� ���� �迭 [1-23]
 *
 *	isEmpty() : ����ִ°�?
 *	Arrays.stream() : 
 *	stream().filter(��� -> ����) :
 *	toArrays() : �迭�� ����
 */
public class DivisibleArray {

	
	public int[] divisibleArray(int[] arr, int divisor) {
        int[] answer = {};
        return answer;
    }
	
	
	
	
	// [�ַ��1] ArrayList, 
	public int[] divisibleArray_1(int[] arr, int divisor) {
		 int[] answer = {};
         ArrayList<Integer> a1 = new ArrayList<Integer>();
         
         for(int i=0; i<arr.length; i++) {
             if(arr[i]%divisor==0) a1.add(arr[i]); //������ �������� ArrayList�� �߰�
         }
         
         if(a1.isEmpty()) { // ���������
             a1.add(-1);
         }
         
         answer = new int[a1.size()];
         
         for(int i=0; i<a1.size(); i++) {
             answer[i] = a1.get(i);
         }
         
         Arrays.sort(answer); //Arrays�� ������� ����
         
         return answer;
	}
	
	
	
	
	// [�ַ��2] Arrays.stream().filter() �� �ٷ� ���������� ���
	public int[] divisibleArray_2(int[] arr, int divisor) {
		return Arrays.stream(arr).filter(element -> element%divisor==0).toArray();
		// �׽�Ʈ���̽� 1�� 2 �߰��� 
		// sort()�� ��ȯ�� -1�� ��� �׽�Ʈ�δ� ������� �ʴ´�.
	}
	
	
	
	
	// [�ַ��3] �ַ��2���� �׽�Ʈ���̽� 2,3�� ������ �� �ֵ��� ���ϵ� ���
	public int[] divisibleArray_3(int[] arr, int divisor) {
		int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
        if(answer.length == 0) answer = new int[] {-1};
        java.util.Arrays.sort(answer);
        return answer;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
