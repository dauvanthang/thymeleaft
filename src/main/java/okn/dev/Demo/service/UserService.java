package okn.dev.Demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import okn.dev.Demo.dao.UserRepository;
import okn.dev.Demo.entity.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return (List<User>) repo.findAll();
	}
	
	public void save(User user) {
		repo.save(user);
	}
	
	public User findById(int id) {
		return repo.findById(id).get();
	}
	
	public void deleteById(int id) {
		repo.deleteById(id);
	}
	
}
