package com.simoncat.front.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EssayListVo {

    private int totalPage;
    private int currentPage;
    private List<EssayAbstractVo> essays;
}
