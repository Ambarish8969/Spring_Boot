<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Students</title>
</head>
<body>
    <table class="table table-bordered table-striped">
			
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phno</th>
            </tr>
        </thead>
        <tbody>
            <% 
                for(Student student:students){
                    <tr>
                        <td th:text="${student.id}" />
                        <td th:text="${student.name}" />
                        <td th:text="${student.email}" />
                        <td th:text="${student.phno}" />
                    </tr>
            } %>
            
        </tbody>
        
    </table>
</body>
</html>