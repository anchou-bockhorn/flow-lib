package org.flowable;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;

import java.util.Map;
import java.util.Scanner;

public class InstanceManager {
    static void createProcessInstance(Main.Deployment deployment,
                                      Scanner scanner,
                                      ProcessEngine processEngine,
                                      Map<String, Object> variables) {

        ProcessDefinition processDefinition = deployment.repositoryService().createProcessDefinitionQuery()
                .deploymentId(deployment.deployment().getId())
                .singleResult();
        System.out.println("Found process definition : " + processDefinition.getName());

        System.out.println("Who are you?");
        String employee = scanner.nextLine();

        System.out.println("How many holidays do you want to request?");
        Integer nrOfHolidays = Integer.valueOf(scanner.nextLine());

        System.out.println("Why do you need them?");
        String description = scanner.nextLine();

        RuntimeService runtimeService = processEngine.getRuntimeService();

        variables.put("employee", employee);
        variables.put("nrOfHolidays", nrOfHolidays);
        variables.put("description", description);
        runtimeService.startProcessInstanceByKey("holidayRequest", variables);
    }
}