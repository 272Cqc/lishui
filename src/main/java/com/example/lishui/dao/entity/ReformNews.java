package com.example.lishui.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by jesse on 2020/12/14 下午1:49
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("改革动态实体")
public class ReformNews implements Serializable {
    @Id
    @GeneratedValue
    @ApiModelProperty("id")
    private Long id;

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
    @ApiModelProperty(value = "所属部门",required = true)
    private String department;
//    @Column(name = "department_id")
//    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
//    @JoinColumn(name = "department_id")
//    private Department department;

    @Column(nullable = false)
    @ApiModelProperty(value = "0隐藏，1展示")
    private Integer status = 1;

    @ApiModelProperty(value = "创建时间")
    @CreationTimestamp
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @ApiModelProperty(value = "更新时间")
    @UpdateTimestamp
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
}
