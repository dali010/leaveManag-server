package dali.hmida.leave_management_server.service;


import dali.hmida.leave_management_server.model.Employee;
import dali.hmida.leave_management_server.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public EmployeeService(final EmployeeRepository employeeRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.employeeRepository = employeeRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Employee saveEmployee(Employee employee){
        employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
       return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee, Employee requestEmployee){
        employee.setEmail(requestEmployee.getEmail());
        employee.setUsername(requestEmployee.getUsername());
        employee.setLocation(requestEmployee.getLocation());
        employee.setPhoneNumber(requestEmployee.getPhoneNumber());
        return employeeRepository.save(employee);
    }

    public void deleteAllEmployees(){
        employeeRepository.deleteAll();
    }

    public List<Employee> getEmployeeByUsername(String username){
        return employeeRepository.findByEmail(username);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String id){
        return employeeRepository.findById(id).orElse(null);
    }


}
