package com.example.lishui.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by jesse on 2020/11/15 下午4:42
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    //    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    //密码加密，不然用spring data rest密码不会加密
    public void setPassword(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }
    
    private String tel;

    @Column(nullable = false)
    private String role;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp createAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp updateAt;

//    @Column(columnDefinition = "TIMESTAMP")
    private Timestamp lastLoginDateTime;
//    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//    //级联保存、更新、删除、刷新;延迟加载。当删除用户，会级联删除该用户的所有文章
//    //拥有mappedBy注解的实体类为关系被维护端
//    //mappedBy="author"中的author是Article中的author属性
//    private List<Article> articleList;//文章列表
}
