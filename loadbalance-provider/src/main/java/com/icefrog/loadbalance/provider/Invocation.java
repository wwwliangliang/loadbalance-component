package com.icefrog.loadbalance.provider;

import java.util.Map;

public interface Invocation {

    void addAttachments(Map<String, String> attachments);

    void setAttachment(String key, String value);

    void setAttachmentIfAbsent(String key, String value);

    String getAttachment(String key);

    String getAttachment(String key, String defaultValue);


}
