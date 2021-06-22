package level_1;

/**
 * @codingTest <[1��] �������>
 *
 */
public class SecretMap_1st {

	
	public String[] secretMap_1st(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        return answer;
    }
	
	
	
	
	// [�ַ��1] 2������ ���� ����ؼ� ������ ��� 
	public String[] secretMap_1st_1(int n, int[] arr1, int[] arr2) {
		 String[] answer = new String[n]; 
	        
	        // 2. �迭�� ũ�⸸ŭ �ݺ�.
	        for(int i =0;i<n;i++){
	            // 2-1. ��ȯ�� ������ ���� ���� �� ������ ��� ���� ����.
	            String str_x,str_y,str="";
	            // 2-2. �� �迭���� ���� ����.
	            int x = arr1[i];
	            int y = arr2[i];
	            // 2-3. �������� ��ȯ �� �ڸ��� ä���.
	            str_x = cal(x,n);
	            str_y = cal(y,n);
	            // 2-4. ���ǿ� �°� ���ڿ� ���� ����.
	            for(int j = 0;j<n;j++){
	                if(str_x.charAt(j) == '1' || str_y.charAt(j) == '1') str+="#";
	                else str+=" ";
	            }
	            // 2-5. �� �� �ϼ�.
	            answer[i] = str;
	        }
	        
	        return answer;
	}
	
	
	// [�ַ��1]
	// 1. ������ ��ȯ �޼ҵ� �� �ڸ��� n�� �°� 0�� ä���.
    public static String cal(int n,int len){
        String str="";
        
        // 1-1. ������ ��ȯ.
        while(n != 0){
            str = n%2 + str;
            n/=2;
        }
        
        // 1-2. n �ڸ��� ä���.
        while(str.length() != len){
            str = "0"+str;
        }
        
        return str;
    }
	
	
	
	
	// [�ַ��2] ��������ȯ �޼��� toBinaryString(), format(), replaceALL()�� Ȱ���� ���
	public String[] secretMap_1st_2(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n]; 
        
        for(int i =0;i<n;i++){
            // 1. arr1�� arr2�� ���ҵ��� �������� �ٲ� ��, or ��Ʈ ������ ����.
            String str=Integer.toBinaryString(arr1[i] | arr2[i]);
            // 2. 5�ڸ��� ���ڿ� ���·� ���˺���, 5�ڸ��� �ȵǴ� �������� �������� �������� ä���.
            str = String.format("%"+n+"s",str);
            // 3. 1->#, 0 -> ���� ���� �ٲ۴�.
            str = str.replaceAll("1" , "#");
            str = str.replaceAll("0" , " ");
            // 4. �� �� �ϼ�.
            answer[i] = str;
        }
        
        return answer;
	}
	
	
	
	
	// [�ַ��3] ����Լ��� ����� ���
	public String[] secretMap_1st_3(int n, int[] arr1, int[] arr2) {
		 String [] answer = new String[n];
	        int [] secretMap = new int[n];
	        for(int i = 0; i < n; i++) {
	            secretMap[i] = arr1[i] | arr2[i];
	            answer[i] = makeSharp(secretMap[i], n);
	        }
	        return answer;
	}
	
	
	// [�ַ��3] ����Լ�
	public String makeSharp(int n, int m) {
        if(n == 0) {
            if( m > 0) {
                String str = "";
                for(int i = 0; i < m; i++) {
                    str += " ";
                }
                return str;
            }
            else return "";
        }
        else {
            return n % 2 == 0 ? makeSharp(n/2, m-1) + " " : makeSharp(n/2, m-1) + "#"; 
        }
    }
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
