package edu.kh.project.member.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service // Service Layer
public class MemberServiceImpl implements MemberService{
   

   @Autowired
   private MemberDAO dao;
   
   
   @Autowired // bean으로 등록된 객체 중 타입이 일치하는 객체를 DI
   private BCryptPasswordEncoder bcrypt;
   

   @Override
   public Member login(Member inputMember) {
      
      Member loginMember = dao.login(inputMember);
      
      if(loginMember != null) { // 아이디가 일치하는 회원이 조회된 경우
         
         if(bcrypt.matches(inputMember.getMemberPw(),
                       loginMember.getMemberPw())) {
            
                        loginMember.setMemberPw(null);
            
         } else { // 다를 경우
            loginMember = null; // 로그인 실패처럼 만듦
         }
         
      }
      
      return loginMember;
   }
   @Transactional(rollbackFor = {Exception.class}) 
   @Override
   public int signUp(Member inputMember) {
      
      String encPw = bcrypt.encode(inputMember.getMemberPw());
      inputMember.setMemberPw(encPw);
      
      int result = dao.signUp(inputMember);
      
      return result;
   }
   
   
   
   
}