package cn.great.api;

import org.pf4j.ExtensionPoint;

import java.util.Map;

public interface DatasourceApi extends ExtensionPoint {

    Object getDatasourceInfo(Map<String, Object> params);

}
