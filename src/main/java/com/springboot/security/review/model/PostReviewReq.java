package com.springboot.security.review.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostReviewReq {

    private int review_id;
    private String user_id;
    private String hair_type;
    private String hair_length;
    private String hair_tag;
    private String kindness;
    private String price;
    private int rating;
    private String content;
    private List<PostReviewPhotoReq> photo;

}
