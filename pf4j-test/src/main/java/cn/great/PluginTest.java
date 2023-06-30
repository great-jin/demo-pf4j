package cn.great;

import cn.great.service.PluginService;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PluginTest {

    @Test
    public void pluginDemo() {
        String plugin = "demo-plugin";
        String location = "E:\\Temporary\\plugin\\plugin-demo-1.0-SNAPSHOT-all.jar";
        Map<String, Object> params = new HashMap<>();
        params.put("msg", "Hello World!");
        PluginService.loadPlugin(plugin, location, params);
    }

    @Test
    public void mixDemo() {
        String plugin = "demo-plugin";
        String location1 = "E:\\Temporary\\plugin\\plugin-demo-1.0-SNAPSHOT-all.jar";
        Map<String, Object> params = new HashMap<>();
        params.put("msg", "Hello World!");
        PluginService.loadPlugin(plugin, location1, params);
        String location2 = "E:\\Temporary\\plugin\\plugin-demo-2.0-SNAPSHOT-all.jar";
        PluginService.loadPlugin(plugin, location2, params);
    }

    @Test
    public void elastic6Demo() {
        String plugin = "elastic6-plugin";
        String location = "E:\\Temporary\\plugin\\plugin-es6-1.0-SNAPSHOT-all.jar";
        Map<String, Object> params = new HashMap<>();
        params.put("host", "127.0.0.1");
        params.put("port", 9200);
        params.put("enableAuth", false);
        PluginService.loadPlugin(plugin, location, params);
    }

    @Test
    public void elastic7Demo() {
        String plugin = "elastic7-plugin";
        String location = "E:\\Temporary\\plugin\\plugin-es7-1.0-SNAPSHOT-all.jar";
        Map<String, Object> params = new HashMap<>();
        params.put("host", "127.0.0.1");
        params.put("port", 9200);
        params.put("enableAuth", true);
        params.put("username", "elastic");
        params.put("password", "elastic");
        PluginService.loadPlugin(plugin, location, params);
    }
}
