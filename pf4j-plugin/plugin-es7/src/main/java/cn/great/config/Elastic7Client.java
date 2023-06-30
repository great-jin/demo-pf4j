package cn.great.config;

import cn.great.entity.ElasticEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

public class Elastic7Client {

    public static RestHighLevelClient buildClient(ElasticEntity elasticEntity) {
        // 构建连接对象
        String host = elasticEntity.getHost();
        int port = elasticEntity.getPort();
        RestClientBuilder builder = RestClient.builder(new HttpHost(host, port))
                // 配置连接超时
                .setRequestConfigCallback(requestConfigBuilder ->
                        requestConfigBuilder.setConnectTimeout(3000)
                                .setSocketTimeout(5000)
                                .setConnectionRequestTimeout(500))
                // 异步连接数配置
                .setHttpClientConfigCallback(httpClientBuilder -> {
                    httpClientBuilder.disableAuthCaching();
                    httpClientBuilder.setMaxConnTotal(100);
                    httpClientBuilder.setMaxConnPerRoute(100);
                    if (elasticEntity.isEnableAuth()) {
                        // 用户认证
                        String username = elasticEntity.getUsername();
                        String password = elasticEntity.getPassword();
                        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
                        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));
                        return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                    } else {
                        return httpClientBuilder;
                    }
                });
        return new RestHighLevelClient(builder);
    }
}
