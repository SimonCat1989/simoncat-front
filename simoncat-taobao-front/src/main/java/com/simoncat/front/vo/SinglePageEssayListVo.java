package com.simoncat.front.vo;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class SinglePageEssayListVo {

	private final int totalPage;
    private final int currentPage;
    private final List<SinglePageEssayVo> essays;
}
