package level_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * @codingTest <Problems> 오픈채팅방 [2-4]
 *
 *	HashMap : Map 인터페이스를 구현한 대표적인 Map 컬렉션 -> 키는 중복X | 값은 중복O
 *	StringTokenizer : 문자열을 우리가 지정한 구분자로 문자열을 쪼개주는 클래스 -> Token : 쪼개어진 문자열
 *
 *	List : 배열과 비슷한 자바의 자료형, 배열보다 편리한 기능
 *	ArrayList : List 자료형 중 가장 간단한 형태의 자료형
 *
 *	equalsIgnoreCase() : 데소문자 구분없이 문자열을 비교하는 메서드
 */
public class OpenChatRoom {

	
	public String[] openChatRoom(String[] record) {
        String[] answer = {};
        return answer;
    }
	
	
	
	
	
	// [솔루션 1] HashMap으로 id를 ArrayList로 닉네임을 도출하는 구조의 방법 (테스트 중간부터 최적화가 안됨)
	public String[] openChatRoom_1(String[] record) {
		ArrayList<String> chatLog = new ArrayList<>();
        HashMap<String, String> nickMap = new HashMap<>();
        
        for(String log : record){
            StringTokenizer st = new StringTokenizer(log);
            String command = st.nextToken();
            String userId = st.nextToken();
            String nickname = "";
            
            if(!command.equals("Leave")){
                nickname = st.nextToken();
            }
            
            switch(command){
                case "Enter":
                    nickMap.put(userId, nickname);
                    chatLog.add(userId + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    chatLog.add(userId + "님이 나갔습니다.");
                    break;
                case "Change":
                    nickMap.put(userId, nickname);
                    break;
            }
        }
        
        String[] answer = new String[chatLog.size()];
        int logIdx = 0;
        
        for(String str : chatLog){
            int endOfId = str.indexOf("님");
            String userId = str.substring(0, endOfId);
            
            answer[logIdx++] = str.replace(userId, nickMap.get(userId));
        }
        
        return answer;
	}
	
	
	
	
	
	// [솔루션 2]
	public String[] openChatRoom_2(String[] record) {
		HashMap<String, String> codeMap = new HashMap<String, String>();
        codeMap.put("enter","들어왔습니다.");
        codeMap.put("leave","나갔습니다.");

        HashMap<String, String> uidMap = new HashMap<String, String>();
        List<String> list = new ArrayList<String>();
        for(String str:record){
            String[] split = str.split("\\s+");
            String code = split[0];
            String uid = split[1];
            if(split.length > 2) {
                String name = split[2];
                uidMap.put(uid, name);
            }
            if(!"Change".equalsIgnoreCase(code)){
                list.add(code +" "+uid);
            }

        }
        String[] answer = new String[list.size()];
        for(int i=0;i<answer.length;i++){
            String[] split = list.get(i).split("\\s+");
            String name = uidMap.get(split[1]);
            answer[i] = name+"님이 "+ codeMap.get(split[0].toLowerCase());
        }

        return answer;
	}
	
	
	
	
	
	// [솔루션 3] Map의 사용과 람다식의 표현으로 해결한 방법
	private static final String FORMAT_ENTER_MESSAGE = "%s님이 들어왔습니다.";
    private static final String FORMAT_LEAVE_MESSAGE = "%s님이 나갔습니다.";
    // Enter [유저 아이디] [닉네임]
    // Leave [유저 아이디]
    // Change [유저 아이디] [닉네임]
    
    
	public String[] openChatRoom_3(String[] record) {
		Map<String, String> userMap = new HashMap();

        // register user id and nickname
        Stream.of(record)
            .filter(o -> o.startsWith("Enter") || o.startsWith("Change"))
            .forEach(o -> getFormattedMessage(userMap, o));

        List<String> records = new ArrayList<>();

        // answer 
        return Stream.of(record)
            .map(o -> getFormattedMessage(userMap, o))
            .filter(o -> !"".equals(o))
            .toArray(String[]::new);
	}
		
	
	
	
    private String getFormattedMessage(Map<String, String> userMap, String message) {
        String userId = message.split(" ")[1];
        switch (message.split(" ")[0]) {
            case "Enter":
                return String.format(FORMAT_ENTER_MESSAGE, userMap.get(userId));
            case "Leave":
                return String.format(FORMAT_LEAVE_MESSAGE, userMap.get(userId));
            default:
                return "";
        }
    }
    
    
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
