package pl.training.cloud.departments.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.training.cloud.departments.dto.DepartmentDto;
import pl.training.cloud.departments.service.DepartmentsService;

@Api(description = "Departments resource")
@RequestMapping("departments")
@RestController
public class DepartmentsController {

    private DepartmentsService departmentsService;

    public DepartmentsController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @ApiOperation(value = "Get department by id", response = DepartmentDto.class)
    @RequestMapping(value = "{department-id}", method = RequestMethod.GET)
    public String getDepartmentById(@PathVariable("department-id") Long id) {
        String department = departmentsService.getDepartmentById(id);
        return department;
    }



}
