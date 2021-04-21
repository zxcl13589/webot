package person.ys.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: xys
 * @Date: 2021/4/21 9:18
 */
@ConfigurationProperties(prefix = "wework.bot")
@Data
public class WeBotProperties {

    private String webHookUrl;
}
