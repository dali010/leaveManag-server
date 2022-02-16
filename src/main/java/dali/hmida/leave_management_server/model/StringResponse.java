package dali.hmida.leave_management_server.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StringResponse {
    private String msg;

    public StringResponse(String msg) {
        this.msg = msg;
    }
}
