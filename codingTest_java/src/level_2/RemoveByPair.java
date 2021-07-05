package level_2;

import java.util.Stack;
import java.util.Vector;

/**
 * @codingTest <Problems> 짝지어 제거하기 [2-5]
 *
 */
public class RemoveByPair {

	
	public int removeByPair(String s)
    {
        int answer = -1;
        return answer;
    }
	
	
	
	
	
	// [솔루션 1] Stack을 이용해서 해결한 방법
	public int removeByPair_1(String s)
	{
		Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) 
          if(!stack.isEmpty() && stack.peek() == c) stack.pop();
          else stack.push(c);
         
        return stack.isEmpty() ? 1 : 0;
	}
	
	
	
	
	
	// [솔루션 2] 바이트배열을 사용하여 해결한 방법
	public int removeByPair_2(String s)
	{
		byte[] bytes = s.getBytes();
        int length = bytes.length;

        Stack<Integer> stack = new Stack<>();

        int iLeft = 0, iRight = iLeft + 1;
        for (; iLeft < length && iRight < length; ) {
            if (bytes[iLeft] == bytes[iRight]) {
                // bytes[iLeft] = 0;
                // bytes[iRight] = 0;

                if (stack.empty()) {
                    /*
                    while (iLeft >= 0 && bytes[iLeft] == 0) iLeft--;
                    while (iRight < length && bytes[iRight] == 0) iRight++;

                    if (iLeft < 0) iLeft = iRight;
                    if (iRight <= iLeft) iRight = iLeft + 1;
                    */

                    iLeft = iRight + 1;
                    iRight = iLeft + 1;
                } else {
                    iLeft = stack.pop();
                    iRight++;
                }
            } else {
                stack.push(iLeft);

                iLeft = iRight;
                iRight = iLeft + 1;
            }
        }

        return iLeft >= length && iRight >= length ? 1 : 0;
	}
	
	
	
	
	
	// [솔루션 3] Vector를 사용해서 해결한 방법
	public int removeByPair_3(String s)
	{
		char[] chArr = s.toCharArray();
        Vector<Character> tempList = new Vector<>();
        int size;
        for(char ch:chArr) {
            if((size = tempList.size())!=0) {
                if(ch == tempList.lastElement()) {
                    tempList.removeElementAt(size-1);
                    continue;
                }
            }
            tempList.add(ch);
        }
        int answer = tempList.size() == 0? 1:0;
        return answer;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
