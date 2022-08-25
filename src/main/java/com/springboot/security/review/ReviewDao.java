package com.springboot.security.review;

import com.springboot.security.review.model.PostReviewPhotoReq;
import com.springboot.security.review.model.PostReviewReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ReviewDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //리뷰 작성
    public int insertReview(String userId, int shopId,PostReviewReq postReviewReq){
        String insertPostQuery =
                "        INSERT INTO review(user_Id,shop_Id, hair_type,hair_length,hair_tag,kindness,price,rating,content)\n" +
                        "        VALUES (?, ?,?,?,?,?,?,?,?);";
        Object[] insertPostParams = new Object[]{userId,shopId,postReviewReq.getHair_type(),postReviewReq.getHair_length(),
        postReviewReq.getHair_tag(),postReviewReq.getKindness(),postReviewReq.getPrice(),postReviewReq.getRating(),postReviewReq.getContent()};
        this.jdbcTemplate.update(insertPostQuery, insertPostParams);

        String lastInserIdQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInserIdQuery,int.class);

    }

     //리뷰 이미지 작성
    public int insertReviewPhoto(int reviewId, PostReviewPhotoReq postReviewPhotoReq){
        String insertPostImgQuery =
                "        INSERT INTO reviewPhoto(review_id, photo)\n" +
                        "        VALUES (?, ?);";
        Object[] insertPostImgParams = new Object[]{reviewId,postReviewPhotoReq.getPhoto()};
        this.jdbcTemplate.update(insertPostImgQuery, insertPostImgParams);

        String lastInserIdQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInserIdQuery,int.class);
    }

    // 리뷰 작성 시 포인트 등록
    public int insertPoint(String userId,int point){
        String insertPointQuery =
                "update user set point=? where user_id=?;";

       return this.jdbcTemplate.update(insertPointQuery, point, userId);
    }
}
