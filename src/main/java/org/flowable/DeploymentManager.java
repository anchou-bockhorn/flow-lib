package org.flowable;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;

public class DeploymentManager {
    static Main.Deployment getCreateDeployment(ProcessEngine processEngine) {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("holiday-request.bpmn20.xml")
                .deploy();
        return new Main.Deployment(repositoryService, deployment);
    }
}