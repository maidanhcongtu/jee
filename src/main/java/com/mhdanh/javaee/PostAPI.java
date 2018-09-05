package com.mhdanh.javaee;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.mhdanh.javaee.entity.PostDetailEntity;
import com.mhdanh.javaee.entity.PostEntity;

@Path("post")
@RequestScoped
public class PostAPI {

	@Inject
	private Dao dao;
	
	@POST
	public void save() {
		PostEntity entity = PostEntity.builder().name("name " + System.currentTimeMillis()).build();
		PostDetailEntity detail = PostDetailEntity.builder().dateCreated(LocalDate.now()).build();
		entity.setDetail(detail);
		detail.setPost(entity);
		
		dao.save(entity);
	}
	
	@GET
	public List<PostEntity> getAll() {
		List<PostEntity> list = dao.getAllPost();
		return list;
	}
	
	@GET
	@Path("{id}")
	public PostEntity getById(@PathParam("id") long id) {
		PostEntity item = dao.getById(id);
		return item;
	}
	
}
