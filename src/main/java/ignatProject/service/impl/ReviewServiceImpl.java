package ignatProject.service.impl;


import ignatProject.model.Review;
import ignatProject.repository.ReviewRepository;
import ignatProject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    protected ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public boolean saveReview(Review title) {
        Review reviewFromDB = reviewRepository.findByTitle(title.getTitle());

        if (reviewFromDB != null) {
            return false;
        }
        reviewRepository.save(title);
        return true;
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        if (reviewRepository.findById(reviewId).isPresent()) {
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }

}
