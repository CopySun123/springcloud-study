package com.copysun.camunda.camunda.controller;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CopySun
 * @date 2020/12/10 17:48
 * @Description
 */
@RestController
public class StudentController {
    @Resource
    private RepositoryService repositoryService;

    @Resource
    private RuntimeService runtimeService;

    @Resource
    private TaskService taskService;

    @Resource
    private HistoryService historyService;

    private static final String PROCESS_KEY="test_process";

    @PostMapping("startEvent/{userId}")
    public void StartEventDemo(@PathVariable String userId){
        Map<String,Object> param=new HashMap(16);
        param.put("sponsor",userId);

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PROCESS_KEY);
        runtimeService.setVariableLocal(processInstance.getRootProcessInstanceId(),"sponsor",userId);
        System.out.println(processInstance.getProcessDefinitionId());
    }

    @PostMapping("deploy")
    public void deploy(){
        Deployment deploy = repositoryService.createDeployment().name("测试工作流")
                .addClasspathResource("test.bpmn").deploy();
        System.out.println(deploy.getId());
    }

    /**
     *  查询我发起的流程
     */
    @PostMapping("processQuery/{sponsorId}")
    public void processQuery(@PathVariable String sponsorId){
//        List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery()
//                .variableValueEquals("sponsor",sponsorId)
//                .list();
//        System.out.println(processInstances);

        List<HistoricProcessInstance> historicProcessInstances = historyService.createHistoricProcessInstanceQuery()
                .processDefinitionKeyNotIn(Arrays.asList("11"))
                .variableValueEquals("sponsor", sponsorId)
                .list();

        historicProcessInstances.forEach(historicProcessInstance -> {
            //查询每个流程的流程名称、任务、以及流程图片
            System.out.println(historicProcessInstance.getId());
            System.out.println(historicProcessInstance.getProcessDefinitionId());
        });
    }
    /**
     * 查询任务(发起人)
     */
    @PostMapping("taskQuery/{userId}")
    public void taskQuery(@PathVariable String userId){
        List<Task> tasks = taskService.createTaskQuery()
//                .processDefinitionKey(PROCESS_KEY)
                .taskCandidateUser(userId)
                .list();
        tasks.forEach(task -> {
            System.out.println(task.getId());
        });

    }

    /**
     * 完成任务
     */
    @PostMapping("taskComplete/{userId}")
    public void taskComplete(@PathVariable String userId){
        Map<String,Object> params=new HashMap<>(16);
        params.put("check",false);
        Task task = taskService.createTaskQuery()
                .taskAssignee(userId)
//                .taskCandidateUser(userId)
                .singleResult();

        taskService.complete(task.getId(),params);
    }


    /**
     * 候选人拾取任务
     */
    @PostMapping("claimTask/{userId}")
    public void claimTask(@PathVariable String userId){
        //查询候选人的代办任务
        Task task = taskService.createTaskQuery()
                    .taskCandidateUser(userId)
                    .singleResult();
    }

}
