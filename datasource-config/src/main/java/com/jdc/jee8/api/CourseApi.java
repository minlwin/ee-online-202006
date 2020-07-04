package com.jdc.jee8.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jdc.jee8.model.entity.Course;
import com.jdc.jee8.model.service.CourseService;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseApi {
	
	@Inject
	private CourseService service;
	
	@GET
	public Response index() {
		return Response.ok(service.getAll()).build();
	}
	
	@GET
	@Path("{id}")
	public Response findById(@PathParam("id") int id) {
		return Response.ok(service.findById(id)).build();
	}
	
	@POST
	public Response create(Course course) {
		Course c = service.save(course);
		return Response.accepted(c).build();
	}

	@PUT
	public Response update(Course course) {
		Course c = service.save(course);
		return Response.accepted(c).build();
	}
}
