package com.jdc.demo.service;

import javax.ejb.Remote;

@Remote
public interface HelloRemote {

	String sayHello();

}
