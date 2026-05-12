   package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import com.dao.FeePaymentDAO;
import com.model.FeePayment;

public class AddFeePaymentServlet extends HttpServlet {

    // ✅ SHOW ADD PAGE + NEXT PAYMENT ID
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            FeePaymentDAO dao = new FeePaymentDAO();

            int nextId = dao.getNextPaymentId();  // get next ID

            req.setAttribute("nextId", nextId);

            req.getRequestDispatcher("feepaymentadd.jsp")
               .forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ INSERT PAYMENT
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {

            int studentID = Integer.parseInt(req.getParameter("studentID"));
            String studentName = req.getParameter("studentName");
            String paymentDate = req.getParameter("paymentDate");
            double amount = Double.parseDouble(req.getParameter("amount"));
            String status = req.getParameter("status");

            if (amount <= 0) {
                req.setAttribute("error", "Amount must be greater than 0");
                req.getRequestDispatcher("feepaymentadd.jsp").forward(req, res);
                return;
            }

            // BASIC VALIDATION
            if (studentID <= 0 ||
                studentName == null ||
                studentName.trim().length() < 3 ||
                amount <= 0) {

                req.setAttribute("error", "Invalid Input Data");
                req.getRequestDispatcher("feepaymentadd.jsp").forward(req, res);
                return;
            }

            FeePaymentDAO dao = new FeePaymentDAO();
            List<FeePayment> list = dao.getAllPayments();

            // SAME STUDENT VALIDATION
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

         // CURRENT INSERTED PAYMENT ID
            int currentId = dao.getNextPaymentId() - 1;

            // NEXT PAYMENT ID
            int nextId = dao.getNextPaymentId();

    
            // SUCCESS MESSAGE
            String msg =
            "Payment details added successfully. " +
            "Payment ID = " + currentId +
            ". Next Payment ID moved to = " + nextId;

            // STORE MESSAGE
            req.getSession().setAttribute("msg", msg);

            // REDIRECT BACK TO ADD PAYMENT PAGE
            res.sendRedirect("feepaymentadd.jsp");
             

            // REDIRECT BACK TO ADD PAYMENT PAGE
            res.sendRedirect("feepaymentadd.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
