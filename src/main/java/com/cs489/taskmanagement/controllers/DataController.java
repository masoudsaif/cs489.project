package com.cs489.taskmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cs489.taskmanagement.services.DataService;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping("/insert")
    public void insertData() {
        dataService.insertData();
    }
}
