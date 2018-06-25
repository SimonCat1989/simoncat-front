package com.simoncat.front.vo;

import java.util.Set;
import java.util.stream.Collectors;

import lombok.Getter;

import com.simoncat.front.dto.EssayDto;

public class EssayVo {

    private final EssayAbstractVo essay;
    
    @Getter
    private final Set<EssayCommentVo> essayComments;

    public EssayVo(EssayDto dto) {
        this.essay = new EssayAbstractVo(dto);
        this.essayComments = dto.getEssayComments().stream().map(EssayCommentVo::new).collect(Collectors.toSet());
    }

    public String getAuthor() {
        return essay.getAuthor();
    }

    public String getAuthorAvatar() {
        return essay.getAuthorAvatar();
    }

    public Integer getComment() {
        return essay.getComment();
    }

    public String getCreateDay() {
        return essay.getCreateDay();
    }

    public String getCreateMonth() {
        return essay.getCreateMonth();
    }

    public String getCreateMonthSuffix() {
        return essay.getCreateMonthSuffix();
    }

    public String getCreateYear() {
        return essay.getCreateYear();
    }

    public String getDescription() {
        return essay.getDescription();
    }

    public Integer getFacebook() {
        return essay.getFacebook();
    }

    public Integer getHeart() {
        return essay.getHeart();
    }

    public String getKeyword() {
        return essay.getKeyword();
    }

    public String getTitle() {
        return essay.getTitle();
    }

    public Integer getTwitter() {
        return essay.getTwitter();
    }

}
