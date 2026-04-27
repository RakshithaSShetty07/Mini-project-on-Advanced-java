 package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.dao.FeePaymentDAO;
import com.model.FeePayment;

public class AddFeePaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {

            int studentID = Integer.parseInt(req.getParameter("studentID"));
            String studentName = req.getParameter("studentName");
            String paymentDate = req.getParameter("paymentDate");
            double amount = Double.parseDouble(req.getParameter("amount"));
            String status = req.getParameter("status");

            // BASIC VALIDATION
            if (studentID <= 0 || studentName == null || studentName.trim().length() < 3 || amount <= 0) {

                req.setAttribute("error", "Invalid Input Data");
                req.getRequestDispatcher("feepaymentadd.jsp").forward(req, res);
                return;
            }

            FeePaymentDAO dao = new FeePaymentDAO();
            List<FeePayment> list = dao.getAllPayments();

            // SAME STUDENT ID VALIDATION
            for (FeePayment existing : list) {
                if (existing.getStudentID() == studentID &&
                        !existing.getStudentName().equalsIgnoreCase(studentName)) {

                    req.setAttribute("error", "Same Student ID cannot have different names");
                    req.getRequestDispatcher("feepaymentadd.jsp").forward(req, res);
                    return;
                }
            }

            // INSERT DATA
            FeePayment f = new FeePayment();
            f.setStudentID(studentID);
            f.setStudentName(studentName);
            f.setPaymentDate(paymentDate);
            f.setAmount(amount);
            f.setStatus(status);

            dao.addPayment(f);

            // SUCCESS MESSAGE
            req.getSession().setAttribute("msg", "Inserted Successfully");
            res.sendRedirect("index.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}