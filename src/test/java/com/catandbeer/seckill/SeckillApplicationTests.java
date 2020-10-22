package com.catandbeer.seckill;

import com.catandbeer.seckill.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

@SpringBootTest
class SeckillApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    void testJedis() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("root");
        jedis.flushDB();
        jedis.set("test", "hello");
        String test = jedis.get("test");
        System.out.println(test);
    }

    @Test
    void redisTemplate() {
        redisTemplate.opsForValue().set("myvalue", "world");
        String myvalue = (String) redisTemplate.opsForValue().get("myvalue");
        System.out.println(myvalue);
    }
    @Test
    void testRedisUtil(){
        redisUtil.deleteAll();
        redisUtil.set("test","tt");
        String test = (String) redisUtil.get("test");
        System.out.println(test);
    }

}
