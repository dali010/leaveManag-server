package dali.hmida.leave_management_server.dto;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class DayOffRequestDTO {
    @Id
    private String id;
    private String requester;
    private Integer period;
    private String status;// abel faza li 3malneha fama fonction ma3adech temchi li hiya
    private String type;
    private String startDate;
    private String endDate;

    public DayOffRequestDTO(String requester, Integer period, String status, String type, String startDate, String endDate){
        this.requester = requester;
        this.period = period;
        this.status = status;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

// win linna

