package com.simoncat.front.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductInfoVo {

	private static BigDecimal RATIO = new BigDecimal("0.3");

	private String title;
	private String pictureUrl;
	private String token;
	private BigDecimal rebateRate;
	private BigDecimal rebate;
	private BigDecimal rebateForCustomer;
	private BigDecimal originalPrice;
	private BigDecimal price;
	private String couponInfo;
	private Long couponRemainCount;
	private String shortUrl;

	public ProductInfoVo(String title, String pictureUrl, String token, String rebateRate, String originalPrice,
			String price, String couponInfo, Long couponRemainCount, String shortUrl) {
		this.title = title;
		this.pictureUrl = pictureUrl;
		this.token = token;
		this.rebateRate = new BigDecimal(rebateRate).divide(new BigDecimal("10000"));
		this.originalPrice = new BigDecimal(originalPrice);
		this.price = new BigDecimal(price);
		this.couponInfo = couponInfo;
		this.couponRemainCount = couponRemainCount;
		this.rebate = this.price.multiply(this.rebateRate);
		this.rebateForCustomer = this.rebate.multiply(RATIO).setScale(2, RoundingMode.FLOOR);
		this.shortUrl = shortUrl;
	}
}
