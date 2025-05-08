package dao;

import model.User;
import java.sql.*;
import java.util.*;
import java.sql.Date;

public class UserDAO {
    private final Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO user (user_id, user_name, user_password, account_type, user_phonenumber, user_email, gender, DoB, balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, user.getUserId());
            stmt.setString(2, user.getUserName());
            stmt.setString(3, user.getUserPassword());
            stmt.setString(4, user.getAccountType());
            stmt.setInt(5, user.getUserPhonenumber());
            stmt.setString(6, user.getUserEmail());
            stmt.setString(7, user.getGender());
            stmt.setDate(8, Date.valueOf(user.getDob()));
            stmt.setFloat(9, user.getBalance());
            stmt.executeUpdate();
        }
    }

    public User getUser(int userId) throws SQLException {
        String sql = "SELECT * FROM user WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_password"),
                        rs.getString("account_type"),
                        rs.getInt("user_phonenumber"),
                        rs.getString("user_email"),
                        rs.getString("gender"),
                        rs.getDate("DoB").toLocalDate(),
                        rs.getFloat("balance")
                    );
                }
            }
        } 
        return null;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new User(
                    rs.getInt("user_id"),
                    rs.getString("user_name"),
                    rs.getString("user_password"),
                    rs.getString("account_type"),
                    rs.getInt("user_phonenumber"),
                    rs.getString("user_email"),
                    rs.getString("gender"),
                    rs.getDate("DoB").toLocalDate(),
                    rs.getFloat("balance")
                ));
            }
        }
        return users;
    }

    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE user SET user_name = ?, user_password = ?, account_type = ?, user_phonenumber = ?, user_email = ?, gender = ?, DoB = ?, balance = ? WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getUserPassword());
            stmt.setString(3, user.getAccountType());
            stmt.setInt(4, user.getUserPhonenumber());
            stmt.setString(5, user.getUserEmail());
            stmt.setString(6, user.getGender());
            stmt.setDate(7, Date.valueOf(user.getDob()));
            stmt.setFloat(8, user.getBalance());
            stmt.setInt(9, user.getUserId());
            stmt.executeUpdate();
        }
    }

    public void deleteUser(int userId) throws SQLException {
        String sql = "DELETE FROM user WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        }
    }
}
