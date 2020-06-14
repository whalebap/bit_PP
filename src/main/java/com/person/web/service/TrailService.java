package com.person.web.service;

import com.person.web.domains.TrailDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TrailService {
    public List<TrailDTO> selectAll();
}
