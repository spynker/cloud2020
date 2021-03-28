package com.yangbo.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
