package level_1;

import java.util.Arrays;
import java.util.stream.LongStream;

/**
 * @codingTest 로또의 최고 순위와 최저 순위
 *	1. 당첨번호와 일치하는 개수 cnt , 알아보지 못하게된 번호의 개수 zeroCnt -> 0으로 초기화
 *	2. 로또번호를 foreash로 돌려서 item이 0이면 zeroCnt의 값을 1씩 증가 -> item 검색하도록 continue
 *	3. item이 0이 아니면 아래로 내려가 당첨번호와 민우의 번호를 비교해 일치하면 cnt에 1씩 증가
 *		빠르게 민수의 다음번호를 비교해주기 위해 break로 빠져나오기
 *	4. 최고 순위는 Math.max(cnt+zeroCnt,1)를 사용
 *		민수가 찍은 번호들이 낙서에 의해 가려지지 않았을 때
 *		당첨번호와 비교해 모든 번호가 일치하지 않은 경우
 *		cnt+zoreCnt는 0이 되므로 Math.max를 통해 0일때엔 무조건 1이 되게끔 설정
 *		
 *	      최저 순위는 Math.max(cnt,1)를 사용
 *		cnt가 0일 경우 또 무조건 1이 되게끔 설정, 그리고 cnt가 가질 수 잇는 0개에서 6개까지의 
 *		경우의 수에서 등수를 구하기 위해 방금 Math.max로 설정한 숫자를 7에서 빼주기
 *	
 */
public class LottoMaxMin {

	public int[] lottoMaxMin(int[] lottos, int[] win_nums) {
        //1. 
		int cnt = 0; //당첨번호와 일치하는 개수
		int zeroCnt = 0; //알아보지 못하게 된 번호의 개수
		for (int lotto : lottos) {
			//2.
			if (lotto == 0) {
				zeroCnt ++;
				continue;
			}
			for (int win_num : win_nums) {
				//3.
				if (win_num == lotto) {
					cnt ++;
					break;
				}
			}
		}
		//4.
		return new int[] {7 - Math.max(cnt+zeroCnt, 1), 7 - Math.max(cnt, 1)};
    }
	
	
	
	
	public int[] lottoMaxMin_1(int[] lottos, int[] win_nums) {
		//1.
		int cnt = 0;
		int zeroCnt = 0;
		for (int lotto : lottos) {
			//2.
			if (lotto == 0) {
				zeroCnt ++;
				continue;
			}
			for (int win_num : win_nums) {
				//3.
				if (win_num == lotto) {
					cnt ++;
					break;
				}
			}
		}
		
		//4.
		return new int[] {7-Math.max(cnt+zeroCnt, 1), 7-Math.max(cnt, 1)};
	}
	
	
	
	//return만 사용
	public int[] lottoMaxMin_2(int[] lottos, int[] win_nums) {
		return LongStream.of(
				(lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(win_nums).anyMatch(w -> w == l) || l == 0).count(),
				(lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(win_nums).anyMatch(w -> w == l)).count()
			)
				.mapToInt(op -> (int) (op > 6 ? op - 1 : op))
				.toArray();
	}
	
	
	
	
	public int[] lottoMaxMin_3(int[] lottos, int[] win_nums) {
		int count = 0;
		int zeroCount = 0;
		for (int i = 0; i < 6; i++) {
			if (lottos[i] == 0) {
				zeroCount++;
				continue;
			}
			for (int k = 0; k < 6; k++) {
				if (win_nums[k] == lottos[i]) count++;
			}
		}
		return new int[] {rank(zeroCount + count), rank(count)};
	}
	
	public int rank(int score) {
		switch (score) {
		case 6: return 1; //6개가 일치하면 1위
		case 5: return 2;
		case 4: return 3;
		case 3: return 2;
		case 2: return 5;
		default: return 6; //1개 이하 당첨이면 낙첨
		}
	}
	
	
	public static void main(String[] args) {
		LottoMaxMin lmn = new LottoMaxMin();
		int[] lottos = {44,1,0,0,31,25};
		int[] win_nums = {31,10,45,1,6,19};
		
		System.out.println(lmn.lottoMaxMin(lottos, win_nums));
		System.out.println(lmn.lottoMaxMin_1(lottos, win_nums));
		System.out.println(lmn.lottoMaxMin_2(lottos, win_nums));
		System.out.println(lmn.lottoMaxMin_3(lottos, win_nums));
		
	}

}
