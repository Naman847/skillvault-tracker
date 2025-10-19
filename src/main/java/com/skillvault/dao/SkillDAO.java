package com.skillvault.dao;

import com.skillvault.model.Skill;
import com.skillvault.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillDAO {

    public boolean insertSkill(Skill skill) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsInserted = 0;

        try {
            String query = "INSERT INTO skills VALUES(?,?,?,?,?)";
            conn = DbConnection.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, skill.getId());
            stmt.setString(2, skill.getName());
            stmt.setString(3, skill.getCategory());
            stmt.setInt(4, skill.getDifficulty());
            stmt.setInt(5, skill.getMasteryLevel());
            rowsInserted = stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error while inserting skill: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
        return rowsInserted > 0;
    }

    public List<Skill> viewAllSkills() {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Skill> skills = new ArrayList<>();

        try {
            String sql = "SELECT * FROM skills";
            connection = DbConnection.getConnection();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Skill skill = new Skill(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getInt("difficulty"),
                        rs.getInt("mastery_level")
                );
                skills.add(skill);
            }

        } catch (SQLException se) {
            System.out.println("Error: " + se.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }

        return skills;
    }

    public Skill getSkillById(int id) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Skill skill = null;

        try {
            String sql = "SELECT * FROM skills WHERE id=?";
            connection = DbConnection.getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                skill = new Skill(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getInt("difficulty"),
                        rs.getInt("mastery_level")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error while fetching skill: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }

        return skill;
    }

    public boolean updateSkill(Skill skill) {
        Connection connection = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;

        try {
            String sql = "UPDATE skills SET name = ?, category = ?, difficulty = ?, mastery_level = ? WHERE id = ?";
            connection = DbConnection.getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, skill.getName());
            stmt.setString(2, skill.getCategory());
            stmt.setInt(3, skill.getDifficulty());
            stmt.setInt(4, skill.getMasteryLevel());
            stmt.setInt(5, skill.getId());
            rowsAffected = stmt.executeUpdate();

        } catch (SQLException se) {
            System.out.println("Error: " + se.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                System.out.println("Error closing resources: " + se.getMessage());
            }
        }

        return rowsAffected > 0;
    }

    public boolean deleteSkill(int id) {
        Connection connection = null;
        PreparedStatement stmt = null;
        int rowsDeleted = 0;

        try {
            String sql = "DELETE FROM skills WHERE id = ?";
            connection = DbConnection.getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            rowsDeleted = stmt.executeUpdate();

        } catch (SQLException se) {
            System.out.println("Error: " + se.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                System.out.println("Error closing resources: " + se.getMessage());
            }
        }

        return rowsDeleted > 0;
    }

}
