package cn.great.service;

import cn.great.api.DatasourceApi;
import cn.great.loader.MyPluginManager;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class PluginService {

    public static void loadPlugin(String plugin, String location, Map<String, Object> params) {
        // Create manager
        ClassLoader parent = Thread.currentThread().getContextClassLoader();
        MyPluginManager pluginManager = new MyPluginManager(parent);
        // Load plugin from local
        pluginManager.loadPlugin(Paths.get(location));
        // Start plugin with dependency
        pluginManager.startPlugin(plugin);
        // Get defined realize from plugin
        List<DatasourceApi> extensionList = pluginManager.getExtensions(DatasourceApi.class);
        if (extensionList.isEmpty()) {
            System.out.println("Didn't find any plugin.");
        } else {
            for (DatasourceApi dsApi : extensionList) {
                Object result = dsApi.getDatasourceInfo(params);
                System.out.println("PF4J result: " + result);
            }
        }
        // Stop and unload plugin
        pluginManager.stopPlugin(plugin);
        pluginManager.unloadPlugin(plugin);
    }
}
