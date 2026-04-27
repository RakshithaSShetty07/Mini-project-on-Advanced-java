 package com.dao;

import java.sql.*;
import java.util.*;
import com.model.FeePayment;

public class FeePaymentDAO {

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/javaproject",
            "root",
            "yourpassword"
        );
    }

    // ADD
    public void addPayment(FeePayment f) throws Exception {
        Connection con = getConnection();

        String sql = "INSERT INTO FeePayments(StudentID, StudentName, PaymentDate, Amount, Status) VALUES(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, f.getStudentID());
        ps.setString(2, f.getStudentName());
        ps.setString(3, f.getPaymentDate());
        ps.setDouble(4, f.getAmount());
        ps.setString(5, f.getStatus());

        ps.executeUpdate();
        con.close();
    }

    // UPDATE
    public void updatePayment(FeePayment f) throws Exception {
        Connection con = getConnection();

        String sql = "UPDATE FeePayments SET StudentName=?, Amount=?, Status=? WHERE PaymentID=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, f.getStudentName());
        ps.setDouble(2, f.getAmount());
        ps.setString(3, f.getStatus());
        ps.setInt(4, f.getPaymentID());

        ps.executeUpdate();
        con.close();
    }

    // DELETE
    public void deletePayment(int id) throws Exception {
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement("DELETE FROM FeePayments WHERE PaymentID=?");
        ps.setInt(1, id);

        ps.executeUpdate();
        con.close();
    }

    // DISPLAY
    public List<FeePayment> getAllPayments() throws Exception {
        List<FeePayment> list = new ArrayList<>();
        Connection con = getConnection();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM FeePayments");

        while (rs.next()) {
            FeePayment f = new FeePayment();

            f.setPaymentID(rs.getInt("PaymentID"));
            f.setStudentID(rs.getInt("StudentID"));
            f.setStudentName(rs.getString("StudentName"));
            f.setPaymentDate(rs.getString("PaymentDate"));
            f.setAmount(rs.getDouble("Amount"));
            f.setStatus(rs.getString("Status"));

            list.add(f);
        }

        con.close();
        return list;
    }

    // OVERDUE
    public List<FeePayment> getOverdueStudents() throws Exception {
        List<FeePayment> list = new ArrayList<>();
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM FeePayments WHERE Status='Overdue'");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            FeePayment f = new FeePayment();
            f.setPaymentID(rs.getInt("PaymentID"));
            f.setStudentName(rs.getString("StudentName"));
            f.setAmount(rs.getDouble("Amount"));
            f.setStatus(rs.getString("Status"));
            list.add(f);
        }

        con.close();
        return list;
    }

    // UNPAID (NEW REQUIRED FEATURE)
    public List<FeePayment> getUnpaidStudentsByDate(String from, String to) throws Exception {

        List<FeePayment> list = new ArrayList<>();
        Connection con = getConnection();

        String sql = "SELECT * FROM FeePayments WHERE PaymentDate BETWEEN ? AND ? AND Status='Unpaid'";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, from);
        ps.setString(2, to);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            FeePayment f = new FeePayment();

            f.setPaymentID(rs.getInt("PaymentID"));
            f.setStudentID(rs.getInt("StudentID"));
            f.setStudentName(rs.getString("StudentName"));
            f.setPaymentDate(rs.getString("PaymentDate"));
            f.setAmount(rs.getDouble("Amount"));
            f.setStatus(rs.getString("Status"));

            list.add(f);
        }

        con.close();
        return list;
    }

    // TOTAL
    public double getTotalCollection() throws Exception {
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT SUM(Amount) FROM FeePayments WHERE Status='Paid'"
        );

        ResultSet rs = ps.executeQuery();

        double total = 0;
        if (rs.next()) {
            total = rs.getDouble(1);
        }

        con.close();
        return total;
    }
}