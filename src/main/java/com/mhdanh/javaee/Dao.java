package com.mhdanh.javaee;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mhdanh.javaee.entity.PostEntity;

@Stateless
public class Dao {

	@PersistenceContext
	private EntityManager em;
	
	public void save(PostEntity post) {
		em.persist(post);
	}
	
	public List<PostEntity> getAllPost() {
		List<PostEntity> list = em.createQuery("SELECT post FROM PostEntity post", PostEntity.class).getResultList();
		System.out.println("view model");	
		list.forEach(i -> System.out.println(i.getDetail().getDateCreated()));
		return list;
	}
	
	public PostEntity getById(long id) {
		PostEntity item = em.find(PostEntity.class, id);
		return item;
	}
}
