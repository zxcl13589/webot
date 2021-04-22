package person.ys.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * @Author: xys
 * @Date: 2021/4/21 9:18
 */
@ConfigurationProperties(prefix = "wework.bot")
@Data
public class WeBotProperties {
    private List<Map<String,Config>> configMap;

    @Data
    public static class Config{
        private String botName;
        private String webHookUrl;
        private Boolean enable;
    }
}
