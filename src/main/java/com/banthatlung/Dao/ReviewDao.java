package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.Review;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReviewDao {
    public void addReview(Review review) {
        String query = "INSERT INTO ProductReviews (review_id, product_id, user_id, rating, url, review_text, review_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (
             PreparedStatement stmt = DBConnect2.getPreparedStatement(query)) {
            stmt.setString(1, "u"+(getTotalReviews()+1));
            stmt.setInt(2, review.getProductId());
            stmt.setString(3, review.getUserId());
            stmt.setInt(4, review.getRating());
            stmt.setString(5, review.getUrl());
            stmt.setString(6, review.getReviewText());
            stmt.setString(7, review.getReviewDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Review> getReviewsByProductId(String pid){
        int id = Integer.parseInt(pid);
    ArrayList<Review> reviews = new ArrayList<Review>();
    String sql = "select * from reviews where product_id = ?";
    ResultSet rs=null;
    try {
        PreparedStatement  pstmt = DBConnect2.getPreparedStatement(sql);
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            reviews.add(new Review(rs.getString(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)));
            }
        return reviews;
        }
    catch (SQLException e) {
        return reviews;
    }
    }
    public int getTotalReviews() {
        String query = "SELECT COUNT(*) AS total FROM reviews";
        try (
             Statement stmt = DBConnect2.get()) {
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}