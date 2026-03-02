package cn.neusoft.utills;

import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.tea.*;

public class CaptchaUtill {

    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                //AccessKey ID
                .setAccessKeyId(accessKeyId)
                //AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    public static SendSmsResponse send(String accessKeyId, String accessKeySecret, String SMS, String tels, String signName, String template) throws Exception {
        com.aliyun.dysmsapi20170525.Client client = CaptchaUtill.createClient(accessKeyId, accessKeySecret);
        com.aliyun.dysmsapi20170525.models.SendSmsRequest sendSmsRequest = new com.aliyun.dysmsapi20170525.models.SendSmsRequest()
                .setPhoneNumbers(tels) //手机号
                .setTemplateCode(SMS) //短信模板CODE
                .setTemplateParam(template) //短信模板变量对应的实际值
                .setSignName(signName); //短信签名名称
        SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
        System.out.println(sendSmsResponse.getBody());
        System.out.println(sendSmsResponse.getBody().getMessage());
        return sendSmsResponse;
    }
}
