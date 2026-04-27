 package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.dao.FeePaymentDAO;
import com.model.FeePayment;

public class ReportServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            String type = req.getParameter("type");

            FeePaymentDAO dao = new FeePaymentDAO();
            List<FeePayment> all = dao.getAllPayments();

            // OVERDUE
            if ("overdue".equalsIgnoreCase(type)) {

                List<FeePayment> overdueList = new ArrayList<>();

                for (FeePayment f : all) {
                    if ("Overdue".equalsIgnoreCase(f.getStatus())) {
                        overdueList.add(f);
                    }
                }

                req.setAttribute("list", overdueList);
                req.setAttribute("total", null);

                req.getRequestDispatcher("report_result.jsp").forward(req, res);
            }

            // UNPAID
            else if ("unpaid".equalsIgnoreCase(type)) {

                List<FeePayment> unpaidList = new ArrayList<>();

                for (FeePayment f : all) {
                    if ("Unpaid".equalsIgnoreCase(f.getStatus())) {
                        unpaidList.add(f);
                    }
                }

                req.setAttribute("list", unpaidList);
                req.setAttribute("total", null);

                req.getRequestDispatcher("report_result.jsp").forward(req, res);
            }

            // TOTAL
            else if ("total".equalsIgnoreCase(type)) {

                double total = 0;

                for (FeePayment f : all) {
                    if ("Paid".equalsIgnoreCase(f.getStatus())) {
                        total += f.getAmount();
                    }
                }

                req.setAttribute("list", null);
                req.setAttribute("total", total);

                req.getRequestDispatcher("report_result.jsp").forward(req, res);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}