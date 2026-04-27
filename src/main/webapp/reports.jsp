 <%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Reports</title>

<style>
body {
    font-family: Arial;
    background:#1a1a2e;
    color:white;
    margin:0;
}

.container {
    width:350px;
    margin:120px auto;
    background:#16213e;
    padding:25px;
    border-radius:12px;
    text-align:center;
}

h2 { margin-bottom:20px; }

a {
    display:block;
    margin:10px 0;
    padding:10px;
    background:#6c5ce7;
    color:white;
    text-decoration:none;
    border-radius:6px;
}

a:hover { background:#5a4bd6; }
</style>

</head>
<body>

<div class="container">

<h2>Reports</h2>

<a href="ReportServlet?type=overdue">Overdue Students</a>

<a href="ReportServlet?type=total">Total Collection</a> <!-- ✅ FIXED -->

<a href="ReportServlet?type=unpaid">Unpaid Students</a>

<a href="index.jsp">← Back</a>

</div>

</body>
</html>