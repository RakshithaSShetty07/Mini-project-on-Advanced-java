 <%@ page import="java.util.*, com.model.FeePayment" %>

<!DOCTYPE html>
<html>
<head>
<title>View Payments</title>

<style>
body {
    font-family: Arial;
    background-color: #eef2f7;
    margin: 0;
}

/* Title */
.header {
    text-align: center;
    padding: 20px;
    color: #2c3e50;
}
    

/* Table Styling */
table {
    border-collapse: collapse;
    width: 80%;
    margin: auto;
    background-color: white;
    box-shadow: 0px 0px 10px #ccc;
}

th {
    background-color: #4CAF50;
    color: white;
    padding: 12px;
}

td {
    text-align: center;
    padding: 10px;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

/* Status colors */
.unpaid {
    color: red;
    font-weight: bold;
}

.paid {
    color: green;
}

.overdue {
    color: orange;
}

/* Back Button */
.back-btn {
    display: block;
    width: 150px;
    margin: 30px auto;
    text-align: center;
    padding: 10px;
    background-color: #2196F3;
    color: white;
    text-decoration: none;
    border-radius: 5px;
}

.back-btn:hover {
    background-color: #0b7dda;
}
</style>

</head>
<body>

<div class="header">
    <h2>College Fee Payment System</h2>
</div>

<h3 style="text-align:center;">All Fee Payments</h3>

<table>

<tr>
<th>ID</th>
<th>Student ID</th>
<th>Name</th>
<th>Date</th>
<th>Amount</th>
<th>Status</th>
</tr>

<%
List<FeePayment> list = (List<FeePayment>) request.getAttribute("data");

if(list != null){
    for(FeePayment f : list){
%>

<tr>
<td><%= f.getPaymentID() %></td>
<td><%= f.getStudentID() %></td>
<td><%= f.getStudentName() %></td>
<td><%= f.getPaymentDate() %></td>
<td><%= f.getAmount() %></td>

<td class="
<%= "Unpaid".equalsIgnoreCase(f.getStatus()) ? "unpaid" :
    "Paid".equalsIgnoreCase(f.getStatus()) ? "paid" : "overdue" %>
">
<%= f.getStatus() %>
</td>

</tr>

<%
    }
}
%>

</table>

<a class="back-btn" href="index.jsp">Back</a>

</body>
</html>