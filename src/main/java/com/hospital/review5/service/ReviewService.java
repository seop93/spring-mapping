package com.hospital.review5.service;

import com.hospital.review5.domain.Hospital;
import com.hospital.review5.domain.Review;
import com.hospital.review5.domain.dto.ReviewCreateRequest;
import com.hospital.review5.domain.dto.ReviewCreateResponse;
import com.hospital.review5.repository.HospitalRepository;
import com.hospital.review5.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;

    public ReviewService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }

    public ReviewCreateResponse createReview(ReviewCreateRequest dto){
        //hospital 불러오기
        Optional<Hospital> hospitalOptional = hospitalRepository.findById(dto.getHospitalId());

        //ReviewEntity만들기
        Review review = Review.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .patientName(dto.getUserName())
                .hospital(hospitalOptional.get())
                .build();
        dto.getHospitalId();
        //저장
        Review savedReview = reviewRepository.save(review);
        return ReviewCreateResponse.builder()
                .userNAme(savedReview.getPatientName())
                .title(savedReview.getTitle())
                .content(savedReview.getContent())
                .message("리뷰등록 성공")
                .build();
    }
}
