package cn.great.plugin;

import cn.great.api.DatasourceApi;
import cn.great.entity.ElasticEntity;
import cn.great.service.V7IndexService;
import org.pf4j.Extension;

import java.util.Map;

@Extension
public class Elastic7Plugin implements DatasourceApi {

    @Override
    public Object getDatasourceInfo(Map<String, Object> params) {
        ElasticEntity elasticEntity;
        boolean enableAuth = (boolean) params.get("enableAuth");
        if (enableAuth) {
            elasticEntity = ElasticEntity.builder()
                    .host((String) params.get("host"))
                    .port((Integer) params.get("port"))
                    .enableAuth(true)
                    .username((String) params.get("username"))
                    .password((String) params.get("password"))
                    .build();
        } else {
            elasticEntity = ElasticEntity.builder()
                    .host((String) params.get("host"))
                    .port((Integer) params.get("port"))
                    .enableAuth(false)
                    .build();
        }
        return V7IndexService.listIndex(elasticEntity);
    }
}
