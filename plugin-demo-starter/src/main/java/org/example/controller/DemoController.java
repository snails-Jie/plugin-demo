package org.example.controller;

import org.example.plugin.HelloPluginManager;
import org.example.plugin.HelloPluginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/hello")
    public String hello(String name,String helloServiceName){
        Optional<HelloPluginService> helloPluginService =  HelloPluginManager.getInstance().findHelloServiceSpiImpl(helloServiceName);
        if(helloPluginService.isPresent()){
            String content = helloPluginService.get().helloContent();
            return "hello "+name+", "+content;
        }
        return "hello "+name;
    }
}
