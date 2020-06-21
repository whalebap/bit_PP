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
    public Map<?, ?> join(@RequestBody MemberDTO member) {
    pxy.print("----------");
    pxy.print(member.toString());
    HashMap map = new HashMap();
    String message = "";
    if(member.getUserId().equals(memberMapper.searchId(member.getUserId()))) {
        message = "중복된 ID입니다. 다른 ID를 입력해주세요.";
        map.put("message", message);
        map.put("result", false);
    } else {
        memberMapper.insertMember(member);
        message = "회원가입 성공";
        map.put("message", message);
        map.put("result", true);
    }
    pxy.print(message);
    return map;
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
public Map<?, ?> idCheck(@PathVariable String userId){
    HashMap map = new HashMap();
    String message = "";
    if(userId.equals(memberMapper.searchId(userId))) {
        message = "중복된 ID입니다. 다른 ID를 입력해주세요.";
    } else {
        message = "가입 가능한 ID입니다.";
    }
    pxy.print(message);
    map.put("message", message);
    return map;
}
@PostMapping("/{userId}/update")
    public Map<?, ?> updateUser(@PathVariable String userId, @RequestBody MemberDTO member){
    pxy.print("--자바 방문함");
    HashMap map = new HashMap();
    memberMapper.updateInfo(member);
    map.put("message", "회원정보 변경 완료");
    pxy.print("-----------------");
    pxy.print(memberMapper.login(member).toString());
    return map;
}
@PostMapping("/{userId}/delete")
    public Map<?,?> deleteMember(@PathVariable String userId, @RequestBody MemberDTO member){
    pxy.print("회원탈퇴 시작");
    pxy.print((member.toString()));
    HashMap map = new HashMap();
    memberMapper.deleteMember(member);
    if(memberMapper.searchId(userId) == null) {
        map.put("message", "회원탈퇴 완료");
    } else{
        map.put("message", "다시 시도해 주세요");
    }
    pxy.print(map.get("message").toString());
    return map;
}

}
