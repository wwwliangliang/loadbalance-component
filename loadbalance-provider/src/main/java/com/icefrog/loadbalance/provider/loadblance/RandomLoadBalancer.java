package com.icefrog.loadbalance.provider.loadblance;

import com.icefrog.loadbalance.common.util.RandomFactorUtil;
import com.icefrog.loadbalance.provider.AbstractLoadBalancer;
import com.icefrog.loadbalance.provider.Invoker;
import com.icefrog.loadbalance.provider.LoadBalancer;

import java.util.List;

public class RandomLoadBalancer extends AbstractLoadBalancer implements LoadBalancer {

    @Override
    protected <T extends Invoker> T doSelect(List<T> invokers) {
        return invokers.get(RandomFactorUtil.random(invokers.size()));
    }
}
