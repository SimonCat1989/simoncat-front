package com.simoncat.front.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Sets;
import com.simoncat.front.vo.ProductInfoVo;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkScMaterialOptionalRequest;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.request.WirelessShareTpwdQueryRequest;
import com.taobao.api.response.TbkScMaterialOptionalResponse;
import com.taobao.api.response.TbkScMaterialOptionalResponse.MapData;
import com.taobao.api.response.TbkTpwdCreateResponse;
import com.taobao.api.response.WirelessShareTpwdQueryResponse;

@Slf4j
public class ProductInfoFetchServiceImpl implements ProductInfoFetchService {

	private static final String TAOBAO_CLIENT_URL = "http://gw.api.taobao.com/router/rest";
	private static final String TAOBAO_CLIENT_APPKEY = "24958642";
	private static final String TAOBAO_CLIENT_SECRET_KEY = "86f2b46a64805200d5bd2a30eed77528";
	@SuppressWarnings("unused")
	private static final String TAOBAO_PID = "mm_41431499_43842211_368920896";
	@SuppressWarnings("unused")
	private static final long TAOBAO_MEMBER_ID = 41431499L;
	private static final long TAOBAO_SITE_ID = 43842211L;
	private static final long TAOBAO_ADZONE_ID = 368920896L;
	private static final String TAOBAO_SESSION_KEY = "6100204a14b415977d36e325039c49a39f3a9a79c81d469119103219";
	private static final String TAOBAO_USER_ID = "41431499";

	private final TaobaoClient client;

	public ProductInfoFetchServiceImpl() {
		this.client = new DefaultTaobaoClient(TAOBAO_CLIENT_URL, TAOBAO_CLIENT_APPKEY, TAOBAO_CLIENT_SECRET_KEY);
	}

	@Override
	public Set<ProductInfoVo> fetch(String keyword) {
		WirelessShareTpwdQueryRequest req = new WirelessShareTpwdQueryRequest();
		req.setPasswordContent(keyword);
		try {
			WirelessShareTpwdQueryResponse rsp = client.execute(req);
			if (rsp.getSuc()) {
				// Start to search the related goods
				TbkScMaterialOptionalRequest searchRequest = new TbkScMaterialOptionalRequest();
				searchRequest.setQ(rsp.getContent());
				searchRequest.setSiteId(TAOBAO_SITE_ID);
				searchRequest.setAdzoneId(TAOBAO_ADZONE_ID);
				TbkScMaterialOptionalResponse searchResponse = client.execute(searchRequest, TAOBAO_SESSION_KEY);
				if (searchResponse.getTotalResults() == null) {
					return Collections.emptySet();
				} else {
					if (searchResponse.getTotalResults() > 1) {
						// Need to decide which one will be displayed to users
						return Sets.newHashSet(doConvert(doPick(searchResponse.getResultList())));
					} else if (searchResponse.getTotalResults() == 1) {
						return Sets.newHashSet(doConvert(searchResponse.getResultList().get(0)));
					} else {
						return Collections.emptySet();
					}
				}
			} else {
				// Return error page
			}
			log.debug("Get response {}", rsp.getBody());
		} catch (ApiException e) {
			log.error("Failed to fetch data with keyword {}",keyword, e);
		}
		return Collections.emptySet();
	}

	private MapData doPick(List<MapData> datas) {
		return datas.get(0);
	}

	private ProductInfoVo doConvert(MapData data) throws ApiException {
		// 生成淘口令
		TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
		req.setUserId(TAOBAO_USER_ID);
		req.setText(data.getTitle());
		req.setLogo(data.getPictUrl());
		req.setUrl("https:" + data.getCouponShareUrl());
		// req.setExt("{}");
		TbkTpwdCreateResponse rsp = client.execute(req);
		if (StringUtils.isBlank(rsp.getErrorCode())) {
			String token = rsp.getData().getModel();
			return new ProductInfoVo(data.getTitle(), data.getPictUrl(), token,
					data.getCommissionRate(), data.getReservePrice(),
					data.getZkFinalPrice(), data.getCouponInfo(),
					data.getCouponRemainCount(), generateShortUrl(token,
							data.getPictUrl()));
		}
		return null;
	}
	
	private String generateShortUrl(String token, String picUrl) {
		try {
			String oldUrl = URLEncoder.encode("http://www.simoncat.top/index.do?token=" + token + "&good=" + picUrl, "UTF-8");
			return ParameterEncoder.encode(oldUrl);
		} catch (UnsupportedEncodingException e) {
			log.error("Can not encode URL with Token {}, picture URL {}",
					token, picUrl, e);
		} 
		return "";
	}

	public static void main(String[] args) {
//		String keyword = "【韩国潮牌Flipper萌水果猫爪棒球帽子男女鸭舌帽少女粉色旅游遮阳】http://m.tb.cn/h.3c9uqJS 点击链接，再选择浏览器咑閞；或復·制这段描述€kZdqbaYUWi6€后到淘♂寳♀";
		ProductInfoFetchServiceImpl mock = new ProductInfoFetchServiceImpl();
//		Set<ProductInfoVo> results = mock.fetch(keyword);
//		results.stream().forEach(res -> {
//			System.out.println(res.toString());
//		});
		
		System.out.println(mock.generateShortUrl("523423423", "hsd"));
		
	}
}
