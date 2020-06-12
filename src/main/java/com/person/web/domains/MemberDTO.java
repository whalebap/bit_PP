package com.person.web.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberDTO {
    private String userid, password, name, email;
}
