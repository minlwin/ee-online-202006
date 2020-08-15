package com.jdc.students.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.jdc.students.model.entity.Account;

@WebListener
public class LogoutListener implements HttpSessionListener {

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	HttpSession session =  se.getSession();
    	
    	Account login = (Account) session.getAttribute("login");
    	if(null != login) {
    		session.getServletContext().removeAttribute(login.getLoginId());
    	}
    }
	
}
