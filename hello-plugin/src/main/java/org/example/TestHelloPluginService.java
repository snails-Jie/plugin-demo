package org.example;

import org.example.plugin.HelloPluginService;

public class TestHelloPluginService implements HelloPluginService {
    public String helloContent() {
        return "Love you";
    }

    public String getHelloServiceName() {
        return "test";
    }
}
