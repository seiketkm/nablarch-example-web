package com.nablarch.example.app.redisstore;

import io.lettuce.core.RedisURI;
import io.lettuce.core.cluster.ClusterClientOptions;
import io.lettuce.core.cluster.ClusterTopologyRefreshOptions;
import io.lettuce.core.cluster.RedisClusterClient;
import nablarch.integration.redisstore.lettuce.LettuceClusterRedisClient;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class MyClusterRedisClient extends LettuceClusterRedisClient {

    @Override
    protected RedisClusterClient createClient() {
        List<RedisURI> redisUriList = uriList.stream().map(RedisURI::create).collect(Collectors.toList());
        RedisClusterClient client = RedisClusterClient.create(redisUriList);

        ClusterTopologyRefreshOptions clusterTopologyRefreshOptions = ClusterTopologyRefreshOptions.builder()
                .enableAllAdaptiveRefreshTriggers()
                .enablePeriodicRefresh(Duration.ofSeconds(10))
                .build();

        ClusterClientOptions clusterClientOptions = ClusterClientOptions.builder()
                .topologyRefreshOptions(clusterTopologyRefreshOptions)
                .build();

        client.setOptions(clusterClientOptions);

        return client;
    }
}
