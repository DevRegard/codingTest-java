package level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @codingTest <K번째수>
 *
 */
public class Kth_Number {

	public int[] kth_Number(int[] array, int[][] commands) {
        int[] answer = {};
        return answer;
    }
	
	
	
	//ArrayList , Collections 사용한 솔루션
	public int[] kth_Number_1(int[] array, int[][] commands) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {

			for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
				arr.add(array[j]);
			}
			Collections.sort(arr);
			answer[i] = arr.get(commands[i][2]-1);
			arr.clear();
		}
        return answer;
	}
	
	
	
	//Arrays 사용한 솔루션
	public int[] kth_Number_2(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
	}
	
	
	
	
	//비라이브러리, 퀵정렬을 사용한 솔루션
	public int[] kth_Number_3(int[] array, int[][] commands) {
		int n = 0;
        int[] ret = new int[commands.length];

        while(n < commands.length){
            int m = commands[n][1] - commands[n][0] + 1;

            if(m == 1){
                ret[n] = array[commands[n++][0]-1];
                continue;
            }

            int[] a = new int[m];
            int j = 0;
            for(int i = commands[n][0]-1; i < commands[n][1]; i++)
                a[j++] = array[i];

            sort(a, 0, m-1);

            ret[n] = a[commands[n++][2]-1];
        }

        return ret;
	}
	
	
	//솔루션3에서 사용
	void sort(int[] a, int left, int right){
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        do{
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr){
                int temp = a[pl];
                a[pl] = a[pr];
                a[pr] = temp;
                pl++;
                pr--;
            }
        }while(pl <= pr);

        if(left < pr) sort(a, left, pr);
        if(right > pl) sort(a, pl, right);
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
