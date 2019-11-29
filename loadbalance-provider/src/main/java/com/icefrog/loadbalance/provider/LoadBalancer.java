package com.icefrog.loadbalance.provider;

import java.util.List;

public interface LoadBalancer {

    <T extends Invoker> T select(List<T> invokers);

}
