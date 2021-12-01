package com.copysun.mybatisservice.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.copysun.mybatisservice.entity.Student;
import com.copysun.mybatisservice.mapper.DemoMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author copysun
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Student> {

	@Transactional(rollbackFor = Exception.class)
	public void add() {
//		try {

		Student s1 = new Student();
		LambdaQueryWrapper<Student> stu=new LambdaQueryWrapper<>();
		stu.ge(Student::getId,"11");
		stu.eq(Student::getAge,30);
		this.baseMapper.update(s1,stu);











			s1.setName("11");
			s1.setAge(11);
			this.save(s1);
			int i = 1 / 0;
//		}catch (Exception e){
////			e.printStackTrace();
////			System.out.println(e.getMessage());
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//		}

	}

	public void updateStudent(){
		
		
		

		((DemoServiceImpl) AopContext.currentProxy()).add();
//		this.add();
//		Student s1 = new Student();
//		s1.setId("c004ffeecf81bcd07b0d770e296adfb2");
//		s1.setName("22");
//		s1.setAge(22);
//		this.updateById(s1);
	}


}
