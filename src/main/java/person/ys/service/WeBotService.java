package person.ys.service;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import person.ys.properties.WeBotProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xys
 * @Date: 2021/4/21 9:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeBotService {

    private WeBotProperties properties;

    public void sendMessage(String botName,String webHookUrl,String message) {
        Map body = new HashMap(){{
            put("msgtype", "markdown");
            put("markdown",new HashMap(){{
                put("content","<font color=\"red\">"+botName+"通知您</font>：\n" +">" + message);
            }});
        }};

        HttpRequest.post(webHookUrl)
                .body(JSONUtil.toJsonStr(body))
                .execute();
    }

    public void sendByBotId(String key,String message) {
        properties.getConfigMap().forEach(configMap -> {
            WeBotProperties.Config config = configMap.get(key);
            if(config != null  && config.getEnable()){
                sendMessage(config.getBotName(),config.getWebHookUrl(),message);
            }
        });
    }

    public void sendAll(String message) {
        properties.getConfigMap().forEach(configMap -> {
            configMap.values().forEach(config -> {
                if(config != null  && config.getEnable()){
                    sendMessage(config.getBotName(),config.getWebHookUrl(),message);
                }
            });
        });
    }
}
