package com.lh;

import com.lh.dao.MajorMapper;
import com.lh.pojo.Major;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.lh"})
@RestController
@MapperScan("com.lh.dao")
public class App 
{

    public static void main( String[] args )
    {

        SpringApplication.run(App.class,args);
    }
}
