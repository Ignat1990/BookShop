package ignatProject.controllers;



import ignatProject.model.Review;
import ignatProject.repository.ReviewRepository;
import ignatProject.service.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin/review")
public class ReviewController {

    @Autowired
    protected ReviewServiceImpl reviewServiceImpl;

    @Autowired
    protected ReviewRepository reviewRepository;

    @GetMapping
    public String viewReview(Model model) {
        model.addAttribute("allReview", reviewServiceImpl.findAll());
        model.addAttribute("newReviewForm", new Review());
        return "admin/Review/review";
    }

    @PostMapping
    public String newReview(@ModelAttribute("newReviewForm") Review newReviewForm, Model model) {
        if (!reviewServiceImpl.saveReview(newReviewForm)) {
            model.addAttribute("reviewNameError", "This title review is taken");
            return "admin/Review/newreview";
        }
        return "redirect:/admin/Review";

    }

    @GetMapping("/delete/{id}")
    public String deleteReview(@PathVariable("id") long id) {
        reviewServiceImpl.deleteReview(id);
        return "redirect:/admin/Review";
    }

    @GetMapping("/edit/{id}")
    public String editReview(@PathVariable("id") long id, Model model) {
        if (!reviewRepository.existsById(id)) {
            return "redirect:admin/Review";
        }
        Review review = reviewRepository.findById(id).get();
        ArrayList<Review> editReview = new ArrayList<>();
        editReview.add(review);
        model.addAttribute("editReview", editReview);
        return "admin/Review/review";
    }

    @PostMapping("/edit/{id}")
    public String updateReview(@PathVariable("id") long id, @RequestParam String title, @RequestParam String content, Model model) {
        Review review = reviewRepository.findById(id).get();
        review.setTitle(title);
        review.setContent(content);
        reviewRepository.save(review);
        return "redirect:/admin/Review";
    }


}
