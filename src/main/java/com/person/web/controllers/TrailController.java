package com.person.web.controllers;

import com.person.web.domains.TrailDTO;
import com.person.web.mappers.TrailMapper;
import com.person.web.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @GetMapping("/aaa")
    public Map<?, ?> list(){
        pxy.print(trailMapper.selectAll().get(5).toString());

        Map<String, Object> map = new HashMap<>();
        map.put("list", trailMapper.selectAll());
        map.put("count", String.valueOf(trailMapper.selectAll().size()));
        pxy.print(map.get("count").toString());
        return map;
    }
}
