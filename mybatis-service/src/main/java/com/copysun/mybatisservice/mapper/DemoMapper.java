package com.copysun.mybatisservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.copysun.mybatisservice.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hspcadmin
 */
@Mapper
public interface DemoMapper extends BaseMapper<Student> {

	List<Student> getStudents();

	List<String> getId();
}