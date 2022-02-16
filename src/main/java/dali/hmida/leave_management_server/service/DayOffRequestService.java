package dali.hmida.leave_management_server.service;


import dali.hmida.leave_management_server.LeaveManagementServerApplication;
import dali.hmida.leave_management_server.model.DayOffRequest;
import dali.hmida.leave_management_server.repository.DayOffRequestRepository;
import dali.hmida.leave_management_server.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class DayOffRequestService {

    private final DayOffRequestRepository dayOffRequestRepository;

    @Autowired
    public DayOffRequestService(final DayOffRequestRepository dayOffRequestRepository) {
        this.dayOffRequestRepository = dayOffRequestRepository;
    }

    public DayOffRequest saveDayOffRequest(DayOffRequest dayOffRequest){
        return dayOffRequestRepository.save(dayOffRequest);
    }

    public List<DayOffRequest> getBetween(Date start , Date end){
        return dayOffRequestRepository.findByStartDateIsLessThanAndEndDateIsGreaterThan(start, end);
    }


    // ma sta3melthech fonction 5ater badalneha bel fou9aniya

//    public ArrayList<DayOffRequest> getDayOffRequests(String date) throws ParseException {
//        int i;
////        ,day,year;
////        String month;
////        String[] substrings = date.split(",");
////        day = Integer.parseInt(substrings[0]) ;
////        month = substrings[1];
////        year = Integer.parseInt(substrings[2]);
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd, MMMM, yyyy", Locale.ENGLISH);
//        Date selectedDate = sdf.parse(date);
//
//        List<DayOffRequest> list = dayOffRequestRepository.findAll();
//        ArrayList<DayOffRequest> array = new ArrayList<>();
//        for (i = 0; i < list.size() ; i++)
//        {
//            //convert start date and end date
//            Date startDate = list.get(i).getStartDate();
//            Date endDate = list.get(i).getEndDate();
//            if (selectedDate.compareTo(startDate) == 0 || selectedDate.compareTo(endDate) == 0 || (selectedDate.compareTo(startDate)>0 && selectedDate.compareTo(endDate)<0)){
//                array.add(list.get(i));
//            }
//        }
//        return array;
//    }
    public void deleteAllDayOffRequests(){
        dayOffRequestRepository.deleteAll();
    }

    public List<DayOffRequest> getPendingDayOffs(){
        List<DayOffRequest> dayOffs = dayOffRequestRepository.findAll();
        List<DayOffRequest> pendingDayOffs = dayOffs
                .stream()
                .filter(d -> Objects.equals(d.getStatus(), "Pending"))
                .collect(Collectors.toList());
        return pendingDayOffs;
    }

    public List<DayOffRequest> getDayOffsHistory(){
        List<DayOffRequest> dayOffs = dayOffRequestRepository.findAll();
        List<DayOffRequest> DayOffsHistory = dayOffs
                .stream()
                .filter(d -> !Objects.equals(d.getStatus(), "Pending"))
                .collect(Collectors.toList());
        return DayOffsHistory;
    }

    public List<DayOffRequest> getAllDayOffs(){
        return dayOffRequestRepository.findAll();
    }

}
