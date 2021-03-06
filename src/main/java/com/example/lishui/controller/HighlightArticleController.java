package com.example.lishui.controller;

import com.example.lishui.dao.HighlightArticleRepository;
import com.example.lishui.dao.entity.HighlightArticle;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: jesse
 * @Date: 2021/1/13 5:44 下午
 */
@RequestMapping("/api/highlightArticles")
@RestController
@Api(tags = "闪光时刻文章接口")
public class HighlightArticleController {
    @Resource
    HighlightArticleRepository highlightArticleRepository;

    @Transactional
    @Operation(summary = "批量更新")
    @PostMapping("batchUpdate")
    public ResponseEntity<?> batchUpdate(@RequestBody List<HighlightArticle> lists) throws Exception {
        return ResponseEntity.ok(highlightArticleRepository.saveAll(lists).stream().sorted(Comparator.comparingInt(HighlightArticle::getWeight)).collect(Collectors.toList()));
    }
}
