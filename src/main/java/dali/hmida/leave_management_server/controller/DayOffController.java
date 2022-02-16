package dali.hmida.leave_management_server.controller;

import dali.hmida.leave_management_server.dto.DayOffRequestDTO;
import dali.hmida.leave_management_server.mapper.DayOffRequestMapper;
import dali.hmida.leave_management_server.model.DayOffRequest;
import dali.hmida.leave_management_server.model.Employee;
import dali.hmida.leave_management_server.service.DayOffRequestService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin()
public class DayOffController {

    private final DayOffRequestService dayOffRequestService;

    public DayOffController(DayOffRequestService dayOffRequestService) {
        this.dayOffRequestService = dayOffRequestService;
    }

    @RequestMapping(value = "/selectedDayOff", method = RequestMethod.GET)
    public List<DayOffRequest> getDayOff(@RequestParam(name = "date") final String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd, MMMM, yyyy", Locale.ENGLISH);
        Date selectedDate = sdf.parse(date);

        return dayOffRequestService.getBetween(selectedDate, selectedDate);
    }

    @RequestMapping(value = "/dayOffs", method = RequestMethod.GET)
    public List<DayOffRequest> getDayOffs() {
        return dayOffRequestService.getAllDayOffs();
    }

    @RequestMapping(value = "/saveDayOff", method = RequestMethod.POST)
    public DayOffRequest saveDayOff(@RequestBody DayOffRequestDTO dayOffRequestDTO) {
        return dayOffRequestService.saveDayOffRequest(DayOffRequestMapper.MAPPER.fromDto(dayOffRequestDTO));
    }

}

