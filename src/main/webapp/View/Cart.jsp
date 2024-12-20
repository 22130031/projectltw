<%--
  Created by IntelliJ IDEA.
  User: BAO ANH
  Date: 12/20/2024
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <title>Shopping Cart</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<%--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">--%>
<%--  <link rel="stylesheet" href="asset/css/bootstrap.css">--%>
<%--  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">--%>
<%--  <link rel="stylesheet" href="asset/css/style.css">--%>
<%--  <link rel="stylesheet" href="header.css">--%>
<%--  <link rel="stylesheet" href="asset/fontawsome/fontawsome/css/all.css">--%>
<%--  <link rel="stylesheet" href="footer.css">--%>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <style><%@include file="/View/asset/css/style.css"%></style>
  <style><%@include file="/View/asset/css/bootstrap.css"%></style>
  <style><%@include file="/View/header.css"%></style>
  <style><%@include file="/View/footer.css"%></style>
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

</head>
<body>
<header>
  <div id="fullscreen-search" class="fullscreen-search">
    <span class="close-btn">&times;</span>
    <div class="search-container">
      <div class="search-box">
        <input type="text" class="search-input" placeholder="Search..">
        <button class="search-icon">
          <i class="fa-solid fa-magnifying-glass"></i>
        </button>
      </div>
    </div>
  </div>
  <div class="header">
    <a href="home.jsp"><h1>Trang chủ</h1></a>
    <div class="menu">
      <div class="dropdown">
        <a href="danhmucsp.html">Danh mục sản phẩm</a>
        <div class="dropdown-content">
          <a href="#">Thắt lưng nam</a>
          <a href="#">Thắt lưng nữ</a>
        </div>
      </div>
      <a href="#">Giới thiệu</a>
      <a href="#">Chính sách </a>
      <a href="#">Liên hệ</a>
    </div>
    <div class="icons">
      <a href="#" id="open-search"><i class="fa-solid fa-magnifying-glass"></i></a>
      <div class="dropdown-user">
        <a href="profile.html"><i class="fa-solid fa-user"></i></a>
        <div class="dropdown-content-user">
          <a href="Login.html">Đăng nhập</a>
        </div>
      </div>
      <a href="Cart.html"><i class="fa-solid fa-cart-shopping"></i></a>
    </div>
  </div>
