package com.springboot.security.review;

import com.springboot.security.config.BaseException;
import com.springboot.security.config.BaseResponse;
import com.springboot.security.review.model.PostReviewReq;
import com.springboot.security.review.model.PostReviewRes;
import com.springboot.security.user.model.GetUserRes;
import com.springboot.security.utils.JwtService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.security.Principal;
import java.util.List;

import static com.springboot.security.Login.NaverLoginController.userMap;
import static com.springboot.security.config.BaseResponseStatus.EMPTY_JWT;
import static com.springboot.security.config.BaseResponseStatus.POST_REVIEWS_EMPTY_CONTENT;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private final ReviewProvider reviewProvider;
    @Autowired
    private final ReviewService reviewService;
    @Autowired
    private final JwtService jwtService;



    public ReviewController(ReviewProvider reviewProvider, ReviewService reviewService, JwtService jwtService){
        this.reviewProvider = reviewProvider;
        this.reviewService = reviewService;
        this.jwtService = jwtService;
    }

//,
    //리뷰 작성
    @RequestMapping("/new")
    public BaseResponse createReiew (HttpSession session,@RequestBody PostReviewReq postReviewReq){
        if(postReviewReq.getContent() == null){
            return new BaseResponse<>(POST_REVIEWS_EMPTY_CONTENT);
        }
        if(postReviewReq.getHair_type()==null){
            return new BaseResponse<>(POST_REVIEWS_EMPTY_CONTENT);
        }
        if(postReviewReq.getHair_length()==null){
            return new BaseResponse<>(POST_REVIEWS_EMPTY_CONTENT);
        }
        if(postReviewReq.getHair_tag()==null){
            return new BaseResponse<>(POST_REVIEWS_EMPTY_CONTENT);
        }
        if(postReviewReq.getKindness()==null){
            return new BaseResponse<>(POST_REVIEWS_EMPTY_CONTENT);
        }
        if(postReviewReq.getPrice()==null){
            return new BaseResponse<>(POST_REVIEWS_EMPTY_CONTENT);
        }

        try{
            String userId = (String) userMap.get("id");
          //  String userId =(String) session.getAttribute("currentUserId");
            int shopId=((Integer) session.getAttribute("searchShopId")).intValue();
//            System.out.print(userId);

//           System.out.print(userId);
            PostReviewRes postReviewRes = reviewService.createReview(userId,shopId,postReviewReq);
//
            return new BaseResponse<>(postReviewRes);
        } catch(Exception exception){
            return new BaseResponse<>((exception.getStackTrace()));

        }
    }
}
