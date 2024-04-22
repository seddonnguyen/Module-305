package exercise.jdbc_orm.DAOinterface;

import exercise.jdbc_orm.model.EmployeePerformanceReview;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements PerformanceReviewDAO {
    private final Connection connection;

    public EmployeeDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public List<Integer> getAllEmployees() {
        // get all employees number
        List<Integer> employees = new ArrayList<>();
        String query = "SELECT employeeNumber FROM Employees";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                employees.add(result.getInt("employeeNumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void insertPerformanceReview(EmployeePerformanceReview review) {
        final String query = "INSERT INTO EmployeePerformanceReviews (employeeNumber, reviewText) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, review.getEmployeeNumber());
            statement.setString(2, review.getReviewText());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EmployeePerformanceReview> getAllPerformanceReviews() {
        // get all employee reviews
        List<EmployeePerformanceReview> reviews = new ArrayList<>();
        String query = "SELECT * FROM EmployeePerformanceReviews GROUP BY employeeNumber, reviewId ORDER BY employeeNumber, reviewId DESC;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                EmployeePerformanceReview review = new EmployeePerformanceReview();
                review.setReviewId(result.getInt("reviewId"));
                review.setEmployeeNumber(result.getInt("employeeNumber"));
                review.setReviewText(result.getString("reviewText"));
                reviews.add(review);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public List<EmployeePerformanceReview> getAllLatestPerformanceReviews() {
        // get all latest employee reviews
        List<EmployeePerformanceReview> reviews = new ArrayList<>();
        String query =
                "SELECT epr.* FROM EmployeePerformanceReviews epr WHERE epr.reviewId = (SELECT reviewId FROM EmployeePerformanceReviews WHERE employeeNumber = epr.employeeNumber ORDER BY reviewId DESC LIMIT 1)\n" +
                "GROUP BY epr.employeeNumber, reviewId\n" + "ORDER BY epr.employeeNumber, reviewId DESC;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                EmployeePerformanceReview review = new EmployeePerformanceReview();
                review.setReviewId(result.getInt("reviewId"));
                review.setEmployeeNumber(result.getInt("employeeNumber"));
                review.setReviewText(result.getString("reviewText"));
                reviews.add(review);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public void deletePerformanceReview(int reviewId) {
        // delete review
        String query = "DELETE FROM EmployeePerformanceReviews WHERE reviewId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reviewId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePerformanceReview(int reviewId, String review) {
        // update review
        String query = "UPDATE EmployeePerformanceReviews SET reviewText = ? WHERE reviewId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, review);
            statement.setInt(2, reviewId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}