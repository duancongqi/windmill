package com.lg.jump;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @接口名称：JumpController
 * @作者: 段大神经
 * @创建时间: 2019/2/23 22:37
 * @说明: 只做各请求跳转使用类
 */
@Controller
public class JumpController {
    @GetMapping("/")
    public String test(){
        return "/index";
    }
}
