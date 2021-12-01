package com.copysun.mybatisservice.controller;

import com.copysun.mybatisservice.mapper.DemoMapper;
import com.copysun.mybatisservice.service.DemoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author hspcadmin
 */
@RestController
public class DemoController {

    private Logger log= LoggerFactory.getLogger(DemoController.class);

    @Resource
    private DemoServiceImpl demoService;
    @Resource
    private DemoMapper demoMapper;

    @RequestMapping(method = RequestMethod.POST,path = "/addStudent")
    public void addStudent(){
        log.info("添加学生");
        demoService.add();
    }

    @RequestMapping(method = RequestMethod.POST,path = "/updateStudent")
    public void updateStudent(){
        log.info("修改学生");
        demoService.updateStudent();
    }

    @RequestMapping(method = RequestMethod.POST,path = "/addList")
    public void updateStudent(@RequestBody List<Map<String,Object>> list){
        System.out.println(list);
        log.info("修改学生");
//        demoService.updateStudent();
    }
}
