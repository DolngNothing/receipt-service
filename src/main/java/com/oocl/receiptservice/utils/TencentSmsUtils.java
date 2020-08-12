package com.oocl.receiptservice.utils;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import java.io.IOException;

public class TencentSmsUtils {

    public static final int APPID = 1400410684;
    public static final String APP_KEY = "84a8f465c5d4237440fe55d04587670d";
    public static final int TEMPLATE_ID = 688748;
    public static final String SMS_SIGN = "寻找世界了解精彩";
    public static final String NATION_CODE = "86";
    public static final String EXTEND = "";
    public static final String EXT = "";

    public static void sendSms(String phoneNumber, String username, String parkingName, String parkingOrderId) {

        String[] templateParams = {username, parkingName, parkingOrderId};
        try {
            SmsSingleSender smsSingleSender = new SmsSingleSender(APPID, APP_KEY);
            SmsSingleSenderResult smsSingleSenderResult = smsSingleSender.sendWithParam(NATION_CODE, phoneNumber,
                    TEMPLATE_ID, templateParams, SMS_SIGN, EXTEND, EXT);
            System.out.println(smsSingleSenderResult);
        } catch (HTTPException | JSONException | IOException ignored) {

        }
    }
}