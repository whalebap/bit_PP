package com.person.web.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TrailDTO {
    private String trailName, courseName, route, location, difficulty, distance, detailDistance, detail, timeRequired;
}
