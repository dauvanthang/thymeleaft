package okn.dev.Demo.dao;


import org.springframework.data.repository.CrudRepository;

import okn.dev.Demo.entity.Destination;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DestinationRepository extends CrudRepository<Destination, Integer> {

}
