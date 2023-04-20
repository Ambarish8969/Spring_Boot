<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="savevehicle">
        <input type="text" value="${vid}" placeholder="" name="vid"> <br><br>
        <input type="text" value="${vehicleName}" placeholder="" name="vehicleName"> <br><br>
        <input type="text" value="${vehicleModel}" placeholder="" name="vehicleModel"> <br><br>
        <input type="text" value="${vehicleColor}" placeholder="" name="vehicleColor"> <br><br>
        <input type="submit" value="Update">
    </form>
    <br><br>
    <button><a href="home.jsp">Home Page</a></button>
</body>
</html>