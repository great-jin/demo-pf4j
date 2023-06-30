package cn.great.test;

import cn.great.plugin.Elastic6Plugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ElasticTest {

    public static void main(String[] args) {
        Elastic6Plugin plugin = new Elastic6Plugin();
        Map<String, Object> params = new HashMap<>();
        params.put("host", "127.0.0.1");
        params.put("port", 9200);
        params.put("enableAuth", false);
        Set<String> index = (Set<String>) plugin.getDatasourceInfo(params);
        System.out.println(index);
    }
}
