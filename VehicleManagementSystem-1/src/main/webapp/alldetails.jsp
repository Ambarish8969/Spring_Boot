<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Vehicles</title>
</head>

<body>
    <h1>Details</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Model</th>
            <th>Color</th>
            <!-- Add more table headers for additional fields as needed -->
        </tr>
        <c:forEach items="${details}" var="detail">
        <tr>
            <td>${detail.vid}</td>
            <td>${detail.vehicleName}</td>
            <td>${detail.vehicleModel}</td>
            <td>${detail.vehicleColor}</td>
            <!-- Access additional fields using the corresponding getters -->
        </tr>
        </c:forEach>
    </table>
</body>

</html>