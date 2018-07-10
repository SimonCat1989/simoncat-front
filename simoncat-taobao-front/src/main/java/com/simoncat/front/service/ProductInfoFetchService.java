package com.simoncat.front.service;

import com.simoncat.front.vo.ProductInfoVo;

public interface ProductInfoFetchService {

    ProductInfoVo fetch(String keyword);
}
