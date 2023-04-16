package team.prectice.first;

public class Solution3 {
	public static void main(String args[]) {
		String[] spell = {"p", "o", "s"};
		String[] dic = {"sod", "eocd", "qixm", "adio", "soo"};
		
		System.out.println(solution(spell, dic));
	}
	
	    public static int solution(String[] spell, String[] dic) {
	        int answer = 0;
	       
	        
	        for(int i = 0; i < dic.length; i++) {
	        	int count = 1;
	        	for(int j = 0; j < spell.length; j++) {
	        		if(spell[j].contains(dic[i])) {
	        			count++;
	        		
	        		} if(count == spell.length) {
	        			answer = 1;
	        			return answer;
	        		}else {
	        			answer = 2;
	        		}
	        	}
	        }
	        return answer;
	    }
	}


