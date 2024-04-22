package exercise.jdbc_orm.DAOinterface;

import exercise.jdbc_orm.model.EmployeePerformanceReview;

import java.util.List;


public interface PerformanceReviewDAO {
    void insertPerformanceReview(EmployeePerformanceReview review);

    List<EmployeePerformanceReview> getAllPerformanceReviews();

    List<EmployeePerformanceReview> getAllLatestPerformanceReviews();

    void deletePerformanceReview(int reviewId);

    void updatePerformanceReview(int reviewId, String review);
}