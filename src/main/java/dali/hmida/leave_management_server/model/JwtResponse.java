package dali.hmida.leave_management_server.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private final String username;
    private final String password;

    public JwtResponse(String jwttoken, String username, String password) {
        this.jwttoken = jwttoken;
        this.username = username;
        this.password = password;
    }
}