package com.jessin.practice;

import com.alibaba.fastjson.JSON;
import com.jessin.practice.dao.StudentRepository;
import com.jessin.practice.model.Hello;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author zexin.guo
 * @create 2018-11-06 下午5:30
 **/
@Slf4j
public class HiveMain {
    public static void main(String[] args) {
        try {
            ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/app.xml");
            if (ctx != null) {
                StudentRepository studentRepository = ctx.getBean(StudentRepository.class);
//                studentRepository.showTables();
                List<Hello> helloList = studentRepository.getDataList();
                System.out.println(JSON.toJSONString(helloList));
            }
        }
        catch (Exception ex) {
            log.error("HadoopMain encountered an error and ended.", ex);
        }
    }
}
