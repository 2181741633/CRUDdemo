import com.s.dao.DeptMapper;
import com.s.dao.UserMapper;
import com.s.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/applicationContext.xml"})
public class CRUDtest {

    @Autowired
    DeptMapper deptMapper;
    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {
        ApplicationContext app = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        DeptMapper deptMapper = app.getBean(DeptMapper.class);
        /*deptMapper.insertSelective(new Dept(null, "开发部"));
        deptMapper.insertSelective(new Dept(null, "测试部"));
        System.out.println(deptMapper);*/

        UserMapper userbaen = app.getBean(UserMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5);
            userbaen.insertSelective(new User(null, uid, uid + "@qq.com", "女", 2));
        }
        System.out.println(userbaen);
    }
}
