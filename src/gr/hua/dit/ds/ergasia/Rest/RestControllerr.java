package gr.hua.dit.ds.ergasia.Rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.ds.ergasia.Service.SystemService;
import gr.hua.dit.ds.ergasia.entity.Form;

@RestController
@RequestMapping("/api")
public class RestControllerr {

	@Autowired
	private SystemService Service;
	
	
	@GetMapping("/forms")
	public List<Form> getforms(){
		
		return Service.getForms();	
	}
}
