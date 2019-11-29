package com.icefrog.loadbalance.provider.loadblance;

import com.icefrog.loadbalance.common.util.RandomFactorUtil;
import com.icefrog.loadbalance.provider.AbstractLoadBalancer;
import com.icefrog.loadbalance.provider.Invoker;
import com.icefrog.loadbalance.provider.LoadBalancer;

import java.util.List;

public class WiLoadBalancer extends AbstractLoadBalancer implements LoadBalancer {

    @Override
    protected <T extends Invoker> T doSelect(List<T> invokers) {

        // Number of invokers
        int length = invokers.size();
        // Every invoker has the same weight?
        boolean sameWeight = true;
        // the weight of every invokers
        int[] weights = new int[length];
        // the first invoker's weight
        int firstWeight = invokers.get(0).getWeight();
        weights[0] = firstWeight;
        // The sum of weights
        int totalWeight = firstWeight;
        for (int i = 1; i < length; i++) {
            int weight = invokers.get(i).getWeight();
            // save for later use
            weights[i] = weight;
            // Sum
            totalWeight += weight;
            if (sameWeight && weight != firstWeight) {
                sameWeight = false;
            }
        }
        if (totalWeight > 0 && !sameWeight) {
            // If (not every invoker has the same weight & at least one invoker's weight>0), select randomly based on totalWeight.
            int offset = RandomFactorUtil.random(totalWeight);
            // Return a invoker based on the random value.
            for (int i = 0; i < length; i++) {
                offset -= weights[i];
                if (offset < 0) {
                    return invokers.get(i);
                }
            }
        }
        // If all invokers have the same weight value or totalWeight=0, return evenly.
        return invokers.get(RandomFactorUtil.random(length));
    }
}
