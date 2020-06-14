package com.person.web.serviceImpl;

import com.person.web.domains.TrailDTO;
import com.person.web.service.TrailService;
import com.person.web.mappers.TrailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrailServiceImpl implements TrailService {
    @Autowired
    TrailMapper trailMapper;
    @Override
    public List<TrailDTO> selectAll() {
        return trailMapper.selectAll();
    }
}
