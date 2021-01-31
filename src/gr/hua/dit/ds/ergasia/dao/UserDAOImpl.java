package gr.hua.dit.ds.ergasia.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.ds.ergasia.entity.Form;
import gr.hua.dit.ds.ergasia.entity.User;
import gr.hua.dit.ds.ergasia.entity.user;


@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<User> getUsers() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<User> query = currentSession.createQuery("from User", User.class);

		// execute the query and get the results list
		List<User> users = query.getResultList();

		// return the results
		return users;
	}
	
	@Override
	@Transactional
	public List<Form> getForms()  {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Form> get = currentSession.createQuery("from Form f where f.approved= false", Form.class);
        List<Form> forms= get.getResultList();
		
		
   return forms;
   }
	

	@Override
	@Transactional
	public void AddForm(Form form) {
		
		Session session = sessionFactory.getCurrentSession();
				
 		
		session.save(form);
		        
		System.out.println("Done!");
		
	}

	@Override
	@Transactional
	public List<Form> getApprovedForms() {
		List<Form> ApprovedForms = new ArrayList<Form>();
		Session currentSession = sessionFactory.getCurrentSession();
        
		Query<Form> get= currentSession.createQuery("from Form f where f.approved=true", Form.class);
		ApprovedForms=get.getResultList();
		System.out.println(ApprovedForms.toString());
		return ApprovedForms;
	}

	@Override
	@Transactional
	public void saveUser(user user) {
        Session session = sessionFactory.getCurrentSession();
				
 		
		session.save(user);
		        
		System.out.println("Done!");		
	}

	@Override
	@Transactional
	public void saveApprovedForm(String username) {
		
		Session session = sessionFactory.getCurrentSession();	
	    Query<Form> get=session.createQuery("from Form f where f.username= :username", Form.class).setParameter("username", username);
		Form form=get.getSingleResult();
	    form.setApproved(true);
					
	}	
}
