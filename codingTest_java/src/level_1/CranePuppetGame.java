package level_1;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
	
/**
 * @codingTest <Problems> ũ���� �����̱� ���� [1-2]
 * 
 * 	Stack : LIFO (����,��������,��Ʈ�� ����� ������)
 * 			�� �� �������� �ڷ�(������)�� �ְ� �� �� �ִ� ������ �ڷ� ����
 * 			EX) ���ͳ� �������� '�ڷΰ���', '�����ΰ���' ��ư ����
 *
 */
public class CranePuppetGame {
	
	public int craneGame(int[][] board, int[] moves) {
        int answer = 0;
        return answer;
    }
	
	
	
	
	// [BEST]
	// [�ַ�� 1] Stack�� �̿��ؼ� �ذ��� ���
	public int craneGame1(int[][] board, int[] moves) {
		int answer = 0;
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0); //stack�� �� �� ���� �� (�ƹ��͵� ������ ����)
		
		for (int move : moves) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][move - 1] != 0) { //Stack(�ٱ���)�� ���� �� ����� board[j][move-1]�� ������ �� //board�� ������ �ִٸ�
					if (stack.peek() == board[j][move - 1]) { //���ٸ� ������ ������ ������ pop -> answer += 2
						stack.pop();
						answer += 2;
					} else {
						stack.push(board[j][move - 1]); //�ٸ��ٸ� Stack�� board[j][move - 1]�� push //�ٸ��ٸ� �ٱ��Ͽ� �ֱ�  
					}
					board[j][move - 1] = 0;
					break;
				}
			}
		}
		
		return answer;
	}


	
	
	
	// [�ַ�� 2] List, ArrayList�� Ȱ���ؼ� �ذ��� ���
	public int craneGame2(int[][] board, int[] moves) {
		int answer = 0;
		
		List<Integer> nums = new ArrayList<Integer>();
		
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][moves[i]-1] != 0) {
					nums.add(board[j][moves[i]-1]);
					board[j][moves[i]-1] = 0;
					break;
				}
			}
		}
		
		for (int k = 0; k < nums.size(); k++) {
			if (k != nums.size()-1) {
				if (nums.get(k) == nums.get(k+1)) {
					nums.remove(k);
					nums.remove(k);
					answer++;
					k = -1;
				}
			}
		}
		
		return answer*2;
	}
	
	
	
	
	
	// [�ַ�� 3] Stack�� Ȱ���ؼ� �ذ��� 2��° ���
	static Stack<Integer> stack = new Stack<>();
	static int answer3 = 0;
	
	public int craneGame3(int[][] board, int[] moves) {
		
		for (int idx : moves) {
			board = pick(board, idx - 1);
		}
		
		return answer3;
	}

	
	static int[][] pick(int[][] board, int idx) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][idx] == 0) continue;
			
			if (!stack.isEmpty() && stack.peek() == board[i][idx]) {
				answer3 += 2;
				stack.pop();
				board[i][idx] = 0;
				break;
			}
			stack.push(board[i][idx]);
			board[i][idx] = 0;
			break;
		}
		
		return board;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		CranePuppetGame cpg = new CranePuppetGame();
		int[][] boardInput = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] movesInput = {1,5,3,5,1,2,1,4};
		
		
		//���ÿ� �����ϸ� 4,0,0,... �� �����Ƿ� �ϳ��� �����ؼ� �׽�Ʈ
		//answer = 4
		System.out.println(cpg.craneGame(boardInput, movesInput));
		System.out.println(cpg.craneGame1(boardInput, movesInput));
		System.out.println(cpg.craneGame2(boardInput, movesInput)); //craneGame1�� ���� ��½õ��ϸ� 0���� ���
		System.out.println(cpg.craneGame3(boardInput, movesInput));
		
	}

}
