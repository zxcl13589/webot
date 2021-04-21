package person.ys.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import person.ys.properties.WeBotProperties;
import person.ys.service.WeBotService;

/**
 * @Author: xys
 * @Date: 2021/4/20 17:27
 */
@Configuration
@ConditionalOnClass(WeBotService.class)
@EnableConfigurationProperties(WeBotProperties.class)
public class WeBotConfigurationUtils {

    @Bean
    @ConditionalOnMissingBean(WeBotService.class)
    public WeBotService weBotService(WeBotProperties weBotProperties){
        return new WeBotService(weBotProperties);
    }
}
