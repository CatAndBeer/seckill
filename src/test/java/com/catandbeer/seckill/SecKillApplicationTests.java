package com.catandbeer.seckill;

import com.catandbeer.seckill.utils.MD5Util;
import com.catandbeer.seckill.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

@SpringBootTest
class SecKillApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    void testMd5() {
        System.out.println(MD5Util.md5("123456"));
    }

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
        redisTemplate.opsForValue().set("myValue", "world");
        String myValue = (String) redisTemplate.opsForValue().get("myValue");
        System.out.println(myValue);
    }

    @Test
    void testRedisUtil() {
        redisUtil.deleteAll();
        redisUtil.set("test", "测试中文");
        String test = (String) redisUtil.get("test");
        System.out.println(test);
        redisUtil.set("test1", "test English");
        System.out.println(redisUtil.get("test1"));
    }

}
