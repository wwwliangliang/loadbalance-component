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

package com.icefrog.loadbalance.provider;

import java.util.Map;

public interface Invocation {

    void addAttachments(Map<String, String> attachments);

    void setAttachment(String key, String value);

    void setAttachmentIfAbsent(String key, String value);

    String getAttachment(String key);

    String getAttachment(String key, String defaultValue);


}
