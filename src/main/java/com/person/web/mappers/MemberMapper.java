package com.person.web.mappers;

import com.person.web.domains.MemberDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {
    public void insertMember(MemberDTO member);
}
