/***
 * Copyright 2019 icefrog
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
