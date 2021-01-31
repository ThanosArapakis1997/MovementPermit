package gr.hua.dit.ds.ergasia.Service;

import java.util.List;

import gr.hua.dit.ds.ergasia.entity.Form;
import gr.hua.dit.ds.ergasia.entity.User;
import gr.hua.dit.ds.ergasia.entity.user;

public interface SystemService {
	public List<User> getUsers();
	public List<Form> getForms();
	public void AddForm(Form form);
	public void saveUser(user user);
	public List<Form> getApprovedForms();
	public void saveApprovedForm(String username);
}
