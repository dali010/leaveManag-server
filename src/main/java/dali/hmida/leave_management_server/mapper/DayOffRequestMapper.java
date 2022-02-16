package dali.hmida.leave_management_server.mapper;

import dali.hmida.leave_management_server.dto.DayOffRequestDTO;
import dali.hmida.leave_management_server.model.DayOffRequest;
import lombok.SneakyThrows;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.text.SimpleDateFormat;
import java.util.Locale;

@Mapper(componentModel = "spring")
public abstract class DayOffRequestMapper {

    public final static DayOffRequestMapper MAPPER = Mappers.getMapper(DayOffRequestMapper.class);

    public abstract DayOffRequest fromDto(DayOffRequestDTO dayOffRequestDTO);

    public abstract DayOffRequestDTO toDto(DayOffRequest dayOffRequest);

    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    @AfterMapping
    @SneakyThrows
    void updateDayOffRequest(final DayOffRequestDTO dayOffRequestDTO, @MappingTarget final DayOffRequest dayOffRequest) {

        dayOffRequest.setStartDate(formatter.parse(dayOffRequestDTO.getStartDate()));
        dayOffRequest.setEndDate(formatter.parse(dayOffRequestDTO.getEndDate()));
    }// copy erreur fil google oki
    @AfterMapping
    void updateDayOffRequestDTO(final DayOffRequest dayOffRequest, @MappingTarget final DayOffRequestDTO dayOffRequestDTO) {
        dayOffRequestDTO.setStartDate(formatter.format(dayOffRequest.getStartDate()));
        dayOffRequestDTO.setEndDate(formatter.format(dayOffRequest.getEndDate()));
    }


}
