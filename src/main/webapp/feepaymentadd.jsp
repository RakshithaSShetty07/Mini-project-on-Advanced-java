 <%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<title>Add Fee Payment</title>

<style>
body {
    font-family: Arial;
    background: #1a1a2e;
    margin: 0;
    color: white;
}

.container {
    width: 350px;
    margin: 100px auto;
    background: #16213e;
    padding: 25px;
    border-radius: 12px;
    box-shadow: 0px 0px 15px rgba(0,0,0,0.6);
}

h2 {
    text-align: center;
    color: white;
}

.error {
    color: #ff4d4d;
    text-align: center;
    margin-bottom: 10px;
    font-weight: bold;
}

label {
    display: block;
    margin-top: 10px;
}

input, select {
    width: 100%;
    padding: 10px;
    margin-top: 5px;
    margin-bottom: 15px;
    border-radius: 6px;
    border: none;
}

button {
    width: 100%;
    padding: 10px;
    background-color: #6c5ce7;
    color: white;
    border: none;
    border-radius: 6px;
    cursor: pointer;
}

button:hover {
    background-color: #5a4bd6;
}

.back {
    display: block;
    text-align: center;
    margin-top: 15px;
    text-decoration: none;
    color: #00c3ff;
}
</style>

</head>
<body>

<div class="container">

<h2>Add Fee Payment</h2>

<%
String error = (String) request.getAttribute("error");
if(error != null){
%>
<div class="error"><%= error %></div>
<%
}
%>

<form action="AddFeePaymentServlet" method="post">

<label>Student ID</label>
<input type="number" name="studentID" min="1" required>

<label>Student Name</label>
<input type="text" name="studentName" pattern="[A-Za-z ]{3,}" required>

<label>Payment Date</label>
<input type="date" name="paymentDate" required>

<label>Amount</label>
<input type="number" name="amount" min="1" step="0.01" required>

<label>Status</label>
<select name="status">
<option>Paid</option>
<option>Overdue</option>
<option>Unpaid</option>
</select>

<button type="submit">Add Payment</button>

</form>

<a class="back" href="index.jsp">← Back</a>

</div>

</body>
</html>