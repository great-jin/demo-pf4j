package cn.great.service;

import cn.great.config.Elastic6Client;
import cn.great.entity.ElasticEntity;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.client.GetAliasesResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.cluster.metadata.AliasMetaData;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class V6IndexService {

    public static Set<String> listIndex(ElasticEntity entity) {
        try (RestHighLevelClient client = Elastic6Client.buildClient(entity)) {
            GetAliasesRequest request = new GetAliasesRequest();
            GetAliasesResponse getAliasesResponse = client.indices()
                    .getAlias(request, RequestOptions.DEFAULT);
            Map<String, Set<AliasMetaData>> map = getAliasesResponse.getAliases();
            return map.keySet();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
