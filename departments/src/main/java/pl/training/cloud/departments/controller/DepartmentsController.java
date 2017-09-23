package pl.training.cloud.departments.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.training.cloud.common.model.Mapper;
import pl.training.cloud.common.web.UriBuilder;
import pl.training.cloud.departments.dto.DepartmentDto;
import pl.training.cloud.departments.service.DepartmentNotFoundException;
import pl.training.cloud.departments.service.DepartmentsService;

import java.util.Locale;

@Api(description = "Departments resource")
@RequestMapping("departments")
@RestController
public class DepartmentsController {

    private DepartmentsService departmentsService;
    private Mapper mapper;
    private UriBuilder uriBuilder = new UriBuilder();

    public DepartmentsController(DepartmentsService departmentsService, Mapper mapper) {
        this.departmentsService = departmentsService;
        this.mapper = mapper;
    }

    @ApiOperation(value = "Get department by id", response = DepartmentDto.class)
    @RequestMapping(value = "{department-id}", method = RequestMethod.GET)
    public String getDepartmentById(@PathVariable("department-id") Long id) {
        String department = departmentsService.getDepartmentById(id);
        return department;
    }



    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity onOrganizationNotFound(DepartmentNotFoundException ex, Locale locale) {
        return new ResponseEntity<>(mapper.map(ex, locale), HttpStatus.NOT_FOUND);
    }

}
