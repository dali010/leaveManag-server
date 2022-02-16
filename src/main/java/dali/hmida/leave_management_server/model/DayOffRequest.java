package dali.hmida.leave_management_server.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
public class DayOffRequest {
    @Id
    private String id;
    private String requester;
    private Integer period;
    private String status;
    private String type;
    private Date startDate;
    private Date endDate;

    public DayOffRequest(String requester, Integer period, String status, String type, Date startDate, Date endDate){
        this.requester = requester;
        this.period = period;
        this.status = status;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

// win linna

