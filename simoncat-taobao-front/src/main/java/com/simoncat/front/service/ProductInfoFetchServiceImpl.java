package com.simoncat.front.service;

import com.simoncat.front.vo.ProductInfoVo;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.WirelessShareTpwdQueryRequest;
import com.taobao.api.response.WirelessShareTpwdQueryResponse;

public class ProductInfoFetchServiceImpl implements ProductInfoFetchService {

    @Override
    public ProductInfoVo fetch(String keyword) {
        String key = "【韩国潮牌Flipper萌水果猫爪棒球帽子男女鸭舌帽少女粉色旅游遮阳】http://m.tb.cn/h.3c9uqJS 点击链接，再选择浏览器咑閞；或復·制这段描述€kZdqbaYUWi6€后到淘♂寳♀";
        TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "24958642", "86f2b46a64805200d5bd2a30eed77528");
        WirelessShareTpwdQueryRequest req = new WirelessShareTpwdQueryRequest();
        req.setPasswordContent(key);
        try {
            WirelessShareTpwdQueryResponse rsp = client.execute(req);
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public static void main(String[] args) {
        ProductInfoFetchServiceImpl mock = new ProductInfoFetchServiceImpl();
        mock.fetch("");
    }
}
