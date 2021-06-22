package level_1;

import java.util.Stack;

/**
 * @codingTest <[1��] ��Ʈ ����>
 *
 */
public class DartGame_1st {

	
	public int dartGame_1st(String dartResult) {
        int answer = 0;
        return answer;
    }
	
	
	
	
	// [�ַ��1] ���̺귯�� ������� �ʰ�, ������ ���� ������ ���
	public int dartGame_1st_1(String dartResult) {
		 int answer = 0;
	        int n = 0, index = 0, nowInt = 0;
	        int[] score = new int[3]; // �� �ܰ躰 ȹ�� ����
	 
	        for (int i = 0; i < dartResult.length(); i++) {
	            char c = dartResult.charAt(i);
	 
	            /* ������ ��� */
	            if (Character.isDigit(c)) {
	                n = 0;
	                if (c == '1' && dartResult.charAt(i + 1) == '0') {
	                    n = 10;
	                    i++; // �ε��� �������� ����
	                } else {
	                    n = Character.getNumericValue(c);
	                }
	                
	                nowInt++;
	                
	            /* ���ʽ� or �ɼ��� ��� */
	            } else {
	                switch (c) {
	                case 'S':
	                    score[index++] = (int) Math.pow(n, 1);    // 1����
	                    break;
	                    
	                case 'D':
	                    score[index++] = (int) Math.pow(n, 2);    // 2����
	                    break;
	                    
	                case 'T':
	                    score[index++] = (int) Math.pow(n, 3);    // 3����
	                    break;
	                    
	                case '*':    // ��Ÿ�� :  �ٷ� ���� ���� ������ �� 2��
	                    index = index - 2 < 0 ? 0 : index - 2;
	                    while (index < nowInt) {
	                        score[index++] *= 2;
	                    }
	                    n = 0;
	                    break;
	                    
	                case '#':    // ������ :  �ش� ������ ���̳ʽ�
	                    score[index-1] *= -1;    
	                    n = 0;
	                    break;
	                }
	            }
	        }
	        
	        for (int i : score) {
	            answer += i;
	        }
	 
	        return answer;
	}
	
	
	
	
	// [�ַ��2] Stack�� Ȱ���ؼ� ������ ���
	public int dartGame_1st_2(String dartResult) {
		 Stack<Integer> stack = new Stack<>();
	        int sum = 0;
	        for (int i = 0; i < dartResult.length(); ++i) {
	            char c = dartResult.charAt(i);
	            if (Character.isDigit(c)) {
	                sum = (c - '0');
	                if (sum == 1 && i < dartResult.length() - 1 && dartResult.charAt(i + 1) == '0') {
	                    sum = 10;
	                    i++;
	                }
	                stack.push(sum);
	            } else {
	                int prev = stack.pop();
	                if (c == 'D') {
	                    prev *= prev;
	                } else if (c == 'T') {
	                    prev = prev * prev * prev;
	                } else if (c == '*') {
	                    if (!stack.isEmpty()) {
	                        int val = stack.pop() * 2;
	                        stack.push(val);
	                    }
	                    prev *= 2;
	                } else if (c == '#') {
	                    prev *= (-1);
	                }
	                // System.out.println(prev);
	                stack.push(prev);
	            }
	        }
	        int totalScore = 0;
	        while (!stack.isEmpty()) {
	            totalScore += stack.pop();
	        }
	        return totalScore;
	}
	
	
	
	
	// [�ַ��3] �������� ���� �ڵ�, ���ʿ��� ����� ����
	public int dartGame_1st_3(String dartResult) {
		String[] arrTemp = dartResult.split("");
        String sTarget = "";
        int nBeforeScore = 0;
        int nPresentScore = 0;
        int nTotalScore = 0;
        for (int i = 0; i < arrTemp.length; i++) {
            if(arrTemp[i].equals("1") || arrTemp[i].equals("2") || arrTemp[i].equals("3") || arrTemp[i].equals("4") || arrTemp[i].equals("5") ||
                    arrTemp[i].equals("6") || arrTemp[i].equals("7")|| arrTemp[i].equals("8") || arrTemp[i].equals("9") || arrTemp[i].equals("0")) {
                sTarget += arrTemp[i];
            }else if(arrTemp[i].equals("S") || arrTemp[i].equals("D") || arrTemp[i].equals("T")){
                nTotalScore += nBeforeScore;
                nBeforeScore = nPresentScore;
                nPresentScore = Integer.parseInt(sTarget);
                sTarget = "";
                if(arrTemp[i].equals("D")) {
                    nPresentScore = (int) Math.pow(nPresentScore, 2);
                }else if(arrTemp[i].equals("T")) {
                    nPresentScore = (int) Math.pow(nPresentScore, 3);
                }
            }else if(arrTemp[i].equals("*") || arrTemp[i].equals("#")){
                if(arrTemp[i].equals("*")) {
                    nBeforeScore = nBeforeScore * 2;
                    nPresentScore = nPresentScore * 2;
                }else if(arrTemp[i].equals("#")) {
                    nPresentScore = nPresentScore * -1;
                }
            }
        }
        nTotalScore += nBeforeScore;
        nTotalScore += nPresentScore;

        return nTotalScore;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
