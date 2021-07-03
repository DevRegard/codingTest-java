package level_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @codingTest <Problems> 카카오프렌즈 컬러링북 [2-2]
 *
 *	BFS : 너비 우선 탐색 -> 루트 노트에서 시작해서 인접한 노드를 먼저 탐색하는 방법 [Breadth]
 *	DFS : 깊이 우선 탐색 -> 루트 노트에서 시작해서 다음 분기(branch)로 넘어가기 전에 해당 분기를 완벽하게 탐색하는 방법 [Depth]
 *
 *	Queue : FIFO구조 (배변) -> BFS(넓이 우선 탐색) -> front쪽으로 삭제연산, rear 쪽으로 삽입 연산
 *			컴퓨터 버퍼에서 주로 사용 (마구 입력이 되었으나 처리를 하지 못할 때, 버퍼(큐)를 만들어서 대기시킴 
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
	
	
	
	
	
	// [솔루션1] DFS로 접근해서 해결한 방법 (Queue와 LinkedList<> 사용)
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
      static int size = 0;// 칸의 개수
	
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
                          size++; // 지나온 칸의 개수
                      
                      }
                  }
              }
          }
      }
	
      
      
      
	
	// [솔루션2] ArrayList, Collections.reverseOrder(), findPath()
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
            return; // 이미 거친 경로일 경우
        long su = picture[m][n]; // 이미지 값
        int column = picture[0].length;
        int row = picture.length;
        pathBool[m][n] = true;
        span++;
        // 오른쪽 이동
        if ((n + 1 < column) && (pathBool[m][n + 1] == false && su == picture[m][n + 1])) {
            findPath(m, n + 1, picture, pathBool);
        }
        // 아래쪽 이동
        if ((m + 1 < row) && (pathBool[m + 1][n] == false && su == picture[m + 1][n])) {
            findPath(m + 1, n, picture, pathBool);
        }
        // 왼쪽 이동
        if ((n - 1 >= 0) && (pathBool[m][n - 1] == false && su == picture[m][n - 1])) {
            findPath(m, n - 1, picture, pathBool);
        }
        // 위쪽 이동
        if ((m - 1 >= 0) && (pathBool[m - 1][n] == false && su == picture[m - 1][n])) {
            findPath(m - 1, n, picture, pathBool);
        }
    }
	
	
	
	
	
	// [솔루션3] Queue, LinkedList<>()
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