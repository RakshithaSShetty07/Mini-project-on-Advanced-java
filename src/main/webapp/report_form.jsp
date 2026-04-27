 <%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Total Collection</title>

<style>
body { font-family: Arial; background:#1a1a2e; color:white; margin:0; }
.container { width:350px; margin:120px auto; background:#16213e; padding:25px; border-radius:12px; }
h2 { text-align:center; }

input { width:100%; padding:10px; margin:10px 0; border:none; border-radius:6px; }

button {
    width:100%;
    padding:10px;
    background:#6c5ce7;
    color:white;
    border:none;
    border-radius:6px;
}

button:hover { background:#5a4bd6; }

a { display:block; text-align:center; margin-top:10px; color:#00c3ff; }
</style>

</head>
<body>

<div class="container">

<h2>Total Collection Report</h2>

<form action="ReportCriteriaServlet" method="post">
<input type="date" name="fromDate" required>
<input type="date" name="toDate" required>

<button type="submit">Generate</button>
</form>

<a href="reports.jsp">← Back</a>

</div>

</body>
</html>