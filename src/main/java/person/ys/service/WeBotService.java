package person.ys.service;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

    public void sendMarkDown(String message,String applicationName,String profile) {
        Map body = new HashMap(){{
            put("msgtype", "markdown");
            put("markdown",new HashMap(){{
                put("content","<font color=\"red\">" + applicationName + "</font>应用<font color=\"info\">" + profile + "</font>异常。\n" +">" + message);
            }});
        }};
        HttpRequest.post(properties.getWebHookUrl())
                .body(JSONUtil.toJsonStr(body))
                .execute();
    }
}
