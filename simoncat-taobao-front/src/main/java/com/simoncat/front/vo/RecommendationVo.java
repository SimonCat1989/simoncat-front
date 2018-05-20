package com.simoncat.front.vo;

import java.util.Collections;
import java.util.List;

import com.simoncat.front.dto.RecommendationDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecommendationVo {

	public static final RecommendationVo EMPTY = new RecommendationVo(Collections.emptyList());

	private final List<RecommendationDto> data;
}
