package team.prectice.first;

import java.util.Arrays;

public class Solution5 {
	public static void main(String[] args) {
		int [] array = {7, 77, 17};
		System.out.println(solution(array));
	}
	
	public static int solution(int[] array) {
        int answer = 0; // 갯수 저장
        
        String str = Arrays.toString(array); //숫자를 문자로 바꾸어 7의 개수를 세기 위해 배열을 toString으로 변환
        
        for(int i = 0; i < str.length(); i++) {
        	if(str.charAt(i) == '7') { // charAt으로 문자 하나씩 비교
        		answer++; // answer의 값이 1씩 증가(count함)
        	}
        }
        return answer; // 결과 값 반환
    }

}
