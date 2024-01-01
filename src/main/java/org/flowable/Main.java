package org.flowable;

import org.flowable.engine.*;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProcessEngine processEngine = EngineManager.createEngine();

        Deployment deployment = DeploymentManager.getCreateDeployment(processEngine);

        Scanner scanner = new Scanner(System.in);
        Map<String, Object> variables = new HashMap<>();

        InstanceManager.createProcessInstance(deployment, scanner, processEngine, variables);

        ProcessManager.executeProcess(processEngine, scanner);
    }

    public record Deployment(RepositoryService repositoryService, org.flowable.engine.repository.Deployment deployment) {
    }
}