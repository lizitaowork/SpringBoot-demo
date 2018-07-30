package com.example.springbootwebsocket.controller;

import com.example.springbootwebsocket.service.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zitao.li on 2018/7/27.
 */
@Controller
public class WebSockController {
    @RequestMapping(value="/pushVideoListToWeb",method=RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public Map<String,Object> pushVideoListToWeb(@RequestBody Map<String,Object> param) {
        Map<String,Object> result =new HashMap<String,Object>();

        try {
            WebSocketServer.sendInfo("有新客户呼入,sltAccountId:"+param.get("sltAccountId"));
            result.put("operationResult", true);
        }catch (IOException e) {
            result.put("operationResult", true);
        }
        return result;
    }

}
