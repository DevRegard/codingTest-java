package level_1;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @codingTest <Problems> ���簢�� ����� [1-49]
 *
 *	System.out.print�� 
 *	System.out.prIntln ��� ����
 *
 *	IntStream : range�� forEach�� ���� �ݺ����� ǥ���� ���ٽ� Ŭ����
 *	range(a,b) : a�� ���� b�������� (== a ~ b-1)
 *	forEach(���� -> �ݺ�ó��(����)) : ������ �����ϰ� -> �ݺ��� ����� ������ �ִ´�. 
 *	append() : �ش� ���ڿ��� �������� �μ����� �߰����ִ� �޼��� (�������� ó�� �ӵ� ����)
 */
public class RectangularStar {

	// [�ַ��1] 2�� for������ ����� ���
	/*public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); //����[��]
        int b = sc.nextInt(); //����[��]
        
        for (int i=0; i<b; i++) { //���� ����
            for (int j=0; j<a; j++) { //���� ����
                System.out.print("*");
            }
            System.out.println(); 
        }*/
        
        
        
        
        
    // [�ַ��2] IntStream Ŭ���� ����� ���, forEach()
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int a = sc.nextInt(); //����[��]
    	int b = sc.nextInt(); //����[��]
    	
    	StringBuilder sb = new StringBuilder();
        IntStream.range(0, a).forEach(s -> sb.append("*"));
        IntStream.range(0, b).forEach(s -> System.out.println(sb.toString()));
        
        	
    }
}
