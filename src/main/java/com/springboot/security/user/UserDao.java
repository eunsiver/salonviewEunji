package com.springboot.security.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



//로그인 user정보 DB에 저장
    public int insertAnUserOAuth(Map<String, String> user) {
        String sql = "insert into user"
                + "(user_id,nickname, gender, created_at, updated_at) "
                + "values(?, ?, ?, sysdate(), sysdate())";

        return jdbcTemplate.update(sql,
                user.get("user_id"),
                user.get("nickname"),
                user.get("gender")
        );

    }

}
