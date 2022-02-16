package dali.hmida.leave_management_server.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private String jwttoken;
    private String type;

    public Response(String jwttoken,String type) {
        this.jwttoken = jwttoken;
        this.type = type;
    }
}

