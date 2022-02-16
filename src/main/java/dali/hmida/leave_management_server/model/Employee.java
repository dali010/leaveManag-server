package dali.hmida.leave_management_server.model;


import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dali.hmida.leave_management_server.repository.EmployeeRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Employee {
    @Id
    private String id;
    private String email;
    private String username;
    private String type;
    private String location;
    private Integer phoneNumber;
    private String password;

    public Employee(String email,String username,String type, String location, Integer phoneNumber,String password) {
        this.email = email;
        this.username = username;
        this.type = type;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
