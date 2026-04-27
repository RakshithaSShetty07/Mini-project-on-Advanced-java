 <%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Update Fee Payment</title>

<style>
body { font-family: Arial; background:#1a1a2e; color:white; margin:0; }
.container { width:350px; margin:100px auto; background:#16213e; padding:25px; border-radius:12px; }
h2 { text-align:center; }
input, select { width:100%; padding:10px; margin:10px 0; border:none; border-radius:6px; }
button { width:100%; padding:10px; background:#6c5ce7; color:white; border:none; border-radius:6px; }
button:hover { background:#5a4bd6; }
a { display:block; text-align:center; margin-top:10px; color:#00c3ff; }
</style>

</head>
<body>
<div class="container">

<h2>Update Fee Payment</h2>

<form action="UpdateFeePaymentServlet" method="post">
<input type="number" name="paymentID" placeholder="Payment ID" required>
<input type="text" name="studentName" placeholder="Student Name" required>
<input type="number" name="amount" placeholder="Amount" required>

<select name="status">
<option>Paid</option>
<option>Overdue</option>
<option>Unpaid</option>
</select>

<button type="submit">Update</button>
</form>

<a href="index.jsp">← Back</a>

</div>
</body>
</html>