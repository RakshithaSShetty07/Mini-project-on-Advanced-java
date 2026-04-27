package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.dao.FeePaymentDAO;
import com.model.FeePayment;

public class ReportCriteriaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            String from = req.getParameter("fromDate");
            String to = req.getParameter("toDate");

            FeePaymentDAO dao = new FeePaymentDAO();

            List<FeePayment> list = dao.getUnpaidStudentsByDate(from, to);

            req.setAttribute("list", list);

            RequestDispatcher rd = req.getRequestDispatcher("report_result.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}