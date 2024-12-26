<%--
  Created by IntelliJ IDEA.
  User: BAO ANH
  Date: 12/20/2024
  Time: 3:40 PM
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
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
                <a class="navbar-brand" href="../View/home.jsp">Quản Lý Trang Web Thắt Lưng</a>
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
                    <a href="admin_Orders.html" class="active-link"><i class="fa fa-qrcode "></i>ORDERS</a>
                </li>
                <li>
                    <a href="admin_Category.html"><i class="fa fa-bar-chart-o"></i>Category</a>
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
                    <h2>Đơn hàng</h2>
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
                <thead style="background: #4cb4ff">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Người đặt hàng</th>
                    <th scope="col">Ngày đặt hàng</th>
                    <th scope="col">Tổng tiền</th>
                    <th scope="col">Địa chỉ</th>
                    <th scope="col"><label for="cars">Trạng thái giao hàng</label>

                        <select name="cars" id="cars">
                            <option value="volvo">Lựa chọn</option>
                            <option value="saab">Chờ xử lý</option>
                            <option value="mercedes">Đang giao</option>
                            <option value="audi">Đã giao</option>
                            <option value="audi">Đã hủy</option>
                        </select></th>


                </tr>
                </thead>

                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Trần Thị B</td>
                    <td>31/12/2004</td>
                    <td>240000</td>
                    <td>43/32 Khu phố 7 Vũng Tàu</td>
                    <td>Đang giao hàng</td>

                </tr>
                <tr>
                    <th scope="row">1</th>
                    <td>Trần Thị B</td>
                    <td>31/12/2004</td>
                    <td>240000</td>
                    <td>43/32 Khu phố 7 Vũng Tàu</td>
                    <td>Đã hủy</td>

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
