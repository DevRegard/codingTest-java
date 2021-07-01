package level_2;

/**
 * @codingTest <Problems> ��ü���� ��� [2-1]
 *	
 * �˰��� <����Ž��> : ��� ����� ���� �� üũ�ؼ� ������ �����ϴ� ��� [Brute Force]
 * 		
 * 	1) Brute Force ���
 * 	2) ���� (Permutation)
 * 	3) ��� (Recursive)
 * 	4) ��Ʈ����ũ (BitMask)
 * 	5) BFS,DFS
 */
public class TakeGroupPhoto {

	
	public int takeGroupPhoto(int n, String[] data) {
        int answer = 0;
        return answer;
    }
	
	
	
	
	// [�ַ��1] ���� Ž������ ��ȸ�Ͽ� ���ǿ� �´� ��� ī��Ʈ �ϴ� ��� (��͸޼���� ���ϰ�, ������ ���ڿ� �Ľ�)
	public int takeGroupPhoto_1(int n, String[] data) {
		// 3. ��� ����� ���� ���� StringBuilder ��ü.
		StringBuilder sb = new StringBuilder();    
		// 4. �ʱ�ȭ ���־�� ����� �ȴ�.
		answer = 0;
		// 5. dfs�޼ҵ� ȣ��.
		dfs(0,sb,data);      
		
		return answer;
	}
	
	// 1. �ε��� �湮 ���� üũ �迭.
    static boolean check[] = new boolean[8];
    // 2. īī�� ������ 0~7�ε������� �� ���ĺ��� ��Ī.
    static char friends[] = {'A','C','F','J','M','N','R','T'};
    
    static int answer;
    
    // 16. �־��� ���� data�� �´��� �˻��ϴ� �޼ҵ�
    public static boolean isPossible(StringBuilder sb,String[] data){
        // 17. ���� �迭 data�� Ž��.
        for(int i = 0 ; i<data.length;i++){
            // 18. ������ 0�� �ε����� 2�� �ε����� ������ ������ ������, ��� �������̹Ƿ�, �� ���� �Ÿ��� ���Ѵ�.
            // ��, �� ������ ������ ���� ���ؾ� �ϱ� ������ ���� ���� -1.
            int gap = Math.abs(sb.indexOf(String.valueOf(data[i].charAt(0))) - sb.indexOf(String.valueOf(data[i].charAt(2))))-1;
            // 19. ������ 4�� �ε����� �־��� ������.
            int condition_gap = data[i].charAt(4) - '0';
                        
            // 20. ������ 3�� �ε����� ��Һ� �����̹Ƿ� �̿� ���� �б�ó��.
            switch(data[i].charAt(3)){
                    // 21. �� ��쿡 ���� ���ǿ� ���� �ʴٸ� false.
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
        
        // 22. �������� true.
        return true;
    }
    
    // 6. dfs �޼ҵ�(�ε���, ����� �� ������ ������ ��ü, ���� �޼ҵ忡 ���� �� data �迭)
    public static void dfs(int idx,StringBuilder sb, String[] data){
        // 7. idx == ������ �������� ��� ������ �˻� �� ����.
        if(idx == friends.length){
            // 8. ���� �˻� �޼ҵ� ȣ��.
            if(isPossible(sb,data)){
                answer++;
            } 
            return;
        }
        
        // 9. ���������� ������ ������ �迭�� Ž��.
        for(int i = 0 ; i < friends.length;i++){
            // 10. �湮�� ��� �н�.
            if(check[i]) continue;
            // 11. �湮ó�� ��,
            check[i] = true;
            // 12. ����� �ش��ϴ� ���ڸ� StringBuilder ��ü�� ���δ�. 
            sb.append(String.valueOf(friends[i]));
            // 13. �ε��� ���� �� StringBuilder�� �Բ� ���ȣ��.
            dfs(idx+1,sb,data);
            // 14. �湮ó�� ����.
            check[i] = false;
            // 15. ���� ���� ���ڸ� �ٽ� ����.
            sb.delete(idx,friends.length);           
        }    
    }
    
	
	
	
	
	// [�ַ��2] 9�� for���� ��ø ���ǹ��� ����� ���
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
	
	
	
	
	// [�ַ��3] ��Ģ�� �°� ���ʿ��� �κ��� �ٿ��� ������ ���� ����Ž���� ������ ���
	public int takeGroupPhoto_3(int n, String[] data) {
		answer_3 = 0;
        perm(0,data);
        return answer_3;
	}
	
	static String[] arr = {"A","C","F","J","M","N","R","T"};
    static String[] result = new String[8];
    static boolean[] used = new boolean[8];
    static int answer_3; // �ַ��3 ���� answer
    
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
