<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">
<head>
   <meta charset="UTF-8">
    <meta name="description" content="TopGym Template">
    <meta name="keywords" content="TopGym, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>GD HEALTH</title>
   <script>
        $(document).ready(function() {
            var msg = "${msg}";
            if (msg.trim() !== "") {
                alert(msg);
            }
        });
    </script>
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,300i,400,500,700,900" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="/css/barfiller.css" type="text/css">
    <link rel="stylesheet" href="/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>
    <jsp:include page="/WEB-INF/header/header.jsp" />
   	<section class="breadcrumb-area set-bg" data-setbg="/img/elements/element-bg.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb-content">
                        <h2>Notice</h2>
                        <div class="links">
                            <a href="/customer/home">Home</a>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Search Bar End -->
    <!-- Contact Section Begin -->
    <div class="untree_co-section before-footer-section">
            <div class="container">
             <div class="p-3 p-lg-5 border bg-white">
             <h1 class="mb-4 section-title">Notice</h1>
             <br>
				<table class ="table">
 		<tr>
            <th>공지번호</th>
            <td><p style="border: none;">${notiOne.noticeNo}</p></td>
        </tr>
    
        <tr>
            <th>제목</th>
            <td><p style="border: none;">${notiOne.noticeTitle}</td>
        </tr>
        <tr>
    		<th>공지사항</th>
    		<td><textarea rows="6" cols="130" style="border: none;" readonly>${notiOne.noticeContent}</textarea></td>
		</tr>
        <tr>
            <th>게시일</th>
            <td><p style="border: none;">${notiOne.createdate}</td>
        </tr>
        <tr>
            <th>수정일</th>
            <td><p style="border: none;">${notiOne.updatedate}</td>
        </tr>
        
    </table>
     <a>
     <c:choose>
     <c:when test="${branchLevel == 1}">
        <a href="${pageContext.request.contextPath}/notice/updateNotice?noticeNo=${notiOne.noticeNo}" class="btn btn-primary">수정</a>
        <a href="${pageContext.request.contextPath}/notice/deleteNotice?noticeNo=${notiOne.noticeNo}" class="btn btn-danger">삭제</a>
    </c:when>
    </c:choose>
    </a>
</div>
</div>
</div>

     
    
    <!-- Contact Section End -->
    <!-- Footer Section Begin -->
    <footer class="footer-section set-bg" data-setbg="/img/footer-bg.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer-content">
                        <div class="footer-logo">
                            <a href="#"><img src="/img/logo.png" alt=""></a>
                        </div>
                        <div class="footer-menu">
                            <ul>
                                <li><a href="./home.html">Home</a></li>
                                <li><a href="#">About us</a></li>
                                <li><a href="#">Classes</a></li>
                                <li><a href="#">Instructors</a></li>
                                <li><a href="#">News</a></li>
                                <li><a href="#">Contact</a></li>
                            </ul>
                        </div>
                        <div class="subscribe-form">
                            <form action="#">
                                <input type="text" placeholder="your Email">
                                <button type="submit">Sign Up</button>
                            </form>
                        </div>
                        <div class="footer-icon-img">
                            <img src="/img/footer-icon.png" alt="">
                        </div>
                        <div class="copyright">
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/jquery.slicknav.js"></script>
    <script src="/js/owl.carousel.min.js"></script>
    <script src="/js/jquery.magnific-popup.min.js"></script>
    <script src="/js/circle-progress.min.js"></script>
    <script src="/js/jquery.barfiller.js"></script>
    <script src="/js/main.js"></script>
</body>

</html>