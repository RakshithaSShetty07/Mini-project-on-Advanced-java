  package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;

import com.dao.FeePaymentDAO;
import com.model.FeePayment;

public class DeleteFeePaymentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {

        try{

            int displayID =
                Integer.parseInt(
                    req.getParameter("paymentID")
                );

            FeePaymentDAO dao =
                new FeePaymentDAO();

            List<FeePayment> list =
                dao.getAllPayments();

            int count = 1;

            int realPaymentID = 0;

            for(FeePayment f : list){

                if(f.getStudentName() != null &&
                   f.getStatus() != null &&
                   f.getAmount() > 0){

                    if(count == displayID){

                        realPaymentID =
                            f.getPaymentID();

                        break;
                    }

                    count++;
                }
            }

            // ✅ NO RECORD FOUND
            if(realPaymentID == 0){

                req.getSession().setAttribute(
                    "msg",
                    "No Record Found"
                );

                res.sendRedirect(
                    "DisplayFeePaymentsServlet"
                );

                return;
            }

            // ✅ DELETE RECORD
            dao.deletePayment(realPaymentID);

            req.getSession().setAttribute(
                "msg",
                "Deleted Successfully"
            );

            res.sendRedirect(
                "DisplayFeePaymentsServlet"
            );

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
