package dali.hmida.leave_management_server.controller;

import dali.hmida.leave_management_server.LeaveManagementServerApplication;
import dali.hmida.leave_management_server.config.JwtTokenUtil;
import dali.hmida.leave_management_server.model.Employee;
import dali.hmida.leave_management_server.model.JwtRequest;
import dali.hmida.leave_management_server.model.Response;
import dali.hmida.leave_management_server.model.StringResponse;
import dali.hmida.leave_management_server.repository.EmployeeRepository;
import dali.hmida.leave_management_server.service.EmployeeService;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin()
public class HelloWorldController {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;
    private final JwtTokenUtil jwtTokenUtil;

    public HelloWorldController(EmployeeService employeeService, EmployeeRepository employeeRepository, JwtTokenUtil jwtTokenUtil) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
        this.jwtTokenUtil = jwtTokenUtil;
    }


    @RequestMapping(value = "/daa", method = RequestMethod.GET)
    public Employee getEmployee(@RequestParam(name = "username") @NotNull final String username) {
        List<Employee> employees ;
        employees = employeeService.getEmployeeByUsername(username);
        if (employees.size()>0){
            return employees.get(0);
        }
        throw new UsernameNotFoundException("User Not found");

    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public Response getEmployee(@RequestBody JwtRequest authenticationRequest) {
        List<Employee> employees ;
        employees = employeeService.getEmployeeByUsername(authenticationRequest.getUsername());
        if (employees.size()>0){
            if (Objects.equals(employees.get(0).getPassword(), authenticationRequest.getPassword())){
                final String token = jwtTokenUtil.generateTokenUpdated(authenticationRequest);
                return new Response(token,employees.get(0).getType());
            }
        }
        throw new UsernameNotFoundException("User Not found");
    }

}
