package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Captain;
import com.example.capstone3.Model.Review;
import com.example.capstone3.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<Review> getReviews()
    {
        return reviewRepository.findAll();
    }
    public void addReview(Review review)
    {
        reviewRepository.save(review);
    }
    public void updateReview(Integer id,Review review)
    {
        Review r = reviewRepository.findReviewById(id);
        if(r == null)
        {
         throw new ApiException("Review not found");
        }
        r.setComment(review.getComment());
        r.setRate(review.getRate());
        reviewRepository.save(r);
    }
    public void deleteReview(Integer id)
    {
        if(reviewRepository.findReviewById(id) == null)
        {
            throw new ApiException("Review not found");
        }
        reviewRepository.deleteById(id);
    }

    public void deleteByComment(String comment)
    {
        if(reviewRepository.findReviewByCommentContains(comment).isEmpty())
        {
            throw new ApiException("It is null");
        }
        reviewRepository.deleteAll(reviewRepository.findReviewByCommentContains(comment));
    }


}