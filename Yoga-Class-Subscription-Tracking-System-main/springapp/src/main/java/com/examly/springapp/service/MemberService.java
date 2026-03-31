package com.examly.springapp.service;

import com.examly.springapp.model.Member;
import java.util.List;

public interface MemberService {

    Member save(Member member);

    Member getById(int id);

    // DAY 9
    List<Member> getMembersWithPagination(int page, int size);
}