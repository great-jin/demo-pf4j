package cn.great.plugin;

import cn.great.api.DatasourceApi;
import org.pf4j.Extension;

import java.util.Map;

@Extension
public class DemoPlugin implements DatasourceApi {

    @Override
    public Object getDatasourceInfo(Map<String, Object> params) {
        System.out.println("Active demo plugin.");
        return params;
    }
}
