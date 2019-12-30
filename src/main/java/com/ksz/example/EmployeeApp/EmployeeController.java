package com.ksz.example.EmployeeApp;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    List<String> emps = new CopyOnWriteArrayList<>();

    {
        emps.addAll(Arrays.asList("Mietek", "Staszek", "Marek"));
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<String> getEmployees()
    {
        return emps;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public int addEmployee(@RequestBody String name)
    {
        emps.add(name);
        return emps.size();`
    }

}
