<%@page language="java" %>

<html>
<head>
    <title>Form Page</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>

    <div class="card">
        <h2>Enter Details</h2>

        <form action="addEmployee" method="get">

            <label for="id">Enter ID:</label><br>
            <input type="number" id="id" name="id" placeholder="Enter ID"><br><br>

            <label for="name">Enter Name:</label><br>
            <input type="text" id="name" name="name" placeholder="Enter Name"><br><br>

            <input type="submit" value="Submit">
        </form>
    </div>

</body>
</html>