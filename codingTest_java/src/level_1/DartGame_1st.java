package level_1;

import java.util.Stack;

/**
 * @codingTest <[1차] 다트 게임>
 *
 */
public class DartGame_1st {

	
	public int dartGame_1st(String dartResult) {
        int answer = 0;
        return answer;
    }
	
	
	
	
	// [솔루션1] 라이브러리 사용하지 않고, 가독성 좋게 구현한 방법
	public int dartGame_1st_1(String dartResult) {
		 int answer = 0;
	        int n = 0, index = 0, nowInt = 0;
	        int[] score = new int[3]; // 각 단계별 획득 점수
	 
	        for (int i = 0; i < dartResult.length(); i++) {
	            char c = dartResult.charAt(i);
	 
	            /* 점수일 경우 */
	            if (Character.isDigit(c)) {
	                n = 0;
	                if (c == '1' && dartResult.charAt(i + 1) == '0') {
	                    n = 10;
	                    i++; // 인덱스 다음으로 증가
	                } else {
	                    n = Character.getNumericValue(c);
	                }
	                
	                nowInt++;
	                
	            /* 보너스 or 옵션일 경우 */
	            } else {
	                switch (c) {
	                case 'S':
	                    score[index++] = (int) Math.pow(n, 1);    // 1제곱
	                    break;
	                    
	                case 'D':
	                    score[index++] = (int) Math.pow(n, 2);    // 2제곱
	                    break;
	                    
	                case 'T':
	                    score[index++] = (int) Math.pow(n, 3);    // 3제곱
	                    break;
	                    
	                case '*':    // 스타상 :  바로 전에 얻은 점수를 각 2배
	                    index = index - 2 < 0 ? 0 : index - 2;
	                    while (index < nowInt) {
	                        score[index++] *= 2;
	                    }
	                    n = 0;
	                    break;
	                    
	                case '#':    // 아차상 :  해당 점수는 마이너스
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
	
	
	
	
	// [솔루션2] Stack을 활용해서 구현한 방법
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
	
	
	
	
	// [솔루션3] 가독성이 좋은 코드, 불필요한 계산은 생략
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
