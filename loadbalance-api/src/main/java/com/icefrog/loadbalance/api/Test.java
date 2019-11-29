package com.icefrog.loadbalance.api;

import com.icefrog.loadbalance.provider.Invocation;
import com.icefrog.loadbalance.provider.LoadBalanceProviderEnum;
import com.icefrog.loadbalance.provider.LoadBalancer;
import com.icefrog.loadbalance.provider.LoadBalancerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        for(int i = 0; i < 10; i++) {
            run();
        }

    }

    private static void run() {

        List<Model> list = buildModelList();

        LoadBalancer instance = LoadBalancerFactory.getInstance(LoadBalanceProviderEnum.WI_LOAD_BALANCER);

        Model select = instance.select(list);

        Invocation invocation = new Invocation() {
            @Override
            public void addAttachments(Map<String, String> attachments) {

            }

            @Override
            public void setAttachment(String key, String value) {

            }

            @Override
            public void setAttachmentIfAbsent(String key, String value) {

            }

            @Override
            public String getAttachment(String key) {
                return null;
            }

            @Override
            public String getAttachment(String key, String defaultValue) {
                return null;
            }
        };

        select.invoke(invocation);
    }

    private static List<Model> buildModelList() {
        List<Model> list = new ArrayList<>();

        list.add(new Model(10, "weight:1000"));
        list.add(new Model(1, "weight:4"));
        list.add(new Model(3, "weight:2"));
        list.add(new Model(19, "weight:15"));

        return list;
    }

}
