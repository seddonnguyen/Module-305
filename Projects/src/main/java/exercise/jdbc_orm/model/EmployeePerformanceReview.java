package exercise.jdbc_orm.model;

/*
Create JDBC-ORM example for Employee Performance Review's:

1. Create the model "EmployeePerformanceReview" with the following fields
    - private int reviewId;(PK)
    - private int employeeNumber;(FK will map to employees table)
    - private String reviewText;

2. Create the DAO interface with the following method's:
    - void insertPerformanceReview(EmployeePerformanceReview review);
    - List<EmployeePerformanceReview> getAllPerformanceReviews();
    - void deletePerformanceReview(int reviewId);

3. Create the DAO implementation that implements the DAO interface

4. In the you MainRunner(entry point) class create two different reviews of two different employees
*/

/*
CREATE DATABASE performance_review;

CREATE TABLE IF NOT EXISTS EmployeePerformanceReviews
(
    reviewId       INT AUTO_INCREMENT PRIMARY KEY,
    employeeNumber INT NOT NULL,
    reviewText     TEXT,
    FOREIGN KEY (employeeNumber) REFERENCES Employees (employeeNumber)
);
*/

public class EmployeePerformanceReview {
    private int reviewId;
    private int employeeNumber;
    private String reviewText;

    public EmployeePerformanceReview() {
    }

    public EmployeePerformanceReview(int employeeNumber, String reviewText) {
        this.employeeNumber = employeeNumber;
        this.reviewText = reviewText;
    }

    public EmployeePerformanceReview(int reviewId, int employeeNumber, String reviewText) {
        this(employeeNumber, reviewText);
        this.reviewId = reviewId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    @Override
    public String toString() {
        return "EmployeePerformanceReview{" + "reviewId=" + reviewId + ", employeeNumber=" + employeeNumber + ", reviewText='" + reviewText + "'}";
    }
}