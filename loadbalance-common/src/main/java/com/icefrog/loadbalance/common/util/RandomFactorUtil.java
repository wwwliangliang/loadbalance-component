package com.icefrog.loadbalance.common.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomFactorUtil {

    private RandomFactorUtil(){}

    public static int random(int scope) {
        return ThreadLocalRandom.current().nextInt(scope);
    }
}
