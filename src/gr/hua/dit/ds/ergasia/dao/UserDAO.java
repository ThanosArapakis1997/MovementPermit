package gr.hua.dit.ds.ergasia.dao;

import java.util.List;

import gr.hua.dit.ds.ergasia.entity.Form;
import gr.hua.dit.ds.ergasia.entity.user;

public interface UserDAO {
	public List<user> getUsers();
	public List<Form> getForms();
	public void AddForm(Form form);
	public void saveUser(user user);
	public List<Form> getApprovedForms();
	public void saveApprovedForm(String username);
	public void deleteuser(String user);
}
