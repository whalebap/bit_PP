package com.person.web.mappers;

import com.person.web.domains.TrailDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface TrailMapper {
    List<TrailDTO> selectAll();
    int count();
}
