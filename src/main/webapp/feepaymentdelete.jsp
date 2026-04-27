 <%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Delete Payment</title>

<style>
body { font-family: Arial; background:#1a1a2e; color:white; margin:0; }
.container { width:350px; margin:120px auto; background:#16213e; padding:25px; border-radius:12px; }
h2 { text-align:center; }
input { width:100%; padding:10px; margin:10px 0; border:none; border-radius:6px; }
button { width:100%; padding:10px; background:#e74c3c; color:white; border:none; border-radius:6px; }
button:hover { background:#c0392b; }
a { display:block; text-align:center; margin-top:10px; color:#00c3ff; }
</style>

</head>
<body>
<div class="container">

<h2>Delete Fee Payment</h2>

<form action="DeleteFeePaymentServlet" method="get">
<input type="number" name="paymentID" placeholder="Payment ID" required>
<button type="submit">Delete</button>
</form>

<a href="index.jsp">← Back</a>

</div>
</body>
</html>