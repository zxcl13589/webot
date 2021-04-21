import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import person.ys.WeBotApplication;
import person.ys.service.WeBotService;

/**
 * @Author: xys
 * @Date: 2021/4/21 10:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WeBotApplication.class})
public class Test {
    @Autowired
    private WeBotService weBotService;

    @org.junit.Test
    public void testWeBot() {
//        weBotService.sendMarkDown("123","月森test","test");
    }
}
