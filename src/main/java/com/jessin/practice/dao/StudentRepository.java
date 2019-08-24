package com.jessin.practice.dao;

import com.jessin.practice.model.Hello;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zexin.guo
 * @create 2018-11-06 下午5:29
 **/
@Component
public class StudentRepository {
//    @Autowired
//    private HiveTemplate hiveTemplate;

    @Resource
    private JdbcTemplate jdbcTemplate;

//    public void showTables() {
//        List<String> tables = hiveTemplate.query("show tables;");
//        System.out.println("tables size: " + tables.size());
//    }

    public List<Hello> getDataList() {
        List<Hello> helloList = jdbcTemplate.query("select * from ods_session_message_log", new RowMapper<Hello>() {
            public Hello mapRow(ResultSet rs, int rowNum) throws SQLException {
                Hello hello = new Hello();
                hello.setKey(rs.getString(1));
                hello.setValue(rs.getString(2));
                //hello.setBirthday(rs.getTimestamp(3));
                return hello;
            }
        });
        return helloList;
    }
}
