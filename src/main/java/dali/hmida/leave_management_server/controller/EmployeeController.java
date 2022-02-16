package dali.hmida.leave_management_server.controller;


import dali.hmida.leave_management_server.config.JwtTokenUtil;
import dali.hmida.leave_management_server.model.Employee;
import dali.hmida.leave_management_server.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin()
public class EmployeeController {

    private final EmployeeService employeeService;
    private final JwtTokenUtil jwtTokenUtil;


    public EmployeeController(EmployeeService employeeService, JwtTokenUtil jwtTokenUtil) {
        this.employeeService = employeeService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/employeeUsername", method = RequestMethod.GET)
    public List<Employee> getEmployees(@RequestParam(name = "username") final String username) {
        return employeeService.getEmployeeByUsername(username);
    }

    @RequestMapping(value = "/loggedInUser", method = RequestMethod.GET)
    public Employee getLoggedInUser(@RequestHeader("Authorization") String token) {
        String jwtToken = token.substring(7);
        List<Employee> employees = employeeService.getEmployeeByUsername(jwtTokenUtil.getUsernameFromToken(jwtToken));
        if (employees.size()>0 ){
            return employees.get(0);
        }else {
            throw new UsernameNotFoundException("User not found with email: " + jwtTokenUtil.getUsernameFromToken(jwtToken));
        }

    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestHeader("Authorization") String token,@RequestBody Employee employeeDetails)  {
        String jwtToken = token.substring(7);
        List<Employee> employees = employeeService.getEmployeeByUsername(jwtTokenUtil.getUsernameFromToken(jwtToken));
        if (employees.size()>0 ){
            Employee employee = employees.get(0);
            final Employee updatedEmployee = employeeService.updateEmployee(employee, employeeDetails);
            return updatedEmployee;
        }else {
            throw new UsernameNotFoundException("User not found with email: " + jwtTokenUtil.getUsernameFromToken(jwtToken));
        }
//
//        Employee employee = employeeService.getEmployeeById(employeeId);
//        if (employee != null){
//            employee.setEmail(employeeDetails.getEmail());
//            employee.setUsername(employeeDetails.getUsername());
//            employee.setLocation(employeeDetails.getLocation());
//        }
//        final Employee updatedEmployee = employeeService.saveEmployee(employee);
//        return updatedEmployee;
    }
}

