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
    <!-- Search Bar End -->
    <!-- Contact Section Begin -->
    <section class="contact-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="contact-info">
                        <div class="contact-form">
                           <form method="post" action="${pageContext.request.contextPath}/review/addReview"
                                       enctype="multipart/form-data">
                                <div class="row">
                                <div class="container" style="margin-top: 100px;">
                                   <div class="col-lg-12">
                                      <input type="hidden" name="customerNo" value="${customerNo}">
                                        <input type="text" placeholder="reviewTitle" name="reviewTitle" >
                                       <label>&nbsp;프로그램</label>
                                       <select name="programRsNo" class="form-control">
                                           <c:forEach var="item" items="${programRsNoList}">
                                           <option value="${item.programRsNo}">${item.programName}</option>
                                           </c:forEach>
                                       </select>
                                       <br>
                                       <textarea placeholder="Message" name = "reviewContent"></textarea>
                                        <button type="submit" class="site-btn">작성하기</button>
                                 
                      </form>
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