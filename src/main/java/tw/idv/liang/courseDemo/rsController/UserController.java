package tw.idv.liang.courseDemo.rsController;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.liang.courseDemo.entity.User;
import tw.idv.liang.courseDemo.service.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@RequestMapping(value = "/getAllUsers", method=RequestMethod.GET)
	public String getAllUsers() {
		String returnValue="";
		try{
			System.out.println("getAllUsers");
			UserService userService = new UserService();
			List<User> result=userService.getUsers();			
			ObjectMapper objectMapper = new ObjectMapper();	
			returnValue=objectMapper.writeValueAsString(result);
		}
		catch(Exception x){
			System.out.println("failed");
			System.out.println(x.toString());
		}
		return returnValue;
	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createUser(@RequestBody User user) {
		String returnValue="";
		try{
			System.out.println("getUserbyUserId");
			UserService userService = new UserService();
			int id = userService.insert(user);
			ObjectMapper objectMapper = new ObjectMapper();	
			returnValue=objectMapper.writeValueAsString(id);
		}
		catch(Exception x){
			System.out.println("failed");
			System.out.println(x.toString());
		}
		return returnValue;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(@RequestBody User user) {
		try{
			System.out.println("updateUser");
			UserService userService = new UserService();
			userService.update(user);
		}
		catch(Exception x){
			System.out.println("failed");
			System.out.println(x.toString());
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
	public void updateUser(@PathVariable String id) {
		try{
			System.out.println("updateUser");
			UserService userService = new UserService();
			userService.delete(id);
		}
		catch(Exception x){
			System.out.println("failed");
			System.out.println(x.toString());
		}
	}
}
