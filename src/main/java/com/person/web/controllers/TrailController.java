package com.person.web.controllers;

import com.person.web.domains.TrailDTO;
import com.person.web.proxy.Proxy;
import com.person.web.service.TrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/trails")
public class TrailController {
    @Autowired
    TrailDTO trail;
    @Autowired
    TrailService trailService;
    @Autowired
    Proxy pxy;

    @GetMapping("")
    public List<TrailDTO> list(){
        pxy.print(trailService.selectAll().toString());
        return trailService.selectAll();
    }
}
