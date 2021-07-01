package level_2;

/**
 * @codingTest <Problems> 단체사진 찍기 [2-1]
 *	
 * 알고리즘 <완전탐색> : 모든 경우의 수를 다 체크해서 정답을 도출하는 방법 [Brute Force]
 * 		
 * 	1) Brute Force 기법
 * 	2) 순열 (Permutation)
 * 	3) 재귀 (Recursive)
 * 	4) 비트마스크 (BitMask)
 * 	5) BFS,DFS
 */
public class TakeGroupPhoto {

	
	public int takeGroupPhoto(int n, String[] data) {
        int answer = 0;
        return answer;
    }
	
	
	
	
	// [솔루션1] 완전 탐색으로 순회하여 조건에 맞는 경우 카운트 하는 방법 (재귀메서드로 구하고, 조건은 문자열 파싱)
	public int takeGroupPhoto_1(int n, String[] data) {
		// 3. 모든 경우의 수를 만들 StringBuilder 객체.
		StringBuilder sb = new StringBuilder();    
		// 4. 초기화 해주어야 통과가 된다.
		answer = 0;
		// 5. dfs메소드 호출.
		dfs(0,sb,data);      
		
		return answer;
	}
	
	// 1. 인덱스 방문 여부 체크 배열.
    static boolean check[] = new boolean[8];
    // 2. 카카오 프렌즈 0~7인덱스까지 각 알파벳을 매칭.
    static char friends[] = {'A','C','F','J','M','N','R','T'};
    
    static int answer;
    
    // 16. 주어진 조건 data에 맞는지 검사하는 메소드
    public static boolean isPossible(StringBuilder sb,String[] data){
        // 17. 조건 배열 data를 탐색.
        for(int i = 0 ; i<data.length;i++){
            // 18. 조건의 0번 인덱스와 2번 인덱스는 조건을 제시한 프렌즈, 상대 프렌즈이므로, 그 사이 거리를 구한다.
            // 단, 둘 사이의 프렌즈 수를 구해야 하기 때문에 최종 값에 -1.
            int gap = Math.abs(sb.indexOf(String.valueOf(data[i].charAt(0))) - sb.indexOf(String.valueOf(data[i].charAt(2))))-1;
            // 19. 조건의 4번 인덱스는 주어진 정수값.
            int condition_gap = data[i].charAt(4) - '0';
                        
            // 20. 조건의 3번 인덱스는 대소비교 문자이므로 이에 따라 분기처리.
            switch(data[i].charAt(3)){
                    // 21. 각 경우에 따라 조건에 맞지 않다면 false.
                case '=' :
                    if(gap != condition_gap) return false;
                    break;
                    
                case '>' :
                    if(gap <= condition_gap) return false;
                    break;
                    
                case '<':
                    if(gap >= condition_gap) return false;
                    break;                    
            }
            
        }
        
        // 22. 나머지는 true.
        return true;
    }
    
    // 6. dfs 메소드(인덱스, 경우의 수 순열을 저장할 객체, 조건 메소드에 전달 할 data 배열)
    public static void dfs(int idx,StringBuilder sb, String[] data){
        // 7. idx == 마지막 프렌즈인 경우 조건을 검사 및 종료.
        if(idx == friends.length){
            // 8. 조건 검사 메소드 호출.
            if(isPossible(sb,data)){
                answer++;
            } 
            return;
        }
        
        // 9. 전역변수로 선언한 문자형 배열을 탐색.
        for(int i = 0 ; i < friends.length;i++){
            // 10. 방문한 경우 패스.
            if(check[i]) continue;
            // 11. 방문처리 후,
            check[i] = true;
            // 12. 프렌즈에 해당하는 문자를 StringBuilder 객체에 붙인다. 
            sb.append(String.valueOf(friends[i]));
            // 13. 인덱스 증가 및 StringBuilder와 함께 재귀호출.
            dfs(idx+1,sb,data);
            // 14. 방문처리 해제.
            check[i] = false;
            // 15. 위에 붙인 문자를 다시 제거.
            sb.delete(idx,friends.length);           
        }    
    }
    
	
	
	
	
