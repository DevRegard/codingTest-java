package level_1;

/**
 * @codingTest <Problems> ���� ��ȣ [1-33]
 *
 *	toCharArray(���ڿ������ε���,���ڿ�����) : �ν��Ͻ��� ������ �κ� ���ڿ��� �ִ� ���ڸ� �����ڵ� ���� �迭�� ����
 *
 *	isLowerCase() : �ҹ����̸� true
 *	isUpperCase() : �빮���̸� true
 *	charAt() : �����ڵ� ���� ���� ��ȯ
 *
 *	���ٽ�(�����Լ�) : �͸� �Լ� (Anonymous functions) �� ��Ī�ϴ� ���, �Լ��� ���� �ܼ��ϰ� ǥ���ϴ� ���
 *				     �ڵ尡 ����������, ���ʿ��� ������ �ּ�ȭ�ϸ�, ��Ƽ������ Ȱ���Ͽ� ����ó��
 *
 *	Stream : �پ��� �����͸� ǥ��ȭ�� ������� �ٷ�� ���� �󸮺귯�� (java 8)
 *	.map() : ��ҵ��� Ư�����ǿ� �ش��ϴ� ������ ��ȯ���ֱ�
 *	.mapToObj() : ���� ��Ʈ���� '��ü ��Ʈ��'���� ��ȯ
 *	.reduce() : stream�� ��Ҹ� �ϳ��� �ٿ����� ���
 *	.orElse("") : null�� �ƴϿ��� ��ü�� �ҷ��´�. (orElseGet�� null�̿��߸� �ҷ��´�.) 
 *	
 */
public class CaesarCipher {

	
	public String caesarCipher(String s, int n) {
        String answer = "";
        return answer;
    }
	
	
	
	
	// [�ַ��1] ���ڹ迭�� �����ϰ� "�迭����+n" �� z ���� ū ���� ���� ���� ����� �����ϴ� ���
	public String caesarCipher_1(String s, int n) {
		 String answer = "";
	      int z = (int)'z';
	      int Z = (int)'Z';
	      int a = (int)'a';
	      int A = (int)'A';
	      char[] temp = s.toCharArray(); //a���� z���� �ִ� ���� �迭 ����
	      
	      for(int i =0; i<temp.length; i++){
	          if(temp[i]>=a&& temp[i]<=z){
	              //�ҹ����ΰ��
	              temp[i] = (int)temp[i]+n > z ? (char)(a+(int)temp[i]+n-z-1) : (char)((int)temp[i]+n);
	              // z���� ������ �׳� ���ϱ� z���� ũ�� ��ü ���� ������ z���� ���� ���� ���� a�������� ���ϱ� (��, a�� �̹� +1 �����̹Ƿ� -1���ֱ�)
	          }else if(temp[i]>=A&& temp[i]<=Z){
	              //�빮���ΰ��
	              temp[i] = (int)temp[i]+n > Z ? (char)(A+(int)temp[i]+n-Z-1) : (char)((int)temp[i]+n);
	          }else{
	              //����
	              temp[i]=temp[i];
	          }
	      }
	      answer = new String(temp); //String�ȿ� char�迭 �ֱ�
	      return answer;
	}
	
	
	
	
	// [�ַ��2] n�� ���ĺ������� 26��ŭ ���� �������� �����ڵ�� ��ȯ�� ���� �����ϴ� ���
	public String caesarCipher_2(String s, int n) {
		String result = "";
	    n = n % 26; // n ������ 26 �� ������
	    for (int i = 0; i < s.length(); i++) {
	      char ch = s.charAt(i); //�����ڵ� ���� ���� ��ȯ
	      if (Character.isLowerCase(ch)) {
	        ch = (char) ((ch - 'a' + n) % 26 + 'a');
	      } else if (Character.isUpperCase(ch)) {
	        ch = (char) ((ch - 'A' + n) % 26 + 'A');
	      }
	      result += ch;
	    }
	        return result;
	}
	
	
	
	
	// [�ַ��3] ���ٽİ� ��Ʈ���� Ȱ���� ���
	public String caesarCipher_3(String s, int _n) {
		return s.chars().map(c -> {
            int n = _n % 26;
            if (c >= 'a' && c <= 'z') {
                return 'a' + (c - 'a' + n) % 26;
            } else if (c >= 'A' && c <= 'Z') {
                return 'A' + (c - 'A' + n) % 26;
            } else {
                return c;
            }
        }).mapToObj(c -> String.valueOf((char)c))
        .reduce((a, b) -> a + b).orElse("");
//		.reduce(1, (x,y) -> x * y);
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
