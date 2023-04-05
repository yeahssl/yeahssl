package team.prectice.first;

public class Solution1 {
	
	public static void main(String[] args) {
		String[] id_pw = {"meosseug", "123"};
		String[][] db = {{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}};
		
		System.out.println(solution(id_pw,db));
		
	}
	
	public static String solution(String[] id_pw, String[][] db) {
		String answer ="";
		
		for(int i = 0; i < db.length; i++ ) {
			if(id_pw[0] == db[i][0] && id_pw[1] == db[i][1] ) {
				answer = "login";
			}else if(id_pw[0] == db[i][0] && id_pw[1] != db[i][1]) {
				answer = "wrong pw";
			}else {
				answer = "fail";
			}
		}
		
		
		
		

		
		
		
		return answer;
		
		
	}

}