	// [솔루션2] 9중 for문과 중첩 조건문을 사용한 방법
	public int takeGroupPhoto_2(int n, String[] data) {
		char[] s = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

        int count = 0;

        for (int a = 0; a < s.length; a++) {
            for (int b = 0; b < s.length; b++) {
                if (b == a) {
                    continue;
                }
                for (int c = 0; c < s.length; c++) {
                    if (c == a || c == b) {
                        continue;
                    }
                    for (int d = 0; d < s.length; d++) {
                        if (d == c || d == a || d == b) {
                            continue;
                        }
                        for (int e = 0; e < s.length; e++) {
                            if (e == d || e == a || e == b || e == c) {
                                continue;
                            }
                            for (int f = 0; f < s.length; f++) {
                                if (f == e || f == d || f == c || f == b || f == a) {
                                    continue;
                                }
                                for (int g = 0; g < s.length; g++) {
                                    if (g == a || g == b || g == c || g == d || g == e || g == f) {
                                        continue;
                                    }
                                    for (int h = 0; h < s.length; h++) {
                                        if (h == a || h == b || h == c || h == d || h == e || h == f || h == g) {
                                            continue;
                                        }
                                        String makeS = "" + s[a] + s[b] + s[c] + s[d] + s[e] + s[f] + s[g] + s[h];

                                        boolean isCheck = false;
                                        for (int i = 0; i < data.length; i++) {
                                            char first = data[i].charAt(0);
                                            char second = data[i].charAt(2);
                                            char inequality = data[i].charAt(3);
                                            int distance = data[i].charAt(4) - 48;

                                            int firstIndex = makeS.indexOf(first);
                                            int secondIndex = makeS.indexOf(second);
                                            switch (inequality) {
                                                case '=': {
                                                    if (Math.abs(firstIndex - secondIndex) == distance + 1) {
                                                        isCheck = true;
                                                    } else
                                                        isCheck = false;
                                                    break;
                                                }
                                                case '>': {
                                                    if (Math.abs(firstIndex - secondIndex) > distance + 1) {
                                                        isCheck = true;
                                                    } else
                                                        isCheck = false;
                                                    break;
                                                }
                                                case '<': {
                                                    if (Math.abs(firstIndex - secondIndex) < distance + 1) {
                                                        isCheck = true;
                                                    } else
                                                        isCheck = false;
                                                    break;
                                                }
                                            }
                                            if (isCheck == false) {
                                                break;
                                            }
                                        }
                                        if (isCheck) {
                                            count++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
        return count;
	}
	
	
	
	
	// [솔루션3] 규칙에 맞게 불필요한 부분을 줄여서 가독성 좋게 완전탐색을 구현한 방법
	public int takeGroupPhoto_3(int n, String[] data) {
		answer_3 = 0;
        perm(0,data);
        return answer_3;
	}
	
	static String[] arr = {"A","C","F","J","M","N","R","T"};
    static String[] result = new String[8];
    static boolean[] used = new boolean[8];
    static int answer_3; // 솔루션3 전용 answer
    
	static void perm(int cnt, String[] data){
        if(cnt==8){
            String s = "";
            for(int i=0; i<arr.length; i++){
                s+=result[i];
            }
            for(int i=0; i<data.length; i++){
                int start = s.indexOf(data[i].charAt(0));
                int end = s.indexOf(data[i].charAt(2));

                if(data[i].charAt(3)=='=' && Math.abs(start-end)-1!=data[i].charAt(4)-'0'){
                    return;
                }else if(data[i].charAt(3)=='<' && Math.abs(start-end)-1>=data[i].charAt(4)-'0'){
                    return;
                }else if(data[i].charAt(3)=='>' && Math.abs(start-end)-1<=data[i].charAt(4)-'0'){
                    return;
                }
            }
            answer_3++;
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!used[i]){
                used[i] = true;
                result[cnt] = arr[i];
                perm(cnt+1, data);
                used[i] = false;
            }
        }
    }
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
