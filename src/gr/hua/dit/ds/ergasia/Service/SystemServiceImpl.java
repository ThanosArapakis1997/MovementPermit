package gr.hua.dit.ds.ergasia.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.hua.dit.ds.ergasia.dao.UserDAO;
import gr.hua.dit.ds.ergasia.entity.Form;
import gr.hua.dit.ds.ergasia.entity.User;
import gr.hua.dit.ds.ergasia.entity.user;

@Service
public class SystemServiceImpl implements SystemService {

	@Autowired
	UserDAO Dao;
	
	@Override
	@Transactional
	public List<User> getUsers() {
		return Dao.getUsers();
	}

	@Override
	@Transactional
	public List<Form> getForms() {
		return Dao.getForms();
	}

	@Override
	@Transactional
	public void AddForm(Form form) {
         Dao.AddForm(form);		
	}

	@Override
	public List<Form> getApprovedForms() {
		// TODO Auto-generated method stub
		return Dao.getApprovedForms();
	}

	@Override
	public void saveUser(user user) {
		Dao.saveUser(user);
		
	}

	@Override
	public void saveApprovedForm(String username) {
        Dao.saveApprovedForm(username);		
	}

}
