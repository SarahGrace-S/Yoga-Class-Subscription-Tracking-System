package com.examly.springapp.service;

import com.examly.springapp.model.Member;
import com.examly.springapp.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // DAY 10
    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    // DAY 10
    @Override
    public Member getById(int id) {
        return memberRepository.findById(id).orElse(null);
    }

    // DAY 9
    @Override
    public List<Member> getMembersWithPagination(int page, int size) {

        if (size > 5) {
            size = 5;
        }

        return memberRepository
                .findAll(PageRequest.of(page, size))
                .getContent();
    }
}