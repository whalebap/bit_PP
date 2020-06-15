package com.person.web.controllers;


import com.person.web.domains.MemberDTO;
import com.person.web.mappers.MemberMapper;
import com.person.web.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/members")
public class MemberController {
@Autowired
    MemberDTO member;
@Autowired
    Proxy pxy;
@Autowired
    MemberMapper memberMapper;

@PostMapping("/join")
    public void join(@RequestBody MemberDTO member) {
    pxy.print("----------");
    pxy.print(member.toString());
    memberMapper.insertMember(member);
}

}
