<%@page language="java" %>

<html>
<head>
    <title>Form Page</title>
    <link rel="stylesheet" type="text/css" href="views/style.css">
</head>

<body>

    <div class="card">
        <h2>Enter Details</h2>

        <form action="add">

            <input type="number" name="num1" placeholder="Number 1"><br><br>
            <input type="number" name="num2" placeholder="Number 2"><br><br>

            <input type="submit" value="Submit">
        </form>
    </div>

</body>
</html>