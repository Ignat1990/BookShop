package ignatProject.service;


import ignatProject.model.Review;

import java.util.List;

public interface ReviewService {

    List<Review> findAll();

    boolean deleteReview(Long id);

    boolean saveReview(Review id);
}
