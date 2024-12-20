<%--
  Created by IntelliJ IDEA.
  User: BAO ANH
  Date: 12/20/2024
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Simple Responsive Admin</title>

    <link href="../asset/css/bootstrap.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <style>
        <%@include file="../asset/css/style.css" %>
    </style>
    <style>
        <%@include file="/View/asset/css/custom.css" %>
    </style>
    <style>
        <%@include file="/View/asset/css/bootstrap.css" %>
    </style>

</head>
<body>


<div id="wrapper">
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="adjust-nav">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="../home.jsp">Quản Lý Trang Web Thắt Lưng</a>
            </div>

            <span class="logout-spn">
                  <a href="#" style="color:#fff;">Xin chào admin</a>

                </span>
        </div>
    </div>
    <!-- /. NAV TOP  -->

    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <!--LINK-->

                <li>
                    <a href="admin_Disboard.html"><i class="fa fa-desktop "></i>Dashboard</a>
                </li>


                <li>
                    <a href=admin_user.html><i class="fa fa-table "></i>USER<span class="badge"></span></a>
                </li>
                <li>
                    <a href="admin_Products.html"><i class="fa fa-edit "></i>PRODUCT<span></span></a>
                </li>
                <li>
                    <a href="admin_Orders.html"><i class="fa fa-qrcode "></i>ORDERS</a>
                </li>
                <li>
                    <a href="#" class="active-link"><i class="fa fa-bar-chart-o"></i>Category</a>
                </li>

                <li>
                    <a href="#"><i class="fa fa-edit "></i>My Link Three </a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-table "></i>My Link Four</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-edit "></i>My Link Five </a>
                </li>

            </ul>
        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h2>Loại sản phẩm</h2>
                </div>
            </div>
            <!-- /. ROW  -->
            <label>
                <input class="search__input" type="text" name="" placeholder="Nhập tên sản phẩm ">
            </label>

            <button class="search__submit">
                <i class="fa-solid fa-magnifying-glass"></i>
                <span>Tìm kiếm</span>
            </button>
            <table class="table table-striped">

                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Loại</th>
                    <th scope="col">Mô tả</th>


                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Mặt khóa lăn</td>
                    <td> Mặt khóa lăn cũng là một loại khóa hộp rất quen thuộc với cánh mày râu khi thường xuyên sử dụng
                        thắt lưng.

                        Bên trong khóa sẽ có một con lăn giúp cố định thắt lưng và điều chỉnh sao cho vừa vặn với vòng
                        eo nam giới.

                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Mặt khóa cài (khóa bấm)</td>
                    <td>Một trong những mặt khóa có thiết kế cùng cách sử dụng rất đơn giản. Khóa được thiết kế mặt phía
                        sau là một mặt phẳng, có nhô lên một chốt để bấm hay cài vào phía trên lỗ của mặt dây lưng da.
                    </td>


                </tr>


                </tbody>
            </table>

            <!-- /. ROW  -->
        </div>
        <!-- /. PAGE INNER  -->
    </div>

</div>


</body>
</html>

