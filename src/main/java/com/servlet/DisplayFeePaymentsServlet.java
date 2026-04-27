 package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.dao.FeePaymentDAO;
import com.model.FeePayment;

public class DisplayFeePaymentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            FeePaymentDAO dao = new FeePaymentDAO();
            List<FeePayment> list = dao.getAllPayments();

            req.setAttribute("data", list);

            RequestDispatcher rd = req.getRequestDispatcher("feepaymentdisplay.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
