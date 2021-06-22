package level_1;

/**
 * @codingTest <약수의 개수와 덧셈>
 *
 */
public class AdditionOfFactors {

	
	public int additionOfFactors(int left, int right) {
        int answer = 0;
        return answer;
    }
	
	
	
	
	// [솔루션1] 약수를 담을 변수=temp 를 1로 하고, 약수의 개수를 판별하며 계산한 방법
	public int additionOfFactors_1(int left, int right) {
		// 1.
        int answer = 0;
        // 2.
        for(int i=left; i<=right;i++){ // 범위만큼 반복
        	// 3. 
            int temp = 1;
            // 4.
            for (int j=1; j<=i/2;j++){ //***
            	// 5.
                if(i%j==0){ //***
                    temp++;
                }
            }
            // 6. 
            answer += temp%2 == 0 ? i : -i; //짝수이면 양수를 더하고, 홀수이면 음수를 더한다. 
        }
        return answer;
	}
	
	
	
	
	// [솔루션2] 약수를 담을 변수를 0으로 하고 계산한 방법
	public int additionOfFactors_2(int left, int right) {
		int answer = 0, count = 0; // 정답 변수, 약수를 카운트할 변수
        for(int i = left; i <= right; i++) { // left에서 right까지 반복
            for(int j = 1; j <= i/2; j++) // 절반 이상은 약수가 자기 자신 밖에 존재하지 않으므로 스킵
                if(i%j == 0) // j가 i의 약수이면
                    count++;

            answer = (++count%2 == 0) ? answer + i : answer - i; // 카운트 변수가 짝수이면 더하고 홀수이면 뺌
            count = 0; // 카운트 초기화
        }
        return answer;
	}
	
	
	
	
	// [솔루션3] 클래스 Math를 활용한 방법
	public int additionOfFactors_3(int left, int right) {
		int answer = 0;
        int s = (int)Math.ceil(Math.sqrt(left));
        int ss = s * s;
        for (int i = left; i <= right; i++) {
            if (i == ss) {
                answer -= i;
                s++;
                ss = s * s;
            } else {
                answer += i;
            }
        }
        return answer;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
