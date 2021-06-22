package level_1;

/**
 * @codingTest <��� ���� ��������>
 *	
 *	substring(int a1) : a1 ���� ������ ��������
 *	substring(int a1, int a2) : a1 ���� a2���� ��������
 *
 *	indexOf(int n / String str) : n �̳� str�� �ִ� �ε����� ��ȯ���ִ� �Լ�
 *	charAt(int n) : n��° ��ġ�� ���� ��ȯ���ִ� �Լ�
 */
public class GetMiddleLetter {

	
	    public String getMiddleLetter(String s) {
	        String answer = "";
	        return answer;
	    }
	
	
	
	
		// [�ַ��1] substring(a, b)�� Ȱ�� , ���ڿ����� ������ ������ ������ ���
		public String getMiddleLetter_1(String s) {
			String answer = "";
	          
	          //¦���� Ȧ���� ���� ����� �����Ѵ�! ¦���� 2���ڰ� ������ Ȧ���� 1���ڰ� ���� ���̴�.
	          if(s.length()%2==0) { //¦��
	              answer = s.substring(s.length()/2-1, s.length()/2+1);
	          } else {  //¦���� �ƴϸ� =Ȧ��
	              answer = s.substring(s.length()/2,s.length()/2+1);
	          }
	          
	          return answer;
		}
	
	
	
	
		// [�ַ��2] ���� ���Ϲ��� ����ؼ� ���ٷ� �ذ�
		public String getMiddleLetter_2(String word) {
			
			return word.substring((word.length()-1) / 2, word.length()/2 + 1); 
		}
	
	
	
	
		// [�ַ��3] ����ϰ� ������ ���� �ڵ� , �ַ��1�� ������ ���
		public String getMiddleLetter_3(String word) {
			 int a = word.length();
			    String word1;
			    if ( a % 2 == 0 )
			            word1 = word.substring(a/2 - 1, (a/2) + 1);
			    else
			            word1 = word.substring((a/2), (a/2) + 1);
			    return word1;
		}
	
	
	
	
	
	public static void main(String[] args) {
		GetMiddleLetter gml = new GetMiddleLetter();
		System.out.println(gml.getMiddleLetter_1("superpower"));
		System.out.println(gml.getMiddleLetter_2("superpower"));
		System.out.println(gml.getMiddleLetter_3("superpower"));
		
	}

}
