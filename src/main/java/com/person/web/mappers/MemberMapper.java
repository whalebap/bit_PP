package com.person.web.mappers;

import com.person.web.domains.MemberDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {
    public MemberDTO login(MemberDTO member);

    public void insertMember(MemberDTO member);

    public String searchId(String userId);

    public void updateInfo(MemberDTO member);

    public void deleteMember(MemberDTO member);
}
