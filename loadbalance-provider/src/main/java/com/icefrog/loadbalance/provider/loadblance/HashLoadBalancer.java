package com.icefrog.loadbalance.provider.loadblance;

import com.icefrog.loadbalance.provider.AbstractLoadBalancer;
import com.icefrog.loadbalance.provider.Invoker;
import com.icefrog.loadbalance.provider.LoadBalancer;
import com.icefrog.loadbalance.provider.ProviderException;

import java.util.List;

public class HashLoadBalancer extends AbstractLoadBalancer implements LoadBalancer {

    @Override
    protected <T extends Invoker> T doSelect(List<T> invokers) {
        throw new ProviderException("HashLoadBalancer Unsupported exception!");
    }
}
