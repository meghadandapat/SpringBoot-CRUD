package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    //json which we are getting as req body convert that to department obj
    public Department saveDepartment(@RequestBody Department department){
    //pass the department object to service layer
        //service layer will contain a method called save departemnt
        return departmentService.saveDepartment(department);

}
     @GetMapping("/departments")
        public List<Department> fetchDepartmentlist(){
            return departmentService.fetchDepartmentList();
     }

     @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.fetchDepartmentById(departmentId);
     }

     @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
       departmentService.deleteDepartmentById(departmentId);
       return "Deleted Successfully";
     }

     @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        //will need both id and request body as paramenter
        return departmentService.updateDepartment(departmentId,department);
     }

}
