package com.simoncat.front.service;

import java.util.Set;

import com.simoncat.front.vo.ProductInfoVo;

public interface ProductInfoFetchService {

    Set<ProductInfoVo> fetch(String keyword);
}
