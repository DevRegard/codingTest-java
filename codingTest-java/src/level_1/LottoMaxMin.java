package level_1;

import java.util.Arrays;
import java.util.stream.LongStream;

/**
 * @codingTest �ζ��� �ְ� ������ ���� ����
 *	1. ��÷��ȣ�� ��ġ�ϴ� ���� cnt , �˾ƺ��� ���ϰԵ� ��ȣ�� ���� zeroCnt -> 0���� �ʱ�ȭ
 *	2. �ζǹ�ȣ�� foreash�� ������ item�� 0�̸� zeroCnt�� ���� 1�� ���� -> item �˻��ϵ��� continue
 *	3. item�� 0�� �ƴϸ� �Ʒ��� ������ ��÷��ȣ�� �ο��� ��ȣ�� ���� ��ġ�ϸ� cnt�� 1�� ����
 *		������ �μ��� ������ȣ�� �����ֱ� ���� break�� ����������
 *	4. �ְ� ������ Math.max(cnt+zeroCnt,1)�� ���
 *		�μ��� ���� ��ȣ���� ������ ���� �������� �ʾ��� ��
 *		��÷��ȣ�� ���� ��� ��ȣ�� ��ġ���� ���� ���
 *		cnt+zoreCnt�� 0�� �ǹǷ� Math.max�� ���� 0�϶��� ������ 1�� �ǰԲ� ����
 *		
 *	      ���� ������ Math.max(cnt,1)�� ���
 *		cnt�� 0�� ��� �� ������ 1�� �ǰԲ� ����, �׸��� cnt�� ���� �� �մ� 0������ 6�������� 
 *		����� ������ ����� ���ϱ� ���� ��� Math.max�� ������ ���ڸ� 7���� ���ֱ�
 *	
 */
public class LottoMaxMin {

	public int[] lottoMaxMin(int[] lottos, int[] win_nums) {
        //1. 
		int cnt = 0; //��÷��ȣ�� ��ġ�ϴ� ����
		int zeroCnt = 0; //�˾ƺ��� ���ϰ� �� ��ȣ�� ����
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
	
	
	
	//return�� ���
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
		case 6: return 1; //6���� ��ġ�ϸ� 1��
		case 5: return 2;
		case 4: return 3;
		case 3: return 2;
		case 2: return 5;
		default: return 6; //1�� ���� ��÷�̸� ��÷
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
