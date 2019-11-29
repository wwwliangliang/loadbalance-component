package com.icefrog.loadbalance.provider;

import com.icefrog.loadbalance.common.util.RandomFactorUtil;
import com.icefrog.loadbalance.common.util.StringUtils;
import com.icefrog.loadbalance.provider.loadblance.HashLoadBalancer;
import com.icefrog.loadbalance.provider.loadblance.RandomLoadBalancer;
import com.icefrog.loadbalance.provider.loadblance.WiLoadBalancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LoadBalancerFactory {

    private static final Logger logger = LoggerFactory.getLogger(LoadBalancerFactory.class);
    private LoadBalancerFactory(){}

    /**
     * Stores the class data for all current load balancer providers.
     * and all acquired examples will use this as a build source
     */
    private final static Map<String, Class> LOAD_BALANCER_INSTANCE = new LinkedHashMap<>(3);

    /**
     * Stores a collection of all instance names, built from the map (based on keySet).
     * As a random element to obtain a random load balancing instance
     */
    private final static List<String> LOAD_BALANCER_NAMES = new ArrayList<>(LOAD_BALANCER_INSTANCE.size());

    /**
     * Init LOAD_BALANCER_INSTANCE and LOAD_BALANCER_NAMES resource.
     */
    static {
        LOAD_BALANCER_INSTANCE.put(LoadBalanceProviderEnum.RANDOM_LOAD_BALANCER.name(), RandomLoadBalancer.class);
        LOAD_BALANCER_INSTANCE.put(LoadBalanceProviderEnum.WI_LOAD_BALANCER.name(), WiLoadBalancer.class);
        LOAD_BALANCER_INSTANCE.put(LoadBalanceProviderEnum.HASH_LOAD_BALANCER.name(), HashLoadBalancer.class);

        LOAD_BALANCER_NAMES.addAll(LOAD_BALANCER_INSTANCE.keySet());
    }

    /***
     * Get an instance by random, and each call returns a brand new instance
     * @return LoadBalancer
     */
    public static LoadBalancer getInstance() {
        int randomIdx = RandomFactorUtil.random(LOAD_BALANCER_NAMES.size());
        String randomInstName = LOAD_BALANCER_NAMES.get(randomIdx);

        Class instCls = LOAD_BALANCER_INSTANCE.get(randomInstName);
        return _getInstance(instCls);
    }

    /***
     * Get an instance by provider name, and each call returns a brand new instance.
     * if the parameter is empty, an exception is thrown with ProviderException
     * @return LoadBalancer
     */
    public static LoadBalancer getInstance(String providerName) {
        if(StringUtils.isBlank(providerName)) {
            throw new ProviderException("LoadBalancerFactory#getInstance(String) provider name can not be empty!");
        }

        Class instCls = LOAD_BALANCER_INSTANCE.get(providerName.trim().toUpperCase());
        return _getInstance(instCls);
    }

    /***
     * Get an instance by provider type, and each call returns a brand new instance
     * if the parameter is empty, an exception is thrown with ProviderException
     * @return LoadBalancer
     */
    public static LoadBalancer getInstance(LoadBalanceProviderEnum providerType) {
        if(providerType == null) {
            throw new ProviderException("LoadBalancerFactory#getInstance(LoadBalanceProviderEnum) provider type can not be null!");
        }
        Class instCls = LOAD_BALANCER_INSTANCE.get(providerType.name());
        return _getInstance(instCls);
    }

    /**
     * Build a instance from the Class.If build an exception, return null
     * @param cls Class
     * @return LoadBalancer instance
     */
    private static LoadBalancer _getInstance(Class cls) {
        try {
            Object o = cls.newInstance();
            return (LoadBalancer) o;
        } catch (Exception e) {
            logger.error("init load balance failed! can not be new instance.", e);
        }
        return null;
    }
}
