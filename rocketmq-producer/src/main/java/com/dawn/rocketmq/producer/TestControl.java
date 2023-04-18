package com.dawn.rocketmq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试入口
 * @Author: lijinliang
 * @Date: 2020/6/28 17:02
 */
@RestController
public class TestControl {

    @Autowired
    private SendService sendService;

    @GetMapping("/test/{businessNo}")
    public String test(@PathVariable String businessNo) {
        String msg="hello";
        sendService.sendWithTags(msg,"tag1",businessNo);
        System.out.println("字符串消息发送成功=======》 简单的字符串消息");
        sendService.send(businessNo);
        System.out.println("不带标签的消息发送成功=======");
        test2();
        return "字符串消息发送成功!";
    }

    @GetMapping("/test2")
    public String test2() {
        TestDto dto=new TestDto();
        dto.setAge(111);
        dto.setName("小玲");
        sendService.sendObject(dto,"tag2");
        System.out.println("实体消息发送成功");
        return "实体消息发送成功！";
    }
}
