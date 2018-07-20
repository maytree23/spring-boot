package com.example.demo;


import com.example.demo.domain.entity.UserEntity;
import com.example.demo.domain.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class ServiceTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    // mapper test
    @Test
    public void mapperTest() {
        List<UserEntity> users = userMapper.getAll();
        Assert.assertEquals(1, users.size());
    }

    // redis test
    @Test
    public void redisTest() {
        Assert.assertEquals("value1", stringRedisTemplate.opsForHash().get("testkey", "field1"));
        stringRedisTemplate.opsForHash().put("testkey2", "field2", "value2");
        Assert.assertEquals("value2", stringRedisTemplate.opsForHash().get("testkey2", "field2"));
    }

//    @Test
//    public void testObj() throws Exception {
//        User user=new User("aa@126.com", "aa", "aa123456", "aa","123");
//        ValueOperations<String, User> operations=redisTemplate.opsForValue();
//        operations.set("com.neox", user);
//        operations.set("com.neo.f", user,1,TimeUnit.SECONDS);
//        Thread.sleep(1000);
//        //redisTemplate.delete("com.neo.f");
//        boolean exists=redisTemplate.hasKey("com.neo.f");
//        if(exists){
//            System.out.println("exists is true");
//        }else{
//            System.out.println("exists is false");
//        }
//        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
//    }


}
