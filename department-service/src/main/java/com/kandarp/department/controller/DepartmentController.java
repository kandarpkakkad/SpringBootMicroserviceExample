package com.kandarp.department.controller;

import com.kandarp.department.entity.Department;
import com.kandarp.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping("/id/{departmentId}")
    public  Department findByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        log.info("Getting department using getDepartmentById in DepartmentController");
        return departmentService.findByDepartmentId(departmentId);
    }

    @GetMapping("/")
    public ArrayList<Department> findDepartments() {
        log.info("Getting department using getDepartmentById in DepartmentController");
        return departmentService.findDepartments();
    }

    @PostMapping("/")
    public Department saveDepartment (@RequestBody Department department) {
        log.info("Saving department using saveDepartment in DepartmentController");
        return departmentService.saveDepartment(department);
    }
}
