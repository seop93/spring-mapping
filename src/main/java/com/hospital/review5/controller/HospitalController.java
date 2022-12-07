package com.hospital.review5.controller;


import com.hospital.review5.domain.dto.ReviewCreateRequest;
import com.hospital.review5.domain.dto.ReviewCreateResponse;
import com.hospital.review5.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hospitals")
@Slf4j
public class HospitalController {


    private final ReviewService reviewService;

    public HospitalController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewCreateResponse> add(@RequestBody ReviewCreateRequest reviewCreateRequest) {
        log.info("{}", reviewCreateRequest);
        return ResponseEntity.ok().body(reviewService.createReview(reviewCreateRequest));
    }

}
