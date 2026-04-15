package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    @GetMapping
    public List<SoftareEngineer> getAllSoftwareEngineers() {
        return List.of(
                new SoftareEngineer(1, "John", "Java"),
                new SoftareEngineer(2, "Jane", "Python"),
                new SoftareEngineer(3, "Bob", "C++"));
    }

}
