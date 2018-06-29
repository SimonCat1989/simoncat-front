<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>赛门猫一番</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" type="text/css" href="lib/owl-carousel-banner/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="lib/owl-carousel-banner/owl.carousel.min.css">
<link rel="stylesheet" type="text/css" href="lib/owl-carousel-banner/banner_style.css">
<link rel="stylesheet" href="assets/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<link rel="shortcut icon" href="images/icon.ico" />
</head>
<body>
  <div class="banner">
    <ul>
      <li><img src="images/banner-1.jpg"></li>
      <li><img src="images/banner-2.jpg"></li>
      <li><img src="images/banner-3.jpg"></li>
      <li><img src="images/banner-4.jpg"></li>
      <li><img src="images/banner-6.jpg"></li>
    </ul>
  </div>
  <div id="content">
    <div class="inner">
      <c:forEach items="${essays.getEssays()}" var="data" varStatus="index">
        <article class="box post post-excerpt">
          <header>
            <h2>
              <a href="home/essay.do?essayId=${data.getId()}" target="view_window">${data.getTitle()}</a>
            </h2>
            <p>
              <img src="${data.getAuthorAvatar()}" />${data.getAuthor()}
            </p>
          </header>
          <div class="info">
            <span class="date"><span class="month">${data.getCreateMonth()}<span>${data.getCreateMonthSuffix()}</span></span>
              <span class="day">${data.getCreateDay()}</span><span class="year">,
                ${data.getCreateYear()}</span></span>
            <ul class="stats">
              <li><a href="#" class="icon fa-comment">${data.getComment()}</a></li>
              <li><a href="#" class="icon fa-heart">${data.getHeart()}</a></li>
              <li><a href="#" class="icon fa-twitter">${data.getTwitter()}</a></li>
              <li><a href="#" class="icon fa-facebook">${data.getFacebook()}</a></li>
            </ul>
          </div>
          <div class="container">
            <div class="mhn-slide owl-carousel">
              <c:forEach items="${data.getBooks()}" var="book">
                <div class="mhn-item">
                  <div class="mhn-inner">
                    <img src="${book.getCover()}">
                    <div class="mhn-img">
                      <div class="loader-circle">
                        <div class="loader-stroke-left"></div>
                        <div class="loader-stroke-right"></div>
                      </div>
                    </div>
                    <div class="mhn-text">
                      <h4>《${book.getName()}》</h4>
                      <p>
                        <i class="icon fa-copyright" style="margin-right: 2px;"></i>${book.getAuthor()}</p>
                    </div>
                  </div>
                </div>
              </c:forEach>
            </div>
          </div>
          <p>
            <strong>${data.getKeyword()}</strong> ${data.getDescription()}
          </p>
          <p>
            <a href="home/essay.do?essayId=${data.getId()}" target="view_window"><span
              class="contentForAll">查看全文</span></a>
          </p>
        </article>
      </c:forEach>


      <div class="pagination">
        <!--<a href="#" class="button previous">Previous Page</a>-->
        <div class="pages">
          <c:forEach var="pageCount" begin="1" end="${essays.getTotalPage()}" step="1">
            <c:choose>
              <c:when test="${pageCount == essays.getCurrentPage()}">
                <a href="#" class="active">${pageCount}</a>
              </c:when>
              <c:otherwise>
                <a href="#">${pageCount}</a>
              </c:otherwise>
            </c:choose>
          </c:forEach>
        </div>
        <a href="home.do?page=${essays.getCurrentPage() + 1}" class="button next">下一页</a>
      </div>
    </div>
  </div>

  <%@include file="side_menu.jsp"%>
  
  <!-- Scripts -->
  <script src="assets/js/jquery.min.js"></script>
  <script src="assets/js/skel.min.js"></script>
  <script src="assets/js/util.js"></script>
  <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
  <script type="text/javascript" src="lib/owl-carousel-banner/owl.carousel.min.js"></script>
  <script type="text/jscript" src="lib/jquery-banner/jquery.terseBanner.min.js"></script>
  <script type="text/jscript" src="assets/js/main.js"></script>
  <script type="text/jscript" src="assets/js/banner.js"></script>
</body>
</html>