package gr.hua.dit.ds.ergasia.entity;

import java.util.Date;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="form")
public class Form {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="fid")
	private int fid;
	
	@Column(name="type")
	private String type;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="postalcode")
	private int postal_code;
	
	@Column(name="ReqDate")
	@Temporal(TemporalType.DATE) 
	private Date ReqDate;
	
	@Column(name="approved")
	private boolean approved;
	
	@Column(name="user_name")
	private String username;
	
	
		public Form() {
		
	}

	public Form(String type, String username, String street, String city, String state, int postal_code, Date reqDate,
			boolean approved) {
		super();
		this.type = type;
		this.username=username;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postal_code = postal_code;
		this.ReqDate = reqDate;
		this.approved = approved;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(int postal_code) {
		this.postal_code = postal_code;
	}

	public Date getReqDate() {
		return ReqDate;
	}

	public void setReqDate(Date reqDate) {
		ReqDate = reqDate;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	@Override
	public String toString() {
		return "Form [fid=" + fid + ",User=" + username + ", type=" + type + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", postal_code=" + postal_code + ", ReqDate="+ ReqDate + ", approved="+ approved + "]";
	}
	
}
