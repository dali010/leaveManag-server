package dali.hmida.leave_management_server;

import dali.hmida.leave_management_server.model.DayOffRequest;
import dali.hmida.leave_management_server.model.Employee;
import dali.hmida.leave_management_server.model.Type;
import dali.hmida.leave_management_server.service.DayOffRequestService;
import dali.hmida.leave_management_server.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SpringBootApplication
public class LeaveManagementServerApplication {

	private static EmployeeService employeeService;
	private static DayOffRequestService dayOffRequestService;

	@Autowired
	public LeaveManagementServerApplication(EmployeeService employeeService, DayOffRequestService dayOffRequestService) {
		this.employeeService = employeeService;
		this.dayOffRequestService = dayOffRequestService;
	}

	public static void main(String[] args) {
		SpringApplication.run(LeaveManagementServerApplication.class, args);
		log();

//		Logger logger = LoggerFactory.getLogger(LeaveManagementServerApplication.class);
//		logger.error("daaa");
	}

	public static void log(){
		employeeService.deleteAllEmployees();
		dayOffRequestService.deleteAllDayOffRequests();

		// saving to employees in database
		Employee emp1 = new Employee("mohamedali.hmida@isimg.tn","dali",Type.MANAGER.toString(),"Bennane",55683657,"Dali123");
		Employee emp2 = new Employee("mehdi.hmida@isimg.tn","mehdi",Type.EMPLOYEE.toString(),"bennane",99664555,"Mehdi147");
		employeeService.saveEmployee(emp1);
		employeeService.saveEmployee(emp2);
		Logger logger = LoggerFactory.getLogger(LeaveManagementServerApplication.class);
		logger.error(emp1.toString());

		//preparing date
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd, MMMM, yyyy", Locale.ENGLISH);
		Date selectedDate = new Date(date.getTime());
		Date selectedDate1 = new Date(date.getTime() + (172800000*2));
		Date selectedDate2 = new Date(date.getTime() + (172800000*3));
		Date selectedDate3 = new Date(date.getTime() + (172800000*4));
		Date selectedDate4 = new Date(date.getTime() + (172800000*5));
		Date selectedDate5 = new Date(date.getTime() + (84600000*3));



		// saving two dayOff requests
		DayOffRequest dayOffRequest2 = new DayOffRequest("Mehdi",2,"Pending","Casual",selectedDate,selectedDate4);
		DayOffRequest dayOffRequest3 = new DayOffRequest("Saied",1,"Accepted","Casual",selectedDate,selectedDate3);
		DayOffRequest dayOffRequest4 = new DayOffRequest("Naziha",5,"Refused","Casual",selectedDate,selectedDate1);
		DayOffRequest dayOffRequest5 = new DayOffRequest("Rachida",5,"Refused","Illness",selectedDate,selectedDate5);
		DayOffRequest dayOffRequest6 = new DayOffRequest("Dali",1,"Accepted","Casual",selectedDate,selectedDate2);
		dayOffRequestService.saveDayOffRequest(dayOffRequest2);
		dayOffRequestService.saveDayOffRequest(dayOffRequest3);
		dayOffRequestService.saveDayOffRequest(dayOffRequest4);
		dayOffRequestService.saveDayOffRequest(dayOffRequest5);
		dayOffRequestService.saveDayOffRequest(dayOffRequest6);
	}
}
