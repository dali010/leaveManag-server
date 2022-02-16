package dali.hmida.leave_management_server.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
public class Day {
    @Id
    private String id;
    private String requester;
    private Integer period;
    private String status;
    private String type;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date endDate;

    public Day(String requester, Integer period, String status, String type, Date startDate, Date endDate){
        this.requester = requester;
        this.period = period;
        this.status = status;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
