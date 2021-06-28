package level_1;

import java.util.Arrays;

/**
 * @codingTest <Problems> ���� ������������ ��ġ�ϱ� [1-38]
 *
 *	�������� : ������ �� ���� ���� ���Ͽ� �� ū ���� �������� ������ ���� �˰���
 *				1. ����ӵ��� �ſ� ������.
 *				2. ������ ����.
 *				3. ������ ���ĵǾ� �ִ� �迭�� �ð� ���⵵�� ������ ��� �����Ѵ�. = ȿ�� �ް�
 *
 *	toString() : String������ ��ȯ (������ �ڵ�, �����ڵ庯ȯ ���� ȿ��)
 *	chars() : int���� ��ȯ(char���� �ƴϴ�.)
 *	sorted() : �����ϴ� �޼���
 *	forEach(���� - > �ݺ�ó��(����)) :
 */
public class PlacingIntegersInDescendingOrder {

	
	public long placingIntegersInDescendingOrder(long n) {
        long answer = 0;
        return answer;
    }
	
	
	
	
	// [�ַ��1] ���������� Ȱ���� �ذ� ���
	public long placingIntegersInDescendingOrder_1(long n) {
		// String.valueof() �޼ҵ带 ���Ͽ� longŸ���� StringŸ������ ���� ��,
        // String.toCharArray() �޼ҵ带 ���Ͽ� StringŸ���� char[]�� �����Ѵ�.
        char[] arr = String.valueOf(n).toCharArray();
 
        // �ӽ� char����
        char temp = 'a';
        // ���������� ���� ���� ���ġ
        for(int i = arr.length - 1; i > -1; i--) {
            for(int j=0; j < i; j++) {
                if(arr[j] < arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        // char[] �� String
        String str = "";
        for(char i : arr) {
            str += i;
        }
        // Long.parseLong()�޼ҵ带 ���Ͽ� String �� LongŸ�� ��ȯ
        return Long.parseLong(str);
	}
	
	
	
	
	// [�ַ��2] ���ٽ� forEach()�� Ȱ���� ���
	String res = "";
	public int placingIntegersInDescendingOrder_2(int n) {
		res = "";
        Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
        return Integer.parseInt(res);
	}
	
	
	
	
	// [�ַ��3] StringBuilder Ŭ������ ����� ���
	public long placingIntegersInDescendingOrder_3(int n) {
		String str = Integer.toString(n);
        char[] c = str.toCharArray();
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder(new String(c,0,c.length));  
        return Integer.parseInt(((sb.reverse()).toString()));
	}
	
	
	
	
	// [��������]
	public static void testArraySort2() {
        
        // ��������(Bubble Srot) : ����(������) ������(ū��)���� ���������� ���� ��ȯ
        // ������ �� ���� ���� ���Ͽ�
        // �� ū���� �������� ������ ���� �˰���
        // �̹� ������ ��� ���� �Ǿ� �ִ� �����Ϳ�
        // ���� ����ӵ��� �ſ� ������, ������ ����.
        // ��, ������ ���ĵǾ� �ִ� �迭�� ���� �� ������
        // �ð� ���⵵�� ������ ��� �����Ͽ� ȿ���� �ް��� ��������.
    
        int[] array = {6,4,2,1,3,5}; //array.length = 6, []�� 5����
        // 4, 6, 2, 1, 3, 5
        // 4, 2, 6, 1, 3, 5
        // 4, 2, 1, 6, 3, 5
        // 4, 2, 1, 3, 6, 5
        // 4, 2, 1, 3, 5, 6
        
        // 2, 4, 1, 3, 5, 6
        // 2, 1, 4, 3, 5, 6
        // 2, 1, 3, 4, 5, 6
        // 2, 1, 3, 4, 5, 6
        
        // 1, 2, 3, 4, 5, 6
        int temp = 0; // ��ȯ�� �ӽ� ����
        
        // �迭�� ���� -1 (������ ���� ����)
        for(int i = array.length - 1; i > -1; i--) {    // i = 5 �� 4 �� 3 �� 2 �� 1 �� 0
            for(int j = 0; j < i; j++) {                 // i = 5 : j = 0 �� 1 �� 2 �� 3 �� 4 
                if(array[j] > array[j+1]) {             // 0 < 1 �� 1 < 2 �� 2 < 3 �� 3 < 4 �� 4 < 5
                    temp = array[j];                    // temp�� 0�� �־��ش�. temp = 6
                    array[j] = array[j+1];                // 0�� 1�� �־��ش�. array[0] = 4
                    array[j+1] = temp;                    // 1�� temp�� �־��ش�. // array[1] = 6, ��ȯ ����.
                }
                
            }
        }
        
        System.out.println(Arrays.toString(array)); //arraysŬ������ toString�޼ҵ� : []���·� �̾Ƽ� ó������.        
                                                    //������.toString()�� �ϰ� �Ǹ� hashcode���� �������� �ȴ�.
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
