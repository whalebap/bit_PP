package com.person.web.controllers;


import com.person.web.domains.MemberDTO;
import com.person.web.mappers.MemberMapper;
import com.person.web.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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



    memberMapper.insertMember(member);;
}

@PostMapping("/{userId}/login")
    public Map<String, Object> login(@PathVariable String userId, @RequestBody MemberDTO member){

    pxy.print(userId);
    pxy.print(member.toString());
    Map<String, Object> map = new HashMap<>();
    if (memberMapper.login(member) != null) {
        pxy.print(memberMapper.login(member).toString());
        map.put("result", true);
    } else{
        map.put("result", false);
    }
    map.put("member", memberMapper.login(member));
    return map;
}
@GetMapping("/{userId}/idCheck")
public String idCheck(@PathVariable String userId){
    String message = "";
    pxy.print(userId);
    if(userId.equals(memberMapper.search(userId))) {
        message = "중복된 ID입니다. 다른 ID를 입력해주세요.";
    } else {
        message = "가입 가능한 ID입니다.";
    }
    pxy.print(message);
    return message;
}


}
