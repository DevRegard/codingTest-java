package level_1;

/**
 * @codingTest <Problems> 콜라츠 추측 [1-43]
 *	콜라츠 추측 : 짝수는 2n, 홀수는 3n+1 을 반복해서 모든 숫자가 1이 된다.
 *	콜라츠 추측인 이유 : 아직 모든 자연수가 성립함을 증명하지 못해서이다. 컴퓨터로 2^68 까지 증명 [21-06-29]
 *				  27을 증명하려면 111번을 거쳐야 하고, 77번째는 9232가 정점이 된다.
 */
public class ColatzGuess {

	
	public int colatzGuess(int num) {
        int answer = 0;
        return answer;
    }
	
	
	
	
	// [솔루션1] for문의 횟수를 500번으로 한정하고, long으로 형변환, 삼항연산자를 적용한 방법
	public int colatzGuess_1(int num) {
		long n = (long)num;
	    for(int i =0; i<500; i++){ //자연수 626331을 증명하려면 500번 초과 (입출력 결과는 -1이 리턴되야함)
	      if(n==1) return i;
	      n = (n%2==0) ? n/2 : n*3+1;            
	    }
	    return -1;
	}
	
	
	
	
	// [솔루션2] 조건문만 사용한 방법
	int answer = 0;
	public int colatzGuess_2(int num) {
		
		if(num == 1){ //결과가 1이 되면
            return answer;
        }
        if(answer==500){ //결과가 500회가 되면
            return -1;
        }
        answer++; //결과가 1이 만족하면 1씩 증가
        if (num % 2 == 1) {
            // 홀수
            return colatzGuess_2(num * 3 + 1);
        } else{
            // 짝수
            return colatzGuess_2(num / 2);
        }
	}
	
	
	
	
	// [솔루션3] While문을 정하고 조건문을 사용한 방법
	public int colatzGuess_3(int num) {
		int answer = 0;
        int cnt = 0;

        while (cnt <= 501) {

            if (num % 2 == 0) {
                if (num != 1) {
                    num = num / 2;
                    cnt++;
                    answer = cnt;
                } else {
                    break;
                }
            } else {
                if (num != 1) {
                    num = (num * 3) + 1;
                    cnt++;
                    answer = cnt;
                } else {
                    break;
                }
            }

            if (cnt > 500) {
                answer = -1;
            } else if (cnt <= 500 && num == 1) {
                break;
            } else
                continue;
        }

        return answer;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