</header>
<script src="fullscreensearch.js"></script>
<!--CONTAINER CART-->
<main class="page">
  <section class="shopping-cart dark">
    <div class="container">
      <div class="block-heading">
        <h2>Giỏ Hàng</h2>

      </div>
      <div class="content">
        <div class="row">
          <div class="col-md-12 col-lg-8">
            <div class="items">
              <div class="product">
                <div class="row">
                  <div class="col-md-3">
                    <img class="img-fluid mx-auto d-block image fix_img_inCart"
                         src="asset/image/that-lung-nam-zuciani-HZ17-den_600x.jpg" alt="">
                  </div>
                  <div class="col-md-8">
                    <div class="info">
                      <div class="row">
                        <div class="col-md-5 product-name">
                          <div class="product-name">
                            <a href="#">Dây lưng - BELT232623</a>
                            <div class="product-info">
                              <div>Mã SP: <span class="value">BELT232623</span></div>
                              <div>Màu sắc : <span class="value">Màu đen</span></div>

                            </div>
                          </div>
                        </div>
                        <div class="col-md-4 quantity">
                          <p class="quantity">Số lượng</p>
                          <div class="quantity-control">
                            <button type="button" class="quantity-decrease">-</button>
                            <input type="text" value="1" class="quantity-input">
                            <button type="button" class="quantity-increase">+</button>
                            <span class="available-stock">148 sản phẩm có sẵn</span>
                          </div>

                        </div>
                        <div class="col-md-2 price">
                          <span>1,237,000₫</span>
                        </div>
                        <div class="col-md-1 price" style="left: 51px">
                          <a href=""><i class="fa-solid fa-x" style="color: red"></i></a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="row">
                  <div class="col-md-3">
                    <img class="img-fluid mx-auto d-block image fix_img_inCart"
                         src="asset/image/that-lung-da-nam-cong-so-lg22-mau-nau-1.jpg" alt="">
                  </div>
                  <div class="col-md-8">
                    <div class="info">
                      <div class="row">
                        <div class="col-md-5 product-name">
                          <div class="product-name">
                            <a href="#">Dây lưng - BELT232623</a>
                            <div class="product-info">
                              <div>Mã SP: <span class="value">BELT232623</span></div>
                              <div>Màu sắc : <span class="value">Màu đen</span></div>

                            </div>
                          </div>
                        </div>
                        <div class="col-md-4 quantity">
                          <p class="quantity">Số lượng</p>
                          <div class="quantity-control">
                            <button type="button" class="quantity-decrease">-</button>
                            <input type="text" value="1" class="quantity-input">
                            <button type="button" class="quantity-increase">+</button>
                            <span class="available-stock">148 sản phẩm có sẵn</span>
                          </div>
                        </div>
                        <div class="col-md-2 price">
                          <span>1,237,000₫</span>
                        </div>
                        <div class="col-md-1 price" style="left: 51px">
                          <a href=""><i class="fa-solid fa-x" style="color: red"></i></a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="product">
                <div class="row">
                  <div class="col-md-3 fix_cart">

                    <img alt="" class="img-fluid mx-auto d-block image fix_img_inCart "
                         src="asset/image/OIP.jpg" width="474">
                  </div>
                  <div class="col-md-8">
                    <div class="info">
                      <div class="row">
                        <div class="col-md-5 product-name">
                          <div class="product-name">
                            <a href="#">Dây lưng - BELT232623</a>
                            <div class="product-info">
                              <div>Mã SP: <span class="value">BELT232623</span></div>
                              <div>Màu sắc : <span class="value">Màu đen</span></div>

                            </div>
                          </div>
                        </div>
                        <div class="col-md-4 quantity">
                          <p class="quantity">Số lượng</p>
                          <div class="quantity-control">
                            <button type="button" class="quantity-decrease">-</button>
                            <input type="text" value="1" class="quantity-input">
                            <button type="button" class="quantity-increase">+</button>
                            <span class="available-stock">148 sản phẩm có sẵn</span>
                          </div>
                        </div>
                        <div class="col-md-2 price">
                          <span>1,237,000₫</span>
                        </div>
                        <div class="col-md-1 price" style="left: 51px">
                          <a href=""><i class="fa-solid fa-x" style="color: red"></i></a>
                        </div>
                      </div>
                    </div>
                  </div>

                </div>
              </div>

            </div>
          </div>
          <div class="col-md-12 col-lg-4">
            <div class="summary">
              <h3>Thông tin đơn hàng</h3>

              <div class="summary-item"><span class="text">Giảm giá</span><span class="price">0 ₫</span>
              </div>
              <div class="summary-item"><span class="text">Chi phí vận chuyển</span><span class="price">0 ₫</span>
              </div>
              <div class="summary-item"><span class="text">Tổng cộng </span><span class="price">111123210 ₫</span>
              </div>
              <a href="thanhtoan.html">
                <button type="button" class="btn btn-primary btn-lg btn-block">Xác nhận</button>
              </a>
              <p class="text phivan">Phí vận chuyển sẽ được tính ở trang thanh toán.</p>
              Để nhận tư vấn hoặc hỗ trợ khi phát sinh khó khăn trong lúc mua hàng, hãy liên hệ Biti's
              thông qua:
              <div>
                <ul class="help">
                  <li class="help_li">Gọi 0966.158.666 (cho Việt Nam)
                  </li>
                  <li class="help_li">chamsocKH@gmail.com.vn</li>
                </ul>
              </div>


            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</main>
