package okn.dev.Demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import okn.dev.Demo.entity.Destination;
import okn.dev.Demo.entity.User;
import okn.dev.Demo.service.DestinationService;
import okn.dev.Demo.service.UserService;

@Controller    // This means that this class is a Controller
public class UserController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private UserService userService;
	
	@Autowired 
	private DestinationService destinationService;
	
	@RequestMapping("/new")
	public String showNewUserPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		List<Destination> listDestinations = destinationService.findAll();
		model.addAttribute("listDestinations", listDestinations);
		return "new_user";
	}
	
	

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/all";
	}
	
	@RequestMapping(value = {"/all", "/"})
	public String getAllUsers(Model model) {
		List<User> listUsers = userService.findAll();
		model.addAttribute("listUsers", listUsers);
		return "index";
	}
	
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable(name = "id") int id) {
		userService.deleteById(id);
		return "redirect:/all";		
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditUserPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_user");
		User user = userService.findById(id);
		mav.addObject("user", user);
		
		List<Destination> listDestinations = destinationService.findAll();
		mav.addObject("listDestinations", listDestinations);
		return mav;
	}
}