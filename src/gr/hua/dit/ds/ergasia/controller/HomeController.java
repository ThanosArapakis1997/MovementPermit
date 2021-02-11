package gr.hua.dit.ds.ergasia.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import gr.hua.dit.ds.ergasia.entity.Form;
import gr.hua.dit.ds.ergasia.entity.user;

import gr.hua.dit.ds.ergasia.Service.SystemService;;

@Controller
public class HomeController {
	
	@Autowired
	private SystemService Service;
	
	
	
    @GetMapping("/login")
    public String login() {
	   return "login";
    }
    
    @RequestMapping("/signup")
    public String signup() {
    	return "signup";
    }
    
    @PostMapping("/saveuser")
	public String saveUser(HttpServletRequest Request) {
       String username=Request.getParameter("username");
       String password=Request.getParameter("password");
       boolean enabled= true;
       
        user user= new user(username,password,enabled); 
    	Service.saveUser(user);
		
		return "redirect:/login";
	}
    
	@GetMapping("/menu")
	public String menu(HttpServletRequest Request) {
		
			return "menu";
	}	
	

	@GetMapping("/d")
	public String Director(HttpServletRequest Request){
		Collection<Form> forms = Service.getForms();

	    Request.setAttribute("forms", forms);
		return "conclusion"; 
	}
	
   @PostMapping("/conclusion")
   public String conclusion(HttpServletRequest Request, Model model) {
	   String Type= Request.getParameter("Type");
	   String street= Request.getParameter("street");
	   String city= Request.getParameter("city");
	   String state= Request.getParameter("state");
	   String postal_code= Request.getParameter("postalcode");
	   String date= Request.getParameter("ReqDate");
       String username=Request.getParameter("username");
	   
	  SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
	  Date RequirDate = null;
	try {
		RequirDate = sdf.parse(date.intern());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  int postalcode= Integer.parseInt(postal_code);
	  //HttpSession session= Request.getSession();
	  //String username=(String) session.getAttribute("username");
	  
	  Form form= new Form(Type,username,street,city,state,postalcode,RequirDate,false);
	  
	   Service.AddForm(form);
	   Collection<Form> forms = Service.getForms();

	   Request.setAttribute("forms", forms);
	   return "conclusion";  
   }

   @PostMapping("/conclusion/hello")
   public String hello(HttpServletRequest Request, Model model) {
	   String Approved[]= Request.getParameterValues("approved");
	   for(int i=0; i<Approved.length; i++) {
		   Service.saveApprovedForm(Approved[i]);
	   }
	   return "hello";
   } 
	   
	   @PostMapping("/users/hello")
	   public String delete(HttpServletRequest Request, Model model) {
		   String Delete[]= Request.getParameterValues("delete");
		   for(int i=0; i<Delete.length; i++) {
			   Service.deleteuser(Delete[i]);
		   }
	   
	   return "hello";
   }
   
   @PostMapping("/menu/thankyou")
   public String thankyou(HttpServletRequest Request) {
	   String Type= Request.getParameter("Type");
	   String street= Request.getParameter("street");
	   String city= Request.getParameter("city");
	   String state= Request.getParameter("state");
	   String postal_code= Request.getParameter("postalcode");
	   String date= Request.getParameter("ReqDate");
       String username=Request.getParameter("username");
	   
	  SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
	  Date RequirDate = null;
	try {
		RequirDate = sdf.parse(date.intern());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  int postalcode= Integer.parseInt(postal_code);
	  //HttpSession session= Request.getSession();
	  //String username=(String) session.getAttribute("username");
	  
	  Form form= new Form(Type,username,street,city,state,postalcode,RequirDate,false);
	  
	   Service.AddForm(form);
	   
	   return "hello";  
   }
   
   @GetMapping("/p")
   public String personel(HttpServletRequest Request, Model model) {
	   
      // String Approved[]= Request.getParameterValues("approved");
          List<Form> ApprovedForms = new ArrayList<Form>();
       
          ApprovedForms=Service.getApprovedForms();
          
       Request.setAttribute("ApprovedForms", ApprovedForms);
	   return "personel";   
   }
 
   @GetMapping("/")
   public String choice() {
	   return "Choice";
   }
   
   @GetMapping("/users")
   public String users(HttpServletRequest Request) {
	   List<user> Users=new ArrayList<user>();
	   
	   Users=Service.getUsers();
	   Request.setAttribute("Users", Users);
	   
	   return "users";
   }
   
   
@Bean
public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
}
}
