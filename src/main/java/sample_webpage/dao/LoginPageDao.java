package sample_webpage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sample_webpage.dto.Users;


public class LoginPageDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("shivam");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public Users saveStudent(Users student) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}
	public Users loginStudent(String email) {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select s from Users s where s.email=?1");
		query.setParameter(1, email);
		Users student=(Users) query.getSingleResult();
		
		return student;
	}
	public Users updateStudent(Users student) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
	}
	public boolean deleteStudent(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Users student=entityManager.find(Users.class, id);
		if(student!=null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
		
	}
	public Users getStudentById(int id) {
		EntityManager entityManager=getEntityManager();
		Users student=entityManager.find(Users.class, id);
		return student;
	}
	
	public List<Users> getAllStudent(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select a from Users a");
		List<Users> list=query.getResultList();
		return list;
	}


}
