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
<link rel="stylesheet" href="assets/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<link rel="shortcut icon" href="images/icon.ico" />
</head>
<body>
  <div id="content">
    <div class="inner">
      <article class="box post post-excerpt">
        <header>
          <h2>${essay.getTitle()}</h2>
          <p>
            <img src="${essay.getAuthorAvatar()}" />${essay.getAuthor()}
          </p>
        </header>
        <div class="info">
          <span class="date"><span class="month">${essay.getCreateMonth()}<span>${essay.getCreateMonthSuffix()}</span></span> <span class="day">${essay.getCreateDay()}</span><span
            class="year">, ${essay.getCreateYear()}</span></span>
          <ul class="stats">
            <li><a href="#" class="icon fa-comment">${essay.getComment()}</a></li>
            <li><a href="#" class="icon fa-heart">${essay.getHeart()}</a></li>
            <li><a href="#" class="icon fa-twitter">${essay.getTwitter()}</a></li>
            <li><a href="#" class="icon fa-facebook">${essay.getFacebook()}</a></li>
          </ul>
        </div>
        <p>
          <strong>${essay.getKeyword()}</strong> ${essay.getDescription()}
        </p>
        <c:forEach items="${essay.getEssayComments()}" var="data" varStatus="index">
          <div style="padding: .5em; border: 1px solid #CBCBCB; margin-bottom: 10px;">
            <table style="margin: 0;">
              <tr>
                <td style="width: 20%; vertical-align: top;"><img alt="" src="${data.getBookCover()}" style="width: 90%;"></td>
                <td style="width: 80%;">
                  <div style="text-decoration: none; color: #666; font-size: 30px; margin: 0px 0 10px -10px; line-height: 1; font-weight: bold;">《${data.getBookName()}》</div>
                  <div style="font-style: italic;">
                    <i class="icon fa-copyright" style="margin-right: 2px;"></i>${data.getBookAuthor()}</div>
                  <div style="margin-top: 10px;">${data.getBookDescription()}</div>
                  <div style="margin-top: 10px;">${data.getComment()}</div>
                </td>
              </tr>
            </table>
          </div>
        </c:forEach>
      </article>
    </div>
  </div>

  <%@include file="side_menu.jsp"%>

  <!-- Scripts -->
  <script src="assets/js/jquery.min.js"></script>
  <script src="assets/js/skel.min.js"></script>
  <script src="assets/js/util.js"></script>
  <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
  <script src="assets/js/main.js"></script>

</body>
</html>