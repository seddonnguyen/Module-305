package exercise.jdbc_orm.runner;

import exercise.jdbc_orm.DAOinterface.EmployeeDaoImpl;
import exercise.jdbc_orm.model.EmployeePerformanceReview;
import util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class MainRunner {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DBConnection.connect("performance_review")) {
            var dao = new EmployeeDaoImpl(connection);
            Set<String> reviewTexts = Set.of("Good", "Bad", "Excellent", "Poor", "Average");
            List<EmployeePerformanceReview> reviews = null;

            // Display all the reviews
            System.out.println("All the reviews:");
            dao.getAllPerformanceReviews().forEach(System.out::println);

            // Create reviews for all employees
            List<Integer> employees = dao.getAllEmployees();
            int numberOfReviews = employees.size();

            for (Integer employeeNumber : employees) {
                // Choose random review text
                int randomReview = (int) (Math.random() * reviewTexts.size());
                String reviewText = reviewTexts.toArray()[randomReview].toString();

                // Insert the review
                dao.insertPerformanceReview(new EmployeePerformanceReview(employeeNumber, reviewText));
            }
            System.out.println("After inserting the reviews:");
            dao.getAllLatestPerformanceReviews().forEach(System.out::println);

            // Update random review of many employees
            reviews = dao.getAllLatestPerformanceReviews();
            System.out.println("Before updating the reviews:");
            reviews.forEach(System.out::println);

            for (int i = 0; i < 10; i++) {
                // Choose random review
                int randomReviewIndex = (int) (Math.random() * reviews.size());
                int reviewId = reviews.get(randomReviewIndex).getReviewId();

                // Choose random review text
                int randomReview = (int) (Math.random() * reviewTexts.size());
                String reviewText = reviewTexts.toArray()[randomReview].toString();

                // Update the review
                dao.updatePerformanceReview(reviewId, reviewText);
            }
            System.out.println("After updating the reviews:");
            dao.getAllLatestPerformanceReviews().forEach(System.out::println);

            // Delete random review of many employees
            reviews = dao.getAllLatestPerformanceReviews();
            System.out.println("Before deleting the reviews:");
            reviews.forEach(System.out::println);

            for (int i = 0; i < 10; i++) {
                // Choose random review
                int randomReviewIndex = (int) (Math.random() * reviews.size());
                int reviewId = reviews.get(randomReviewIndex).getReviewId();

                // Delete the review
                dao.deletePerformanceReview(reviewId);
            }
            System.out.println("After deleting the reviews:");
            dao.getAllLatestPerformanceReviews().forEach(System.out::println);

        } catch (NullPointerException | SQLException e) {
            e.printStackTrace();
        }
    }
}