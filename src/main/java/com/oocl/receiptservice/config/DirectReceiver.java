package com.oocl.receiptservice.config;

import com.oocl.receiptservice.utils.TencentSmsUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = DirectRabbitConfig.QUEUE_NAME)
public class DirectReceiver {
    @RabbitHandler
    public void process(Map<String,String> message) {
        String phoneNumber = message.get("phoneNumber");
        String username = message.get("username");
        String parkingName = message.get("parkingName");
        String parkingOrderId = message.get("parkingOrderId");
        TencentSmsUtils.sendSms(phoneNumber,username,parkingName,parkingOrderId);
    }

}