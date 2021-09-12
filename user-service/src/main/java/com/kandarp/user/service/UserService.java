package com.kandarp.user.service;

import com.kandarp.user.entity.User;
import com.kandarp.user.repository.UserRepository;
import com.kandarp.user.value.objects.Department;
import com.kandarp.user.value.objects.ResponseTemplateValueObjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findByUserId(Long userId) {
        return userRepository.findByUserId(userId);
    }

    public ArrayList<User> findUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public ResponseTemplateValueObjects getUserWithDepartment(Long userId) {
        ResponseTemplateValueObjects valueObject = new ResponseTemplateValueObjects();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/id/" + user.getDepartmentId(), Department.class);
        valueObject.setUser(user);
        valueObject.setDepartment(department);
        return valueObject;
    }
}
