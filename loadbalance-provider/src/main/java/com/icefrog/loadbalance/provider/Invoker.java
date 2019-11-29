package com.icefrog.loadbalance.provider;

public interface Invoker {

    int getWeight();

    String getUrl();

    int getPort();

    String getName();

    <T extends Result> T invoke(Invocation invocation);
}
