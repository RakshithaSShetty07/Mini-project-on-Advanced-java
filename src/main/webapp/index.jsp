<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>College Fee System</title>

<style>
body {
    font-family: Arial;
    background:#1a1a2e;
    color:white;
    margin:0;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}

.container {
    background:#16213e;
    padding:30px;
    border-radius:12px;
    text-align:center;
    width:300px;
}

a {
    display:block;
    margin:10px 0;
    padding:10px;
    background:#6c5ce7;
    color:white;
    text-decoration:none;
    border-radius:6px;
}

a:hover {
    background:#5a4bd6;
}

.msg {
    color:#00ff99;
    font-weight:bold;
    margin-bottom:15px;
}

.error {
    color:#ff4d4d;
    font-weight:bold;
    margin-bottom:15px;
}
</style>

</head>
<body>

<div class="container">

<%
String msg = (String) session.getAttribute("msg");

if(msg != null){
%>

    <div class="msg"><%= msg %></div>

    <a href="index.jsp">← Back</a>

<%
session.removeAttribute("msg");
} else {
%>

    <h2>College Fee Payment System</h2>

    <a href="feepaymentadd.jsp">Add Payment</a>
    <a href="feepaymentupdate.jsp">Update Payment</a>
    <a href="feepaymentdelete.jsp">Delete Payment</a>
    <a href="DisplayFeePaymentsServlet">View Payments</a>
    <a href="reports.jsp">Reports</a>

<%
}
%>

</div>

</body>
</html>