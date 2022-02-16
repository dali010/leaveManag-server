package dali.hmida.leave_management_server.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import dali.hmida.leave_management_server.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Employee> employees ;
        employees = employeeService.getEmployeeByUsername(username);
        if (employees.size()>0 && Objects.equals(username, employees.get(0).getEmail())){
                return new User(username, employees.get(0).getPassword(),
                        new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
//
//        if ("javainuse".equals(username)) {
//            return new User("javainuse", "$2a$10$TfJ8EEGNQhX/iv3THQ8UYO9yQ61yTyPJf3Xy5UYlmADGRwPW6cU3y",
//                    new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
    }

}

