import com.github.pagehelper.PageInfo;
import com.s.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:config/applicationContext.xml", "classpath:config/springmvc.xml"})
public class PageTest {

    @Autowired
    WebApplicationContext context;
    MockMvc mockMvc;

    @Before
    public void intit() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test() {
        try {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/page").param("pageno", "2")).andReturn();
            MockHttpServletRequest mockHttpServletRequest = result.getRequest();
            PageInfo pageInfo = (PageInfo) mockHttpServletRequest.getAttribute("pageinfo");
            System.out.println("当前页数：" + pageInfo.getPageNum());
            System.out.println("总数：" + pageInfo.getTotal());
            System.out.println("页数：" + pageInfo.getPages());
            List<User> list = pageInfo.getList();
            for (User user : list) {
                System.out.println(user.getdId()+":"+user.getuName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
