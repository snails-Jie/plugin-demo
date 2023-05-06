package org.example.plugin;

import org.example.spi.NacosServiceLoader;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HelloPluginManager {
    private static final HelloPluginManager INSTANCE = new HelloPluginManager();

    private final Map<String,HelloPluginService> helloServiceMap = new HashMap<>();

    private HelloPluginManager(){
        initHelloService();
    }

    private void initHelloService(){
       Collection<HelloPluginService> helloPluginServices =  NacosServiceLoader.load(HelloPluginService.class);
       for(HelloPluginService each:helloPluginServices){
           helloServiceMap.put(each.getHelloServiceName(),each);
       }
    }

    public static HelloPluginManager getInstance(){
        return INSTANCE;
    }

    public Optional<HelloPluginService> findHelloServiceSpiImpl(String helloServiceName){
        return Optional.ofNullable(helloServiceMap.get(helloServiceName));
    }


}
