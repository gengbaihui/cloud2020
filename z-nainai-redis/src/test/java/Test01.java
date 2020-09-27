import com.atguigu.springcloud.entities.Payment;
import com.nainai.redis.NaiNaiRedisMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * 不写启动类 不可以启动这个单元测试，因为StringRedisTemplate 无法注入
 * 写了启动类也不能单元测试：因为启动类和测试类不在一个包，所以(classes = NaiNaiRedisMain.class) 
 * 需要指定启动类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = NaiNaiRedisMain.class)
public class Test01 {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testStringSetKey() {
        stringRedisTemplate.opsForValue().set("yunai", "shuai");
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testStringSetKey02() {
        redisTemplate.opsForValue().set("yunai", "shuai");
    }

    @Test
    public void testStringSetKeyUserCache() {
//        UserCacheObject object = new UserCacheObject()
//                .setId(1)
//                .setName("芋道源码")
//                .setGender(1); // 男
        Payment object = new Payment().setId(1l)
                .setSerial("测试");
        String key = String.format("user:%d", object.getId());
        redisTemplate.opsForValue().set(key, object);
    }
    
    @Test
    public void testGetUserCache(){
        String key = String.format("user:%d", 1);
        Object value = redisTemplate.opsForValue().get(key);
        System.out.println(value);
    }
}