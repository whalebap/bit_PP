package com.person.web.controllers;

import com.person.web.domains.TrailDTO;
import com.person.web.mappers.TrailMapper;
import com.person.web.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/trails")
public class TrailController {
    @Autowired
    TrailDTO trail;
    @Autowired
    Proxy pxy;
    @Autowired
    TrailMapper trailMapper;

    @GetMapping("/list")
    public Map<String, Object> list(){
        pxy.print(trailMapper.selectAll().get(5).toString());

        Map<String, Object> trailMap = new HashMap<>();
        trailMap.put("list", trailMapper.selectAll());
        trailMap.put("count", trailMapper.count());
        pxy.print(trailMap.get("count").toString());
        return trailMap;
    }
}
