package se.claudiastenberg.smsprogram.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.claudiastenberg.smsprogram.model.Appoinment;

@Repository
public interface AppoinmentRepository extends CrudRepository<Appoinment, Long>{
}
