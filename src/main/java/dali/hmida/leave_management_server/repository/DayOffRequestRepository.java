package dali.hmida.leave_management_server.repository;


import dali.hmida.leave_management_server.model.DayOffRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DayOffRequestRepository extends MongoRepository<DayOffRequest,String> {


    List<DayOffRequest> findByStartDateIsLessThanAndEndDateIsGreaterThan(Date selected, Date selectedDate);

}
