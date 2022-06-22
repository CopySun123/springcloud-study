package com.copysun.camunda.camunda.controller;

import com.alibaba.fastjson.JSONObject;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author copysun
 * @Date: Create in 17:39 2022/6/18
 * @Desc 流程启动类
 */
@RestController
public class CamundaStartController {

	/**
	 * 定义、部署
	 */
	@Resource
	private RepositoryService repositoryService;

	/**
	 * 启动
	 */
	@Resource
	private RuntimeService runtimeService;

	/**
	 * 任务
	 */
	@Resource
	private TaskService taskService;


	/**
	 * 部署流程（InputStream、ClasspathResource、ZipInputStream）
	 */
	@PostMapping("/deploy")
	public void deploy(@RequestBody Map<String,Object> param) {
		String name=param.get("name").toString();
		String resourceName=param.get("resourceName").toString();

		Deployment deploy = repositoryService.createDeployment()
				.name(name)
				//.addInputStream("ss", Files.newInputStream(Paths.get("11")))
				.addClasspathResource(resourceName)
				.deploy();
		System.out.println(deploy.getId()+":部署成功!");
	}

	/**
	 * 启动流程
	 * @param param
	 */
	@PostMapping("/startEvent")
	public void StartEvent(@RequestBody Map<String,Object> param){
		String instanceId=param.get("instanceId").toString();
		String businessKey=param.get("businessKey").toString();
		ProcessInstance processInstance = runtimeService.startProcessInstanceById(instanceId, businessKey);
		System.out.println(processInstance.getId()+":启动成功!");
	}


	/**
	 * 完成节点
	 * @param param
	 */
	@PostMapping("/tackComplete")
	public void taskComplete(@RequestBody Map<String,Object> param){
		String assignee=param.get("assignee").toString();
		String processInstanceId=param.get("processInstanceId").toString();

		Task task = taskService.createTaskQuery()
				.processInstanceId(processInstanceId)
				.taskAssignee(assignee)
				.singleResult();
		taskService.complete(task.getId(),param);
	}

	/**
	 * 查询流程定义信息
	 */
	@PostMapping("/proDefList")
	@ResponseBody
	public JSONObject processDefinitionQuery(@RequestBody Map<String,Object> param){
		JSONObject result=new JSONObject();
		List<ProcessDefinition> proDefList = repositoryService.createProcessDefinitionQuery()
				.orderByDeploymentTime().desc()
				.list();
		result.put("proDefList",proDefList);
		return result;
	}

	/**
	 * 查询所有部署流程
	 */
	@PostMapping("/proInsList")
	@ResponseBody
	public JSONObject processInstanceQuery(@RequestBody Map<String,Object> param){
        JSONObject result=new JSONObject();
		List<ProcessInstance> list = runtimeService.createProcessInstanceQuery()
				.orderByProcessInstanceId().desc()
				.list();
		result.put("priInsList",list);
		return result;
	}



}
