package level_1;


/**
 * @codingTest 키패드 누르기 <보류>
 *
 *	append() : 기존 문자열의 뒤쪽에 문자열을 추가하는 기능
 *
 *	번호 간의 거리 계산 = ((현재 번호 - 누를 번호) / 3 + ((현재 번호 - 누를 번호) % 3)
 *
 *	
 */
public class KeypadPress {

	
	public String keypadPress(int[] numbers, String hand) {
        String answer = "";
        return answer;
    }
	

	
	// case문에서 람다식은 JAVA 14 에서만 지원되서 사용불가 
	public String keypadPress_1(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();
//		int left = 10, right = 12;
		for (int num : numbers) {
			if (num == 0) num = 11;
//			switch (num % 3) {
//				case 0 -> { //R
//					answer.append("R");
//					right = num;
//				}
//					
//				case 1 -> { //L
//					answer.append("L");
//					left = num;
//				}
//				
//				case 2 -> { //L or R
//					int minusL = (num > left) ? num - left : left - num; //***
//					int minusR = (num > right) ? num - right : right - num;
//					int distanceL = (minusL % 3) + (minusL / 3);
//					int distanceR = (minusR % 3) + (minusR / 3);
//					
//					if (distanceL < distanceR) { //L보다 R이 더 멀면
//						answer.append("L");
//						left = num;
//					} else if (distanceR < distanceL) { //R보다 L이 더 멀면
//						answer.append("R");
//						right = num;
//					} else {
//						answer.append(hand.equals("right") ? "R" : "L"); //right이면 R, 아니면 L
//						if (hand.equals("right")) right = num;
//						else left = num;
//					}
//				}
//			
//			} //switch end
		}
		
		return answer.toString();
	}
	
//____________________________________________________________________________
	//keypadPress_2
	
	int[][] numpadPos = { //0부터 9까지 좌표 {y,x}
			{3,1}, //0
			{0,0}, //1
			{0,1}, //2
			{0,2}, //3
			{1,0}, //4
			{1,1}, //5
			{1,2}, //6
			{2,0}, //7
			{2,1}, //8
			{2,2}, //9
			
	};
	
	//초기 위치
	int[] leftPos = {3,0};
	int[] rightPos = {3,2};
	String hand;
	
	public String keypadPress_2(int[] numbers, String hand) {
		this.hand = (hand.equals("right")) ? "R" : "L";
		
		String answer = "";
		for (int num : numbers) {
			String Umji = pushNumber(num);
			answer += Umji;
			
			if(Umji.equals("L")) {leftPos = numpadPos[num]; continue;}
			if(Umji.equals("R")) {rightPos = numpadPos[num]; continue;}
		}
		
		return answer;
	}
	
	//num 버튼을 누를 때 어디 손을 사용하는가
	private String pushNumber(int num) {
		if(num==1 || num==4 || num==7) return "L";
		if(num==3 || num==6 || num==9) return "R";
		
		//2,5,8,0  일때 어디 손가락이 가까운가
		if(getDist(leftPos, num) > getDist(rightPos, num)) return "R";
		if(getDist(leftPos, num) < getDist(rightPos, num)) return "L";
		
		//같으면 손잡이
		return this.hand;
	}
	
	//해당 위치와 번호 위치의 거리
	private int getDist(int[] pos, int num) {
		return Math.abs(pos[0]-numpadPos[num][0] + Math.abs(pos[1]-numpadPos[num][1]));
	}

	
//____________________________________________________________________________	
	//keypadPress_3
	
	int tempL = 10;
	int tempR = 12;
	String myhand;
	
	public String keypadPress_3(int[] numbers, String hand) {
		myhand = ((hand.equals("right"))? "R":"L");
		String answer = "";
		
		for (int i = 0; i < numbers.length; i++) {
			switch (numbers[i]) {
				case 1: case 4: case 7:
					answer += "L";
					tempL = numbers[i];
					break;
					
				case 3: case 6: case 9:
					answer += "R";
					tempR = numbers[i];
					break;
					
				default:
					String tempHand = checkHand(numbers[i]);
					if (tempHand.equals("R"))
						tempR = numbers[i] + ((numbers[i] == 0) ? 11:0);
					else tempL = numbers[i] + ((numbers[i] == 0) ? 11:0);
					answer += tempHand;
					break;
			}
		}
		
		return answer;
	}
	
	
	private String checkHand(int tempNum) {
		int leftDistance = 0;
		int rightDistance = 0;
		if(tempNum == 0) tempNum = 11;
		
		leftDistance = Math.abs((tempNum-1)/3 - (tempL-1)/3 + Math.abs(tempNum-1)%3 - (tempL-1)%3);
		rightDistance = Math.abs((tempNum-1)/3 - (tempR-1)/3 + Math.abs(tempNum-1)%3 - (tempR-1)%3);
		System.out.println(tempNum + ": " + leftDistance + ", " + rightDistance);
		return ((leftDistance == rightDistance)? myhand: (leftDistance > rightDistance)? "R":"L");
	}
	
	
//____________________________________________________________________________
	
	
	public static void main(String[] args) {
		KeypadPress kpp = new KeypadPress();
		int[] numbers = {1,3,4,5,8,2,1,4,5,9,5}; //LRLLLRLLRRL
		String hand = "right";				     //LRLRRLLLRRL
		
//		System.out.println(kpp.keypadPress_1(numbers, hand)); //case문 람다식 사용불가 (코드는 정답)
		System.out.println(kpp.keypadPress_2(numbers, hand)); //LRLRLRLLRRL //4번째 R로 나오는 현상 (-1)
		System.out.println(kpp.keypadPress_3(numbers, hand)); //LRLRRLLLRRL //4,5,6번째 반대로 (-3)
	}

}
