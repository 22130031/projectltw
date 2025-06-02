<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/26/2024
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <style>
        <%@include file="../css/footer.css" %>
    </style>
    <style>
        <%@include file="../css/header.css" %>
    </style>
    <style>
        /* Form đăng nhập */
        body {
            background-color: #212121;
            color: #ffffff;
            margin: 0;
            padding: 0;
        }
        .login-container {
            display: flex;
            justify-content: space-around;
            width: 80%;
            margin: 50px auto;
            color: #ffffff;
            border-right: 2px solid #3a3a3a;
        }
        .login-container .section {
            width: 45%;
        }
        .login-container h2 {
            font-size: 24px;
            margin-bottom: 20px;
            color: #ffffff;
        }
        .login-container label {
            font-size: 14px;
            color: #b0b0b0;
        }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            background-color: #333333;
            border: 1px solid #444444;
            color: #ffffff;
        }
        .login-container input[type="text"]::placeholder,
        .login-container input[type="password"]::placeholder {
            color: #888888;
        }
        .login-container .btn {
            background-color: #000000;
            color: #ffffff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            font-weight: bold;
        }
        .login-container .btn:hover {
            background-color: #555555;
        }
        .login-container .forgot-password {
            color: #888888;
            font-size: 14px;
            text-align: right;
            display: block;
            margin-top: -10px;
            margin-bottom: 20px;
        }
        .password-strength, .password-match {
            margin-top: 5px;
            font-size: 14px;
        }
        .weak { color: red; }
        .medium { color: orange; }
        .strong { color: green; }
        .match { color: green; }
        .no-match { color: red; }
        .button-group {
            display: flex;
            align-items: center;
            gap: 10px;
        }
    </style>
    <script src="https://accounts.google.com/gsi/client" async defer></script>
</head>
<body>
<header>
    <div class="header">
        <a href="${pageContext.request.contextPath}/home"><h1>Trang chủ</h1></a>
        <div class="menu">
            <div class="dropdown">
                <a href="${pageContext.request.contextPath}/home">Danh mục sản phẩm</a>
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
            <form action="${pageContext.request.contextPath}/search" method="get">
                <div class="search-container">
                    <div class="search-box">
                        <button class="search-icon">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </button>
                        <label>
                            <input type="text" class="search-input" name="search" placeholder="Search..">
                        </label>
                    </div>
                </div>
            </form>
            <c:if test="${sessionScope.auth == null}">
                <div class="dropdown-user">
                    <a href="#"><i class="fa-solid fa-user"></i></a>
                    <div class="dropdown-content-user">
                        <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
                    </div>
                </div>
            </c:if>
            <c:if test="${sessionScope.auth != null}">
                <div class="dropdown-user">
                    <a href="${pageContext.request.contextPath}/profile.jsp">
                        <img src="${pageContext.request.contextPath}/${sessionScope.auth.image}" alt="Avatar"
                             style="width: 25px; height: 25px; border-radius: 50%;">
                    </a>
                    <div class="dropdown-content-user">
                        <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
                    </div>
                </div>
                <a href="${pageContext.request.contextPath}/Cart?action=showCart"><i class="fa-solid fa-cart-shopping"></i></a>
            </c:if>
        </div>
    </div>
</header>

<div id="container">
    <div class="login-container">
        <div class="section">
            <h2>Đăng nhập</h2>
            <c:if test="${not empty error}">
                <div class="error-message" style="color: red; margin-bottom: 10px;">
                    <p>${error}</p>
                </div>
            </c:if>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <label for="email">Tên tài khoản</label>
                <input type="text" id="email" name="uname" required>
                <label for="password">Mật khẩu</label>
                <input type="password" id="password" name="pass" required>
                <a href="${pageContext.request.contextPath}/forgot-password" class="forgot-password">Quên mật khẩu?</a>
                <div class="button-group">
                    <button type="submit" class="btn">Đăng nhập</button>
                    <div id="g_id_onload"
                         data-client_id="256201613422-cbv7rg2ljj909hogpvn1gjtc46ti3bb5.apps.googleusercontent.com"
                         data-callback="handleCredentialResponse"
                         data-auto_prompt="false">
                    </div>
                    <div class="g_id_signin" data-type="standard" data-size="large" data-theme="outline" data-text="sign_in_with" data-shape="rectangular" data-logo_alignment="left"></div>
                </div>
            </form>
        </div>
        <div class="section">
            <h2>Đăng ký</h2>
            <form action="${pageContext.request.contextPath}/register" method="post">
                <label for="first-name">Email</label>
                <input type="text" id="first-name" name="email" required>
                <label for="last-name">Tên tài khoản</label>
                <input type="text" id="last-name" name="username" required>
                <label for="register-password">Mật khẩu</label>
                <input type="password" id="register-password" name="password" required
                       onkeyup="checkPasswordStrength()">
                <div id="password-strength" class="password-strength"></div>
                <label for="confirm-password">Xác nhận mật khẩu</label>
                <input type="password" id="confirm-password" name="cpassword" required
                       onkeyup="checkPasswordMatch()">
                <div id="password-match" class="password-match"></div>
                <button type="submit" class="btn">Đăng ký</button>
            </form>
        </div>
    </div>
