package dali.hmida.leave_management_server.repository;

import dali.hmida.leave_management_server.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {

    List<Employee> findByEmail(String s);

}
