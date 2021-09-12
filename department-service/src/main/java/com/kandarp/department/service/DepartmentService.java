package com.kandarp.department.service;

import com.kandarp.department.entity.Department;
import com.kandarp.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DepartmentService.class);

    public Department saveDepartment(Department department) {
        log.info("Saving department using saveDepartment in DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findByDepartmentId(Long departmentId) {
        log.info("Getting department using getDepartmentById in DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }

    public ArrayList<Department> findDepartments() {
        return (ArrayList<Department>) departmentRepository.findAll();
    }
}
