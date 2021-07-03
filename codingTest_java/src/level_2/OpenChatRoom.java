package level_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * @codingTest <Problems> ����ä�ù� [2-4]
 *
 *	HashMap : Map �������̽��� ������ ��ǥ���� Map �÷��� -> Ű�� �ߺ�X | ���� �ߺ�O
 *	StringTokenizer : ���ڿ��� �츮�� ������ �����ڷ� ���ڿ��� �ɰ��ִ� Ŭ���� -> Token : �ɰ����� ���ڿ�
 *
 *	List : �迭�� ����� �ڹ��� �ڷ���, �迭���� ���� ���
 *	ArrayList : List �ڷ��� �� ���� ������ ������ �ڷ���
 *
 *	equalsIgnoreCase() : ���ҹ��� ���о��� ���ڿ��� ���ϴ� �޼���
 */
public class OpenChatRoom {

	
	public String[] openChatRoom(String[] record) {
        String[] answer = {};
        return answer;
    }
	
	
	
	
	
	// [�ַ�� 1] HashMap���� id�� ArrayList�� �г����� �����ϴ� ������ ��� (�׽�Ʈ �߰����� ����ȭ�� �ȵ�)
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
                    chatLog.add(userId + "���� ���Խ��ϴ�.");
                    break;
                case "Leave":
                    chatLog.add(userId + "���� �������ϴ�.");
                    break;
                case "Change":
                    nickMap.put(userId, nickname);
                    break;
            }
        }
        
        String[] answer = new String[chatLog.size()];
        int logIdx = 0;
        
        for(String str : chatLog){
            int endOfId = str.indexOf("��");
            String userId = str.substring(0, endOfId);
            
            answer[logIdx++] = str.replace(userId, nickMap.get(userId));
        }
        
        return answer;
	}
	
	
	
	
	
	// [�ַ�� 2]
	public String[] openChatRoom_2(String[] record) {
		HashMap<String, String> codeMap = new HashMap<String, String>();
        codeMap.put("enter","���Խ��ϴ�.");
        codeMap.put("leave","�������ϴ�.");

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
            answer[i] = name+"���� "+ codeMap.get(split[0].toLowerCase());
        }

        return answer;
	}
	
	
	
	
	
	// [�ַ�� 3] Map�� ���� ���ٽ��� ǥ������ �ذ��� ���
	private static final String FORMAT_ENTER_MESSAGE = "%s���� ���Խ��ϴ�.";
    private static final String FORMAT_LEAVE_MESSAGE = "%s���� �������ϴ�.";
    // Enter [���� ���̵�] [�г���]
    // Leave [���� ���̵�]
    // Change [���� ���̵�] [�г���]
    
    
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
