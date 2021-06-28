package level_1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @codingTest <Problems> ���� ���� �� �����ϱ� [1-40]
 * 
 *	�� �޼��忡 return�� ������ ���� �� �ִ�. (������ ����)
 *
 *	getAsInt() : ����� ���� Int������ ��� �޼���
 *	stream.min() : stream���� �ּڰ� ���ϴ� �޼���
 *	toArray() : List�� �ν��Ͻ��� �迭(array)�� ����� �޼���
 *
 *	<�ּڰ����ϱ�>
 *	int min = (int)Arrays.stream(a).min().getAsInt(); 
 *
 *	<�ִ񰪱��ϱ�>
 *	int max = (int)Arrays.stream(b).max().getAsInt();
 */
public class RemoveSmallestNumber {

	
	public int[] removeSmallestNumber(int[] arr) {
        int[] answer = {};
        return answer;
    }
	
	
	
	
	// [�ַ��1]
	public int[] removeSmallestNumber_1(int[] arr) {
		int min = arr[0];
	      int[] answer = new int[arr.length - 1];

	      if (arr.length <= 1) { //�迭�� ���̰� 1�̰ų� ������ 
	         int[] answer2 = { -1 };
	         return answer2;
	      }


	         for (int i = 0; i < arr.length; i++) { 

	            if (min > arr[i]) { //�ּڰ����� ���� ������
	            	// 3 > 5 (�ּڰ����� ŭ)
	            	// 5 > 3 (�ּڰ����� �����Ƿ� �ּڰ��� 5���� 3���� ����)
	               min = arr[i]; 
	            }	

	         }
	           int index = 0;
	         for (int j = 0; j < arr.length; j++) {
	            if (min == arr[j]) { //�ּڰ��̸�
	               continue; //���� �ϰ� ��� ���� -> ������ �з�
	            } else { 
	               answer[index++] = arr[j];
	            }

	         }


	      return answer;
	}
	
	
	
	
	// [�ַ��2] Array�� ArrayList Ŭ������ ����� ���
	public int[] removeSmallestNumber_2(int[] arr) {
		// sort�� �̿��ؼ� �ּڰ� ��������    
				int[] temp = arr.clone(); //����
				Arrays.sort(temp); //����
				int min = temp[0];
				//ArrayList�� �̿��Ͽ� �ּڰ��� ���� ���� ���� �߰�
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i = 0; i < arr.length; i++) {
					if(arr[i] != min) { //�ּڰ��� �ƴϸ� �ֱ�
						list.add(arr[i]);
					}
				}
				
				int[] answer;
				// ��츦 ������ �迭�� ���� �����ϱ�		
				if(list.size() == 0) { //list ũ�Ⱑ 0�̸�
					answer = new int[1];
					answer[0] = -1;
				} else { // ������ ������
					answer = new int[list.size()];
					for (int i = 0; i < list.size(); i++) {
						answer[i] = list.get(i);
					}
				}
				
		        return answer;        
	}
	
	
	
	
	// [�ַ��3] ��Ʈ���� ArrayŬ������ Ȱ���� ���
	public int[] removeSmallestNumber_3(int[] arr) {
		if (arr.length <= 1) return new int[]{ -1 }; //1���� �۰ų� ������ -1 ����
	      int min = Arrays.stream(arr).min().getAsInt();
	      return Arrays.stream(arr).filter(i -> i != min).toArray();
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
