package team.prectice.first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution4 {
	
	public static void main(String args[]) {
		String [] name = {"may", "kein", "kain", "radi"};
		int [] yearning = {5, 10, 1, 3};
		String [][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"},
				{"kon", "kain", "may", "coni"}};
		
		System.out.println(Arrays.toString(solution(name, yearning, photo)));
		
	}
	
	 public static int[] solution(String[] name, int[] yearning, String[][] photo) {
	        int[] answer = new int[photo.length]; // photo의 인덱스 길이 만큼이 answer의 길이 
	        
	        
	        Map<String, Integer> map = new HashMap<>();
	        
	        for(int i = 0; i < name.length; i++) {
	        	map.put(name[i], yearning[i]);
	        } // 각 인덱스 name과 yearning에 일치하는 값을 배치한다.
	        
	        for(int i = 0; i < photo.length; i++) {
	        	int sum  = 0;
	        	for(int j = 0; j<photo[i].length; j++) {
	        		if(map.get(photo[i][j]) != null) {
	        			sum += map.get(photo[i][j]);
	        		}
	        	}
	        	answer[i] = sum;
	        }
	        
	        return answer;
	    }

}





