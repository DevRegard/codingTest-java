package level_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @codingTest <Problems> īī�������� �÷����� [2-2]
 *
 *	BFS : �ʺ� �켱 Ž�� -> ��Ʈ ��Ʈ���� �����ؼ� ������ ��带 ���� Ž���ϴ� ��� [Breadth]
 *	DFS : ���� �켱 Ž�� -> ��Ʈ ��Ʈ���� �����ؼ� ���� �б�(branch)�� �Ѿ�� ���� �ش� �б⸦ �Ϻ��ϰ� Ž���ϴ� ��� [Depth]
 *
 *	Queue : FIFO���� (�躯) -> BFS(���� �켱 Ž��) -> front������ ��������, rear ������ ���� ����
 *			��ǻ�� ���ۿ��� �ַ� ��� (���� �Է��� �Ǿ����� ó���� ���� ���� ��, ����(ť)�� ���� ����Ŵ 
 *
 *	LinkedList<Node>() :
 */
public class KakaoFriendsColoringBook {

	
	public int[] kakaoFriendsColoringBook(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
	
	
	
	
	
	// [�ַ��1] DFS�� �����ؼ� �ذ��� ��� (Queue�� LinkedList<> ���)
	public int[] kakaoFriendsColoringBook_1(int m, int n, int[][] picture) {
		int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	      
	      visited = new boolean[m][n];
	      
	      for(int i = 0; i < m; i++){
	          for(int j = 0; j < n; j++){
	              if(picture[i][j] > 0 && visited[i][j] != true){
	                  size = 1;
	                  bfs(picture, i, j, m, n);
	                  numberOfArea++;
	                  if(maxSizeOfOneArea < size)
	                      maxSizeOfOneArea = size;
	              }
	              
	          }
	      }
	      
	      int[] answer = new int[2];
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      return answer;
	}
	
	static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Node {
        int x;
        int y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    
    static Queue<Node> queue = new LinkedList<Node>();
    static boolean[][] visited;
      static int size = 0;// ĭ�� ����
	
      static void bfs(int[][] pic, int x, int y, int m, int n){
          queue.add(new Node(x, y));
          visited[x][y] = true;
          
          while(!queue.isEmpty()){
              Node now = queue.poll();
              
              for(int i = 0; i < 4; i++){
                  int nx = now.x + dx[i];
                  int ny = now.y + dy[i];
                  
                  if(0 <= nx && nx < m && 0 <= ny && ny < n){
                      if(pic[nx][ny] == pic[x][y] && visited[nx][ny] != true){
                          queue.add(new Node(nx, ny));
                          visited[nx][ny] = true;
                          size++; // ������ ĭ�� ����
                      
                      }
                  }
              }
          }
      }
	
      
      
      
	
	// [�ַ��2] ArrayList, Collections.reverseOrder(), findPath()
    int span = 0;
      
	public int[] kakaoFriendsColoringBook_2(int m, int n, int[][] picture) {
		int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] pathBool = new boolean[m][n];
        ArrayList<Integer> answerList = new ArrayList<>();
        int[] answer = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n; j++) {
                if (picture[i][j] > 0) {
                    findPath(i, j, picture, pathBool);
                    if(span > 0){
                        answerList.add(span);
                        span = 0;
                    }
                }
            }
        }
        numberOfArea = answerList.size();
        if(numberOfArea == 0){
            return new int[]{0, 0};
        }
        Collections.sort(answerList, Collections.reverseOrder());
        maxSizeOfOneArea = answerList.get(0);
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
	}
	
	
	public void findPath(int m, int n, int[][] picture, boolean[][] pathBool) {
        if (pathBool[m][n] == true)
            return; // �̹� ��ģ ����� ���
        long su = picture[m][n]; // �̹��� ��
        int column = picture[0].length;
        int row = picture.length;
        pathBool[m][n] = true;
        span++;
        // ������ �̵�
        if ((n + 1 < column) && (pathBool[m][n + 1] == false && su == picture[m][n + 1])) {
            findPath(m, n + 1, picture, pathBool);
        }
        // �Ʒ��� �̵�
        if ((m + 1 < row) && (pathBool[m + 1][n] == false && su == picture[m + 1][n])) {
            findPath(m + 1, n, picture, pathBool);
        }
        // ���� �̵�
        if ((n - 1 >= 0) && (pathBool[m][n - 1] == false && su == picture[m][n - 1])) {
            findPath(m, n - 1, picture, pathBool);
        }
        // ���� �̵�
        if ((m - 1 >= 0) && (pathBool[m - 1][n] == false && su == picture[m - 1][n])) {
            findPath(m - 1, n, picture, pathBool);
        }
    }
	
	
	
	
	
	// [�ַ��3] Queue, LinkedList<>()
	public int[] kakaoFriendsColoringBook_3(int m, int n, int[][] picture) {
		boolean[][] check = new boolean[m][n];
        Queue<Node> q = new LinkedList<>();
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { 1, -1, 0, 0 };

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                int tempMax = 0;
                if (!check[i][j] && picture[i][j] != 0) {
                    check[i][j] = true;
                    q.add(new Node(i, j));
                    tempMax++;

                    while (!q.isEmpty()) {

                        Node current = q.poll();

                        int nextX = 0;
                        int nextY = 0;

                        for (int k = 0; k < 4; k++) {
                            nextX = current.x + dx[k];
                            nextY = current.y + dy[k];

                            if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n || check[nextX][nextY])
                                continue;
                            if (picture[current.x][current.y] == picture[nextX][nextY]) {
                                check[nextX][nextY] = true;
                                q.add(new Node(nextX, nextY));
                                tempMax++;
                            }
                        } // end of for_k

                    } // end of while
                    numberOfArea++;
                    maxSizeOfOneArea = maxSizeOfOneArea < tempMax ? tempMax : maxSizeOfOneArea;
                } // end of if

            } // end of for_j
        } // end of for_i

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        System.out.println(numberOfArea + "," + maxSizeOfOneArea);

        return answer;
	}
	
	
	static class Node_3 {
        int x, y;

        public Node_3(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}