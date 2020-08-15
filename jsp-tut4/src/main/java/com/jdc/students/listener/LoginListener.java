package com.jdc.students.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.jdc.students.model.entity.Account;

@WebListener
public class LoginListener implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	
    	if(event.getName().equals("login")) {
    		
    		Account account = (Account) event.getValue();
    		if(null != account) {
        		event.getSession().getServletContext().setAttribute(account.getLoginId(), account);
    		}
    	}

    }

}
