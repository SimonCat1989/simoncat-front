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
  <%@include file="main_banner.jsp"%>
  <div id="content">
    <div class="inner">
      <%@include file="essay_list.jsp"%>

      <div class="pagination">
        <c:if test="${essays.getCurrentPage() > 1}">
          <a href="home.do?page=${essays.getCurrentPage() - 1}" class="button previous">上一页</a>
        </c:if>
        <div class="pages">
          <c:forEach var="pageCount" begin="1" end="${essays.getTotalPage()}" step="1">
            <c:choose>
              <c:when test="${pageCount == essays.getCurrentPage()}">
                <a href="home.do?page=${pageCount}" class="active">${pageCount}</a>
              </c:when>
              <c:otherwise>
                <a href="home.do?page=${pageCount}">${pageCount}</a>
              </c:otherwise>
            </c:choose>
          </c:forEach>
        </div>
        <c:if test="${essays.getCurrentPage() < essays.getTotalPage()}">
          <a href="home.do?page=${essays.getCurrentPage() + 1}" class="button next">下一页</a>
        </c:if>
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