package com.icefrog.loadbalance.api;

import com.icefrog.loadbalance.provider.Invocation;
import com.icefrog.loadbalance.provider.Invoker;
import com.icefrog.loadbalance.provider.Result;

public class Model implements Invoker {

    private int weight;

    private String name;

    public Model(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public int getPort() {
        return 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public <T extends Result> T invoke(Invocation invocation) {
        System.out.println("invoke success. name: " + this.getName());
        return null;
    }
}
