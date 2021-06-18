package level_1;

/**
 * @codingTest 음양 더하기
 *
 */
public class AddYinYang {

	
    public int addYinYang(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for (int i = 0; i < signs.length; i++) {
			if (signs[i]) { //true(양수)이면
				answer += absolutes[i]; //그대로 더하기
			} else { //false(음수)이면
				answer -= absolutes[i];
			}
		}
        return answer;
    }
    
    
    
    
    public int addYinYang_1(int[] absolutes, boolean[] signs) {
    	int answer = 0;
    	
    	for (int i = 0; i < signs.length; i++) { //부호 개수만큼 반복
			if (signs[i]) { //참이면 더하기
				answer += absolutes[i]; 
			} else { //거짓이면 빼기
				answer -= absolutes[i];
			}
		}
    	return answer;
    }
    
    
    
    
    public int addYinYang_2(int[] absolutes, boolean[] signs) {
    	int answer = 0;
    	for (int i = 0; i < signs.length; i++) { //signs 배열 길이만큼 반복
			answer += absolutes[i] * (signs[i] ? 1:-1); //참이면 양수를 더하고, 거짓이면 음수를 answer에 더한다.
		}
    	return answer;
    }
    
    
    
    
    public int addYinYang_3(int[] absolutes, boolean[] signs) {
    	int answer = 0;
    	
    	for (int i = 0; i < absolutes.length; i++) { //숫자배열 길이만큼 반복
			if (signs[i] == false) { //부호가 음수이면
				absolutes[i] *= -1; //숫자배열을 음수로 바꾼다.
			} 
			answer += absolutes[i]; //양수와 음수가 모인 배열를 전부 더한다.
		}
    	return answer;
    }
    
    
    
    
	public static void main(String[] args) {
		AddYinYang ayy = new AddYinYang();
		int[] absolutes = {4,7,12};
		boolean[] signs = {true,false,true};
		
		System.out.println(ayy.addYinYang(absolutes, signs));
		System.out.println(ayy.addYinYang_1(absolutes, signs));
		System.out.println(ayy.addYinYang_2(absolutes, signs));
		System.out.println(ayy.addYinYang_3(absolutes, signs));
	}

}
