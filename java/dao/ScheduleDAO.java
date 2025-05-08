/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author huynh
 */
import model.Schedule;
import java.sql.*;
import java.util.*;
import java.sql.Date;
import java.sql.Time;

public class ScheduleDAO {
    private final Connection connection;

    public ScheduleDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void addSchedule(Schedule schedule) throws SQLException{
        String sql = "INSERT INTO schedule (schedule_id, route_id, date, start_time, end_time) VALUES (?, ?, ?, ?, ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, schedule.getScheduleId());
            stmt.setString(2, schedule.getRouteId());
            stmt.setDate(3, Date.valueOf(schedule.getDate()));
            stmt.setTime(4, Time.valueOf(schedule.getStartTime()));
            stmt.setTime(5, Time.valueOf(schedule.getEndTime()));
            stmt.executeUpdate();
        }
    }
    
    public Schedule getScheduleById(int scheduleId) throws SQLException{
        String sql = "SELECT * FROM schedule WHERE schedule_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, scheduleId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Schedule(
                        rs.getInt("schedule_id"),
                        rs.getString("route_id"),
                        rs.getDate("date").toLocalDate(),
                        rs.getTime("start_time").toLocalTime(),
                        rs.getTime("end_time").toLocalTime()      
                    );        
                }
            }
        }
        return null;
    }
    
    public void updateSchedule(Schedule schedule) throws SQLException{
        String sql = "UPDATE schedule SET route_id = ?, date = ?, start_time = ?, end_time = ? WHERE schedule_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
              stmt.setString(1, schedule.getRouteId());
              stmt.setDate(2, Date.valueOf(schedule.getDate()));
              stmt.setTime(3, Time.valueOf(schedule.getStartTime()));
              stmt.setTime(4, Time.valueOf(schedule.getEndTime()));
              stmt.setInt(5, schedule.getScheduleId());
              stmt.executeUpdate();
        }        
    }

    public void deleteSchedule(int scheduleId) throws SQLException{
            String sql = "DELETE FROM schedule WHERE schedule_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, scheduleId);
                stmt.executeUpdate();
        }
    }
    
    public List<Schedule> getAllSchedules() throws SQLException{
        List<Schedule> schedules = new ArrayList<>();
        String sql = "SELECT * FROM schedule";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                schedules.add(new Schedule(
                    rs.getInt("schedule_id"),
                    rs.getString("route_id"),
                    rs.getDate("date").toLocalDate(),
                    rs.getTime("start_time").toLocalTime(),
                    rs.getTime("end_time").toLocalTime()
                ));
            }
        }
        return schedules;
}
}
