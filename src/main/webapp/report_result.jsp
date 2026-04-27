<%@ page import="java.util.*, com.model.FeePayment" %>

<!DOCTYPE html>
<html>
<head>
<title>Report Result</title>

<style>
body {
    font-family: Arial;
    background:#1a1a2e;
    color:white;
    margin:0;
}

h2 { text-align:center; margin-top:30px; }

table {
    border-collapse: collapse;
    width:80%;
    margin:30px auto;
    background:#16213e;
}

th {
    background:#6c5ce7;
    padding:12px;
}

td {
    padding:10px;
    text-align:center;
}

.unpaid { color:red; font-weight:bold; }
.paid { color:#00ff99; }
.overdue { color:orange; }

.total-box {
    text-align:center;
    font-size:24px;
    margin-top:50px;
    color:#00ffcc;
}

.back-btn {
    display:block;
    width:150px;
    margin:30px auto;
    padding:10px;
    background:#6c5ce7;
    color:white;
    text-align:center;
    border-radius:6px;
    text-decoration:none;
}
</style>

</head>
<body>

<%
List<FeePayment> list = (List<FeePayment>) request.getAttribute("list");
Double total = (Double) request.getAttribute("total");
%>

<!-- ✅ TOTAL FIRST -->
<% if(total != null){ %>

<h2>Total Collection</h2>

<div class="total-box">
 <%= total %>
</div>

<% } else if(list != null){ %>

<h2>Report</h2>

<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Amount</th>
<th>Status</th>
</tr>

<%
for(FeePayment f : list){
%>

<tr>
<td><%= f.getPaymentID() %></td>
<td><%= f.getStudentName() %></td>
<td><%= f.getAmount() %></td>

<td
<%
if("Unpaid".equalsIgnoreCase(f.getStatus())) {
%> class="unpaid"
<%
} else if("Paid".equalsIgnoreCase(f.getStatus())) {
%> class="paid"
<%
} else {
%> class="overdue"
<%
}
%>
>
<%= f.getStatus() %>
</td>

</tr>

<% } %>

</table>

<% } %>

<a class="back-btn" href="reports.jsp">Back</a>

</body>
</html>