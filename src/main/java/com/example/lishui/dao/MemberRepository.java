package com.example.lishui.dao;

import com.example.lishui.dao.entity.Member;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Created by jesse on 2020/12/11 下午7:56
 */
@Api(tags = "机构成员接口")
public interface MemberRepository extends JpaRepository<Member,Long> {
    @Query(value = "select max(weight) from member",nativeQuery = true)
    Optional<Integer> findMaxWeight();
}