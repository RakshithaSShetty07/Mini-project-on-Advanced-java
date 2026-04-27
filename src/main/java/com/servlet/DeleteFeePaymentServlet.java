 package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.dao.FeePaymentDAO;

public class DeleteFeePaymentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {

            int id = Integer.parseInt(req.getParameter("paymentID"));

            if (id <= 0) {
                res.getWriter().println("Invalid Payment ID");
                return;
            }

            FeePaymentDAO dao = new FeePaymentDAO();
            dao.deletePayment(id);

            // MESSAGE
            req.getSession().setAttribute("msg", "Deleted Successfully");

            res.sendRedirect("index.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}