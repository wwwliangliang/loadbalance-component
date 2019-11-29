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
