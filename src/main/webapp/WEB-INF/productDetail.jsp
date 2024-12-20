<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/20/2024
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi Tiết Sản Phẩm</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="../css/header.css">
    <link rel="stylesheet" href="../css/footer.css">
    <link rel="stylesheet" href="../css/ProductDetail.css">
</head>
<body>

<!-- Header -->
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
        <a href="home.html"><h1>Trang chủ</h1></a>
        <div class="menu">
            <div class="dropdown">
                <a href="danhmucsp.html">Danh mục sản phẩm</a>
                <div class="dropdown-content">
                    <a href="#">Thắt lưng nam</a>
                    <a href="#">Thắt lưng nữ</a>
                </div>
            </div>
            <a href="#">Giới thiệu</a>
            <a href="#">Chính sách</a>
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
<script src="../fullscreensearch.js"></script>

<!-- Product Detail Section -->
<div class="product-detail">
    <!-- Ảnh Sản Phẩm -->
    <div class="product-image">
        <img src="../asset/image/belt1.png" alt="Thắt Lưng Da">
    </div>

    <!-- Thông Tin Sản Phẩm -->
    <div class="product-info">
        <h2>Thắt Lưng Da Cổ Điển</h2>
        <div class="product-rating">
            <span class="rating-stars">5.0 <i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i></span>
            <span class="rating-details">498 đánh giá • 1,1k đã bán</span>
        </div>
        <p class="price">200,000 VND</p>
        <!-- Chọn màu sắc -->
        <div class="color-options">
            <p>Màu Sắc:</p>
            <div class="color-choice">
                <label>
                    <input type="radio" name="color" value="denbac">
                    <img src="../asset/image/belt1.png" alt="Đen bạc"> Đen bạc
                </label>
            </div>
        </div>

        <!-- Điều chỉnh số lượng -->
        <div class="quantity-options">
            <p>Số Lượng:</p>
            <div class="quantity-control">
                <button type="button" class="quantity-decrease">-</button>
                <input type="text" value="1" class="quantity-input">
                <button type="button" class="quantity-increase">+</button>
                <span class="available-stock">148 sản phẩm có sẵn</span>
            </div>
        </div>
        <div class="action-buttons">
            <button class="add-to-cart">Thêm Vào Giỏ Hàng</button>
            <button class="buy-now">Mua Ngay</button>
        </div>
        <p class="description">
            Thắt lưng làm từ da thật, thiết kế cổ điển, phù hợp với mọi lứa tuổi và phong cách. Độ bền cao, không bong tróc, mang đến vẻ ngoài sang trọng.
        </p>
    </div>
</div>
<div class="reviews-section">
    <h3>ĐÁNH GIÁ SẢN PHẨM</h3>
    <div class="reviews-summary">
        <div class="average-rating">
            <span class="rating-score">5.0</span>
            <span class="rating-text">trên 5</span>
            <div class="stars">★★★★★</div>
        </div>
        <div class="rating-filters">
            <button class="filter-btn active">Tất Cả</button>
            <button class="filter-btn">5 Sao (497)</button>
            <button class="filter-btn">4 Sao (1)</button>
            <button class="filter-btn">3 Sao (0)</button>
            <button class="filter-btn">2 Sao (0)</button>
            <button class="filter-btn">1 Sao (0)</button>
            <button class="filter-btn">Có Bình Luận (43)</button>
            <button class="filter-btn">Có Hình Ảnh / Video (6)</button>
        </div>
    </div>
    <div class="review-item">
        <div class="review-header">
            <img src="../asset/image/user.jpg" alt="User Avatar" class="user-avatar">
            <div class="review-info">
                <span class="username">thuongde_1578</span>
                <span class="review-stars">★★★★★</span>
                <span class="review-date">2024-04-04 17:53</span>
                <span class="review-category">| Phân loại hàng: Đen bạc</span>
            </div>
        </div>
        <div class="review-content">
            <p>Chất liệu: da</p>
            <p>Đúng với mô tả: đen bạc</p>
            <p>Màu sắc: đen</p>
            <p>Rất đẹp  ... ưng ... sẽ mua ủng hộ tiếp...</p>
            <img src="../asset/image/belt1.png" alt="Review Image" class="review-image">
        </div>
    </div>
</div>


<!-- Footer -->
<footer class="footer">
    <div class="footer-brand">
        <p>CHUYÊN CUNG CẤP CÁC LOẠI THẮT LƯNG.</p>
        <p>   Chất lượng - Uy tín - Tin cậy</p>
        <div class="social-icons">
            <a href="https://www.facebook.com" target="_blank">
                <img src="../asset/image/icons8-facebook-48.png" alt="Facebook">
                <a href="https://www.instagram.com" target="_blank">
                    <img src="../asset/image/logoInsta.png" alt="Instagram">
                </a>
                <a href="https://www.youtube.com" target="_blank">
                    <img src="../asset/image/logoytb.jpg" alt="YouTube">
                </a>
                <a href="https://www.twitter.com" target="_blank">
                    <img src="../asset/image/twitter.jpg" alt="Twitter">

        </div>
    </div>
    <div class="footer-container">
        <!-- Logo và mạng xã hội -->

        <div class="footer-brand">
            <img src="../asset/image/logoSaleNoti.png" alt="Logo" class="footer-logo">
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
    // Lấy các phần tử trong DOM
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
