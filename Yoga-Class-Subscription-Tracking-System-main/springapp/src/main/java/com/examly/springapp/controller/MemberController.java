package com.examly.springapp.controller;

import com.examly.springapp.model.Member;
import com.examly.springapp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // CREATE MEMBER
    @PostMapping(value = {"", "/"}, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Member createMember(@RequestBody Member member) {
        return memberService.save(member);
    }

    // GET MEMBER BY ID
    @GetMapping({"/{id}", "/{id}/"})
    public Member getMemberById(@PathVariable int id) {
        return memberService.getById(id);
    }

    // UPDATE MEMBER (KEEP setId FOR TEST CASES)
    @PutMapping(value = {"/{id}", "/{id}/"}, consumes = "application/json")
    public Member updateMember(@PathVariable int id, @RequestBody Member member) {
        member.setId(id);   // ⚠️ REQUIRED for test cases
        return memberService.save(member);
    }

    // GET ALL MEMBERS WITH PAGINATION
    @GetMapping({"/page/{page}/{size}", "/page/{page}/{size}/"})
    public List<Member> getMembersWithPagination(
            @PathVariable int page,
            @PathVariable int size) {

        return memberService.getMembersWithPagination(page, size);
    }
}
