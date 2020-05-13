package com.nablarch.example.app.redisstore;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.RedisClient;
import io.lettuce.core.TimeoutOptions;
import nablarch.integration.redisstore.lettuce.LettuceMasterReplicaRedisClient;

import java.time.Duration;

public class MyMasterSlaveRedisClient extends LettuceMasterReplicaRedisClient {

    @Override
    protected RedisClient createClient() {
        System.out.println("$$$$$$$$$$$$$ MyMasterSlaveRedisClient $$$$$$$$$$$$$$$");
        RedisClient client = RedisClient.create();

        TimeoutOptions timeoutOptions = TimeoutOptions.builder()
                .fixedTimeout(Duration.ofSeconds(30))
                .build();

        ClientOptions clientOptions = ClientOptions.builder()
                .timeoutOptions(timeoutOptions)
                .build();

        client.setOptions(clientOptions);

        return client;
    }
}
