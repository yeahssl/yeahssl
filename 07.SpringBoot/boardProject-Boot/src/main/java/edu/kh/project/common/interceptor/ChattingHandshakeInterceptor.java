package edu.kh.project.common.interceptor;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpSession;

@Component // bean등록
public class ChattingHandshakeInterceptor implements HandshakeInterceptor{

	
	// WebSocketHandler가 동작하기 전
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		
		if(request instanceof ServletServerHttpRequest) {
			
			
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest)request;
			
			HttpSession session = servletRequest.getServletRequest().getSession();
			
			// Map<String, Object> attributes
			// -> WebSocketHandler의 WebSocketSession에 담을 내용(값)을 세팅하는 Map
			
			attributes.put("session", session);
		}
		
		return true;
	}
	
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		
	}

}