</div>

<script>
    function checkPasswordStrength() {
        const password = document.getElementById('register-password').value;
        const strengthDisplay = document.getElementById('password-strength');
        const minLength = password.length >= 8;
        const hasUpperCase = /[A-Z]/.test(password);
        const hasLowerCase = /[a-z]/.test(password);
        const hasNumbers = /\d/.test(password);
        const hasSpecialChar = /[!@#$%^&*(),.?":{}|<>]/.test(password);
        let strength = 0;
        if (minLength) strength++;
        if (hasUpperCase) strength++;
        if (hasLowerCase) strength++;
        if (hasNumbers) strength++;
        if (hasSpecialChar) strength++;
        if (password.length === 0) {
            strengthDisplay.textContent = '';
            strengthDisplay.className = 'password-strength';
        } else if (strength <= 2) {
            strengthDisplay.textContent = 'Mật khẩu yếu';
            strengthDisplay.className = 'password-strength weak';
        } else if (strength <= 4) {
            strengthDisplay.textContent = 'Mật khẩu trung bình';
            strengthDisplay.className = 'password-strength medium';
        } else {
            strengthDisplay.textContent = 'Mật khẩu mạnh';
            strengthDisplay.className = 'password-strength strong';
        }
        checkPasswordMatch();
    }

    function checkPasswordMatch() {
        const password = document.getElementById('register-password').value;
        const confirmPassword = document.getElementById('confirm-password').value;
        const matchDisplay = document.getElementById('password-match');
        if (confirmPassword.length === 0) {
            matchDisplay.textContent = '';
            matchDisplay.className = 'password-match';
        } else if (password === confirmPassword) {
            matchDisplay.textContent = 'Mật khẩu khớp';
            matchDisplay.className = 'password-match match';
        } else {
            matchDisplay.textContent = 'Mật khẩu không khớp';
            matchDisplay.className = 'password-match no-match';
        }
    }

    function handleCredentialResponse(response) {
        const responsePayload = decodeJwtResponse(response.credential);
        console.log("ID: " + responsePayload.sub);
        console.log("Tên: " + responsePayload.name);
        console.log("Email: " + responsePayload.email);
        console.log("Image: " + responsePayload.picture);

        fetch('${pageContext.request.contextPath}/auth/google', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ id_token: response.credential })
        })
            .then(response => {
                if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
                return response.json();
            })
            .then(data => {
                if (data.success) {
                    alert(`Đăng nhập thành công! Chào ${responsePayload.name}`);
                    window.location.href = '${pageContext.request.contextPath}/home';
                } else {
                    alert('Đăng nhập bằng Google thất bại: ' + data.message);
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Đã có lỗi xảy ra khi đăng nhập bằng Google.');
            });
    }

    function decodeJwtResponse(token) {
        const base64Url = token.split('.')[1];
        const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
        const jsonPayload = decodeURIComponent(atob(base64).split('').map(c => {
            return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
        }).join(''));
        return JSON.parse(jsonPayload);
    }
</script>

<footer class="footer">
    <div class="footer-brand">
        <p>CHUYÊN CUNG CẤP CÁC LOẠI THẮT LƯNG.</p>
        <p>Chất lượng - Uy tín - Tin cậy</p>
        <div class="social-icons">
            <a href="https://www.facebook.com" target="_blank">
                <img src="${pageContext.request.contextPath}/asset/image/icons8-facebook-48.png" alt="Facebook">
            </a>
            <a href="https://www.instagram.com" target="_blank">
                <img src="${pageContext.request.contextPath}/asset/image/logoInsta.png" alt="Instagram">
            </a>
            <a href="https://www.youtube.com" target="_blank">
                <img src="${pageContext.request.contextPath}/asset/image/logoytb.jpg" alt="YouTube">
            </a>
            <a href="https://www.twitter.com" target="_blank">
                <img src="${pageContext.request.contextPath}/asset/image/twitter.jpg" alt="Twitter">
            </a>
        </div>
    </div>
    <div class="footer-container">
        <div class="footer-brand">
            <img src="${pageContext.request.contextPath}/asset/image/logoSaleNoti.png" alt="Logo" class="footer-logo">
            <p>Chất lượng - Uy tín - Tin cậy</p>
            <div class="social-icons">
                <i class="fa-brands fa-facebook"></i>
                <i class="fa-brands fa-instagram"></i>
                <i class="fa-solid fa-phone"></i>
                <i class="fa-brands fa-youtube"></i>
            </div>
        </div>
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
        <div class="footer-contact">
            <h3>Liên hệ</h3>
            <p>Địa chỉ: Số 8, Tam Bình, Thủ Đức</p>
            <p>Điện thoại: 0397526965</p>
            <p>Email: storethatlung@gmail.com</p>
            <p>Thời gian làm việc: 8:00 - 22:00 (hàng ngày)</p>
        </div>
    </div>
    <div class="footer-bottom">
        <p>© 2025 Chuyên cung cấp thắt lưng các loại. Hotline: <a href="tel:0397526965">0397526965</a></p>
    </div>
</footer>
</body>
</html>