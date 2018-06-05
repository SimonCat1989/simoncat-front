package com.simoncat.front.vo;

import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.simoncat.front.dto.RecommendationDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationVo {

	public static final RecommendationVo EMPTY = new RecommendationVo(Collections.emptyList());

	private List<RecommendationDto> data;
}
