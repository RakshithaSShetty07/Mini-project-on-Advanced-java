 package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.dao.FeePaymentDAO;
import com.model.FeePayment;

public class UpdateFeePaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {

            int paymentID = Integer.parseInt(req.getParameter("paymentID"));
            String studentName = req.getParameter("studentName");
            double amount = Double.parseDouble(req.getParameter("amount"));
            String status = req.getParameter("status");

            if (paymentID <= 0 || studentName == null || studentName.trim().length() < 3 || amount <= 0) {
                res.getWriter().println("Invalid Input Data");
                return;
            }

            FeePayment f = new FeePayment();
            f.setPaymentID(paymentID);
            f.setStudentName(studentName);
            f.setAmount(amount);
            f.setStatus(status);

            FeePaymentDAO dao = new FeePaymentDAO();
            dao.updatePayment(f);

            // MESSAGE
            req.getSession().setAttribute("msg", "Updated Successfully");

            res.sendRedirect("index.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}