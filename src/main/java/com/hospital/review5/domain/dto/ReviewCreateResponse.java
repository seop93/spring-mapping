package com.hospital.review5.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class ReviewCreateResponse {
    private String userNAme;
    private String title;
    private String content;
    private String message;
}
