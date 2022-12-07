package com.hospital.review5.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewCreateRequest {

    private Long hospitalId;
    private String userName;
    private String title;
    private String content;

}
