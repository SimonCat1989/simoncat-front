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
              <c:forEach items="${essays.getBooks()}" var="book">
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
          <!-- <a href="content.do?contentId=${data.getContentId()}" target="view_window"
            class="image featured"><img src="${data.getImage()}" alt="" /></a> -->
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
        <a href="#" class="button next">下一页</a>
      </div>
    </div>
  </div>

  <div id="sidebar">

    <!-- Logo -->
    <h1 id="logo">
      <a href="#">赛门猫一番</a>
    </h1>

    <!-- Nav -->
    <nav id="nav">
      <ul>
        <li class="current"><a href="recommendation.do">新鲜速递</a></li>
        <li><a href="recommendation.do">火爆热门</a></li>
        <li><a href="recommendation.do">分类排行</a></li>
        <li><a href="recommendation.do">随便看看</a></li>
      </ul>
    </nav>

    <!-- Search -->
    <section class="box search">
      <form method="post" action="#">
        <input type="text" class="text" name="search" placeholder="站内搜索" />
      </form>
    </section>

    <!-- Text -->
    <section class="box text-style1">
      <div class="inner">
        <p>
          <strong>赛门猫一番：</strong>爱生活，爱小说，爱分享。
        </p>
      </div>
    </section>

    <!-- Recent Posts
    <section class="box recent-posts"> <header>
    <h2>最近阅读</h2>
    </header>
    <ul>
      <li><a href="#">欢迎来到赛门猫一番</a></li>
      <li><a href="#">人生感慨</a></li>
    </ul>
    </section> -->

    <!-- Recent Comments
    <section class="box recent-comments"> <header>
    <h2>最近评论</h2>
    </header>
    <ul>
      <li>评论 <a href="#">欢迎来到赛门猫一番</a></li>
      <li>评论 <a href="#">人生感慨</a></li>
      <li>评论 <a href="#">欢迎来到赛门猫一番</a></li>
    </ul>
    </section> -->

    <!-- Calendar -->
    <section class="box calendar">
      <div class="inner">
        <table>
          <caption>May 2018</caption>
          <thead>
            <tr>
              <th scope="col" title="Monday">M</th>
              <th scope="col" title="Tuesday">T</th>
              <th scope="col" title="Wednesday">W</th>
              <th scope="col" title="Thursday">T</th>
              <th scope="col" title="Friday">F</th>
              <th scope="col" title="Saturday">S</th>
              <th scope="col" title="Sunday">S</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td colspan="4" class="pad"><span>&nbsp;</span></td>
              <td><span>1</span></td>
              <td><span>2</span></td>
              <td><span>3</span></td>
            </tr>
            <tr>
              <td><span>4</span></td>
              <td><span>5</span></td>
              <td><a href="#">6</a></td>
              <td><span>7</span></td>
              <td><span>8</span></td>
              <td><span>9</span></td>
              <td><a href="#">10</a></td>
            </tr>
            <tr>
              <td><span>11</span></td>
              <td><span>12</span></td>
              <td><span>13</span></td>
              <td class="today"><a href="#">14</a></td>
              <td><span>15</span></td>
              <td><span>16</span></td>
              <td><span>17</span></td>
            </tr>
            <tr>
              <td><span>18</span></td>
              <td><span>19</span></td>
              <td><span>20</span></td>
              <td><span>21</span></td>
              <td><span>22</span></td>
              <td><a href="#">23</a></td>
              <td><span>24</span></td>
            </tr>
            <tr>
              <td><a href="#">25</a></td>
              <td><span>26</span></td>
              <td><span>27</span></td>
              <td><span>28</span></td>
              <td class="pad" colspan="3"><span>&nbsp;</span></td>
            </tr>
          </tbody>
        </table>
      </div>
    </section>

    <!-- Copyright -->
    <ul id="copyright">
      <li>&copy; SimonCat.</li>
      <li>Design: <a href="#">SimonCat</a></li>
    </ul>

  </div>

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