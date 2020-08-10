package com.creatureox.etcd.demo;

import io.etcd.jetcd.ByteSequence;
import io.etcd.jetcd.Client;
import io.etcd.jetcd.KV;
import io.etcd.jetcd.kv.GetResponse;

import java.nio.charset.Charset;
import java.util.concurrent.CompletableFuture;

/**
 * @author CreatureOX
 * date: 2020/8/10
 * description:
 */
public class SimpleDemo {

    public static void main(String[] args) throws Exception{
        Client client = Client.builder().endpoints("http://localhost:2379").build();
        KV kvClient = client.getKVClient();

        ByteSequence key = ByteSequence.from("test_key", Charset.forName("UTF-8"));
        ByteSequence value = ByteSequence.from("test_value",Charset.forName("UTF-8"));

//        kvClient.put(key, value).get();

//        CompletableFuture<GetResponse> getFuture = kvClient.get(key);
//        GetResponse response = getFuture.get();
//
//        kvClient.delete(key).get();
    }

}
