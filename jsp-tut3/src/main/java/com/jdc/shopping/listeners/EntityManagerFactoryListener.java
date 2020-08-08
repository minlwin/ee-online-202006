package com.jdc.shopping.listeners;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.jdc.shopping.model.service.CategoryService;

@WebListener
public class EntityManagerFactoryListener implements ServletContextListener {
	
	private EntityManagerFactory emf;

    public void contextInitialized(ServletContextEvent sce)  { 
		emf = Persistence.createEntityManagerFactory("jsp-tut3");
		sce.getServletContext().setAttribute("emf", emf);
		
		CategoryService catService = new CategoryService(emf.createEntityManager());
		sce.getServletContext().setAttribute("categories", catService.getAll());
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	emf.close();
    }

	
}
