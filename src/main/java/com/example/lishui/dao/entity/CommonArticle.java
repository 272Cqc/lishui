package com.example.lishui.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: jesse
 * @Date: 2021/1/11 10:17 上午
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("通用文章实体")
public class CommonArticle {
    @Id
    @GeneratedValue
    @ApiModelProperty("id")
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty(value = "一级模块名称",required = true)
    private String module;

    @Column(nullable = false)
    @ApiModelProperty(value = "二级模块名称",required = true)
    private String tag = "未分类";

    @Column(nullable = false)
    @ApiModelProperty(value = "标题",required = true)
    private String title;

    @Column(nullable = false)
    @ApiModelProperty(value = "封面图",required = true)
    private String coverImg;

    @Column(nullable = false)
    @ApiModelProperty(value = "文章类型：图片，链接，视频",required = true)
    private Integer type;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = false)
    @ApiModelProperty(value = "文章内容",required = true)
    private String content;

    @Column()
    @ApiModelProperty(value = "发布人",required = true)
    private String username;

    @Column(nullable = false)
    @ApiModelProperty(value = "0隐藏，1展示")
    private Integer status = 1;

    @ApiModelProperty(value = "创建时间")
    @CreationTimestamp
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(nullable = false,columnDefinition = "int not null default 0")
    @ApiModelProperty(value = "排序")
    private Integer weight;

    @ApiModelProperty(value = "更新时间")
    @UpdateTimestamp
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
}