<!-- Footer -->
<footer class="footer">
  <div class="footer-brand">
    <p>CHUYÊN CUNG CẤP CÁC LOẠI THẮT LƯNG.</p>
    <p> Chất lượng - Uy tín - Tin cậy</p>
    <div class="social-icons">
      <a href="https://www.facebook.com" target="_blank">
        <img src="asset/image/icons8-facebook-48.png" alt="Facebook">
        <a href="https://www.instagram.com" target="_blank">
          <img src="asset/image/logoInsta.png" alt="Instagram">
        </a>
        <a href="https://www.youtube.com" target="_blank">
          <img src="asset/image/logoytb.jpg" alt="YouTube">
        </a>
        <a href="https://www.twitter.com" target="_blank">
          <img src="asset/image/twitter.jpg" alt="Twitter">
        </a>
      </a>
    </div>
  </div>
  <div class="footer-container">
    <!-- Logo và mạng xã hội -->

    <div class="footer-brand">
      <img src="asset/image/logoSaleNoti.png" alt="Logo" class="footer-logo">
      <p>Chất lượng - Uy tín - Tin cậy</p>
      <div class="social-icons">
        <i class="fa-brands fa-facebook"></i>
        <i class="fa-brands fa-instagram"></i>
        <i class="fa-solid fa-phone"></i>
        <i class="fa-brands fa-youtube"></i>
      </div>
    </div>

    <!-- Danh sách liên kết -->
    <div class="footer-links">
      <div>
        <h3>Sản phẩm</h3>
        <ul>
          <li><a href="#">Thắt lưng nam</a></li>
          <li><a href="#">Thắt lưng nữ</a></li>
          <li><a href="#">Phụ kiện</a></li>
          <li><a href="#">Khuyến mãi</a></li>
        </ul>
      </div>
      <div>
        <h3>Chính sách</h3>
        <ul>
          <li><a href="#">Chính sách đổi trả</a></li>
          <li><a href="#">Chính sách bảo mật</a></li>
          <li><a href="#">Chính sách vận chuyển</a></li>
          <li><a href="#">Hướng dẫn thanh toán</a></li>
        </ul>
      </div>
      <div>
        <h3>Hỗ trợ</h3>
        <ul>
          <li><a href="#">Liên hệ</a></li>
          <li><a href="#">Hỗ trợ</a></li>
          <li><a href="#">Tuyển dụng</a></li>
        </ul>
      </div>
    </div>

    <!-- Thông tin công ty -->
    <div class="footer-contact">
      <h3>Liên hệ</h3>
      <p>Địa chỉ: Số 8, Tam Bình, Thủ Đức</p>
      <p>Điện thoại: 0397526965</p>
      <p>Email: storethatlung@gmail.com</p>
      <p>Thời gian làm việc: 8:00 - 22:00 (hàng ngày)</p>
    </div>
  </div>
  <div class="footer-bottom">
    <p>&copy; 2024 Chuyên cung cấp thắt lưng các loại. Hotline: <a href="tel:0397526965">0397526965</a></p>
  </div>
</footer>
<script>
  const decreaseButton = document.querySelector('.quantity-decrease');
  const increaseButton = document.querySelector('.quantity-increase');
  const quantityInput = document.querySelector('.quantity-input');
  const maxStock = 148; // Số lượng sản phẩm tối đa có sẵn

  // Xử lý khi bấm nút giảm số lượng
  decreaseButton.addEventListener('click', () => {
    let currentQuantity = parseInt(quantityInput.value, 10); // Lấy giá trị hiện tại
    if (currentQuantity > 1) {
      quantityInput.value = currentQuantity - 1; // Giảm 1 nếu lớn hơn 1
    }
  });

  // Xử lý khi bấm nút tăng số lượng
  increaseButton.addEventListener('click', () => {
    let currentQuantity = parseInt(quantityInput.value, 10); // Lấy giá trị hiện tại
    if (currentQuantity < maxStock) {
      quantityInput.value = currentQuantity + 1; // Tăng 1 nếu chưa đạt tối đa
    }
  });

  // Đảm bảo người dùng chỉ nhập số hợp lệ
  quantityInput.addEventListener('input', () => {
    let currentValue = parseInt(quantityInput.value, 10);

    // Nếu nhập sai hoặc nhỏ hơn 1, tự động đặt về 1
    if (isNaN(currentValue) || currentValue < 1) {
      quantityInput.value = 1;
    }

    // Nếu vượt quá số lượng tối đa, đặt về số lượng tối đa
    if (currentValue > maxStock) {
      quantityInput.value = maxStock;
    }
  });
</script>
</body>


</html>
