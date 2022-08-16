package com.springboot.security.review.model;

import jdk.javadoc.internal.doclets.formats.html.markup.Text;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostReviewsRes {
    private int review_id;
    private int shop_id;
    private String user_id;
    private String hair_type;
    private String hair_length;
    private String hair_tag;
    private String kindness;
    private String price;
    private String rating;
    private Text content;


}
