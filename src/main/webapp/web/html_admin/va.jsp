<%--
  Created by IntelliJ IDEA.
  User: BAO ANH
  Date: 12/24/2024
  Time: 12:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link rel="stylesheet" href="https://cdn.datatables.net/2.1.8/css/dataTables.dataTables.css" />
  <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
  <script src="https://cdn.datatables.net/2.1.8/js/dataTables.js"></script>
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
  <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>




</head>
<body>
<table id="myTable" class="display">
  <thead>
  <tr>
    <th>Column 1</th>
    <th>Column 2</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td>Row 1 Data 1</td>
    <td>Row 1 Data 2</td>
  </tr>
  <tr>
    <td>Row 2 Data 1</td>
    <td>Row 2 Data 2</td>
  </tr>
  </tbody>
</table>
<script>
  $(document).ready( function () {
    $('#myTable').DataTable();
  } );
</script>
</body>
</html>