package com.icefrog.loadbalance.provider;

import com.icefrog.loadbalance.common.util.CollectionUtils;

import java.util.List;

public abstract class AbstractLoadBalancer implements LoadBalancer {

    @Override
    public <T extends Invoker> T select(List<T> invokers) {
        if(CollectionUtils.isEmpty(invokers)) {
            return null;
        }
        if(invokers.size() == 1) {
            return invokers.get(0);
        }
        return doSelect(invokers);
    }

    protected abstract <T extends Invoker> T doSelect(List<T> invokers);

    protected int getWeight(Invoker invoker) {
        return invoker.getWeight();
    }
}
