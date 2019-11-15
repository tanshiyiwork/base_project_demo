package com.github.controller;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    /**
     * 测试方法
     *
     * @param who 测试参数
     * @return {@link Dict}
     */
    @GetMapping("/test")
    public Dict test(String who) {
        log.error("sout log is error");
        return Dict.create().set("who", StrUtil.isBlank(who) ? "me" : who);
    }
}
