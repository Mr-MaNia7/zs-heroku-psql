package com.mania.zerosheet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    SPORT("S"), MUSIC("M"), TECHNOLOGY("T");
    
    private String code;
}



