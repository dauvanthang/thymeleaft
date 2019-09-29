package okn.dev.Demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import okn.dev.Demo.dao.DestinationRepository;
import okn.dev.Demo.entity.Destination;

@Service
@Transactional
public class DestinationService {

	@Autowired
	private DestinationRepository repo;
	
	public List<Destination> findAll() {
		return (List<Destination>) repo.findAll();
	}
	
	
	
	public Destination findById(int id) {
		return repo.findById(id).get();
	}
	
	public void deleteById(int id) {
		repo.deleteById(id);
	}
	
}
