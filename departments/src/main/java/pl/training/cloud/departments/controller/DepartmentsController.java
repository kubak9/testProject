package pl.training.cloud.departments.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.training.cloud.departments.service.DepartmentsService;

@RequestMapping("departments")
@RestController
public class DepartmentsController {

    private DepartmentsService departmentsService;

    public DepartmentsController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @RequestMapping(value = "{department-id}", method = RequestMethod.GET)
    public String getDepartmentById(@PathVariable("department-id") Long id) {
        String department = departmentsService.getDepartmentById(id);
        return department;
    }



}
