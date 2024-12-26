<%--
  Created by IntelliJ IDEA.
  User: BAO ANH
  Date: 12/20/2024
  Time: 3:36 PM
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

  <!--    <link href="../asset/css/bootstrap.css" rel="stylesheet"/>-->
  <!--    <link href="../asset/css/font-awesome.css" rel="stylesheet"/>-->
  <!--    <link href="../asset/css/custom.css" rel="stylesheet"/>-->
  <!--    <link rel="stylesheet" href="../asset/css/style.css">-->
  <!--    <link rel="stylesheet" href="../asset/fontawsome/fontawsome/css/all.css">-->
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <style><%@include file="../asset/css/style.css"%></style>
  <style><%@include file="/View/asset/css/custom.css"%></style>
  <style><%@include file="/View/asset/css/bootstrap.css"%></style>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
</head>


<body>
<div class="modal js-modal">

  <form class="form__content" action="" method="POST">
    <div class="form__title">
      <button class="js-modal-close">Đóng</button>
      <h3  >Chỉnh sửa thông tin Sản Phẩm</h3>

    </div>
    <label for="email">Sản phẩm</label>
    <div class="form__item">
      <input type="email" id="email" name="email" required placeholder="Email"><br>
    </div>
    <label for="email">Tên sản phẩm</label>
    <div class="form__item">
      <input type="email" id="name" name="email" required ><br>
    </div>
    <label for="matkhau">Mô tả</label>
    <div class="form__item">

      <input type="text" id="matkhau" name="pass" required><br>
    </div>
    <label for="phone">Giá bán</label>
    <div class="form__item">

      <input type="text" id="phone" name="phone" required><br>
    </div>
    <div class="commit">
      <button>Xác nhận</button>
    </div>
  </form>
</div>
<div id="wrapper">
  <div class="navbar navbar-inverse navbar-fixed-top">
    <div class="adjust-nav">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">
          Trang chủ
        </a>
      </div>

      <span class="logout-spn">
                  <a href="#" style="color:#fff;">Đăng xuất</a>

                </span>
    </div>
  </div>

  <nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
      <ul class="nav" id="main-menu">


        <li>
          <a href="admin_Disboard.html"><i class="fa fa-desktop "></i>Dashboard</a>
        </li>


        <li>
          <a href="admin_user.html"><i class="fa fa-table "></i>USER<span class="badge"></span></a>
        </li>
        <li class="active-link">
          <a href="admin_Products.html"><i class="fa fa-edit "></i>PRODUCT</a>
        </li>
        <li>
          <a href="admin_Orders.html"><i class="fa fa-qrcode "></i>ORDERS</a>
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

  <div id="page-wrapper">
    <div id="page-inner">
      <div class="row">
        <div class="col-md-12">
          <h2>SẢN PHẨM</h2>
        </div>
      </div>
      <!-- /. ROW  -->
      <label>
        <input  style="width: 500px" class="search__input" type="text" name= "" placeholder="Nhập tên sản phẩm ">
      </label>

      <button class="search__submit">
        <i class="fa-solid fa-magnifying-glass"></i>
        <span>Tìm kiếm</span>
      </button>
      <table class="table table-striped">
        <thead style="background:#a6e1ec">

        <tr>
          <th scope="col">Mã Sản Phẩm</th>
          <th scope="col">Tên Sản Phẩm</th>
          <th scope="col">Hình Ảnh</th>
          <th scope="col">Mô tả</th>
          <th scope="col">Giá bán</th>
          <th scope="col">Thao tác</th>

        </tr>
        </thead>
        <tbody>
        <tr>
          <th scope="row">1</th>
          <td></td>
          <td><img src="../asset/image/chatlieuda.jpg" alt="" class="responsive-hinhAnh"></td>
          <td>Rất đẹp</td>
          <td>50000usd</td>
          <td>
            <button class="btn js-edit"><i class="fa-solid fa-pen-to-square fa_in_admin"></i></button>
            <button class="btn js-edit"><i class="fa-solid fa-trash fa_in_admin"></i></button>
          </td>
        </tr>
        <tr>
          <th scope="row">1</th>
          <td></td>
          <td><img src="../asset/image/chatlieuda.jpg" alt="" class="responsive-hinhAnh"></td>
          <td>Rất đẹp</td>
          <td>50000usd</td>
          <td>
            <button class="btn js-edit"><i class="fa-solid fa-pen-to-square fa_in_admin"></i></button>
            <button class="btn js-edit"><i class="fa-solid fa-trash fa_in_admin"></i></button>
          </td>
        </tr><tr>
          <th scope="row">1</th>
          <td></td>
          <td><img src="../asset/image/chatlieuda.jpg" alt="" class="responsive-hinhAnh"></td>
          <td>Rất đẹp</td>
          <td>50000usd</td>
          <td>
            <button class="btn js-edit"><i class="fa-solid fa-pen-to-square fa_in_admin"></i></button>
            <button class="btn js-edit"><i class="fa-solid fa-trash fa_in_admin"></i></button>
          </td>
        </tr>
        </tbody>
      </table>

      <!-- /. ROW  -->
    </div>
    <!-- /. PAGE INNER  -->
  </div>

</div>

<script>
  const editBtns = document.querySelectorAll('.js-edit')
  const modal = document.querySelector('.js-modal')
  const  modalClose = document.querySelector('.js-modal-close')

  function showForm() {
    modal.classList.add('open')
  }
  function hideForm(){
    modal.remove('open')
  }
  for(const editBtn of editBtns){
    editBtn.addEventListener('click',showForm )
  }
  modalClose.addEventListener('click', hideForm)
</script>
</body>
</html>