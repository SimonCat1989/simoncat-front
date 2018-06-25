<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
      <article class="box post post-excerpt"> <header>
      <h2>
        ${essay.getTitle()}
      </h2>
      <p>
        <img src="${essay.getAuthorAvatar()}" />${essay.getAuthor()}
      </p>
      </header>
      <div class="info">
        <span class="date"><span class="month">${essay.getCreateMonth()}<span>${essay.getCreateMonthSuffix()}</span></span>
          <span class="day">${essay.getCreateDay()}</span><span class="year">,
            ${essay.getCreateYear()}</span></span>
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
              <td style="width: 20%; vertical-align: top;"><img alt="" src="${data.getBookCover()}"
                style="width: 90%;"></td>
              <td style="width: 80%;">
                <div
                  style="text-decoration: none; color: #666; font-size: 30px; margin: 0px 0 10px -10px; line-height: 1; font-weight: bold;">《${data.getBookName()}》</div>
                <div style="font-style: italic;">
                  <i class="icon fa-copyright" style="margin-right: 2px;"></i>${data.getBookAuthor()}</div>
                <div style="margin-top: 10px;">${data.getComment()}</div>
              </td>
            </tr>
          </table>
        </div>
      </c:forEach> </article>
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
      <li class="current"><a href="recommendation.do">火爆热门</a></li>
      <li><a href="recommendation.do">24小时</a></li>
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
        <strong>赛门猫一番：</strong>爱生活，爱小说，小说迷聚集地。
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
  <script src="assets/js/main.js"></script>

</body>
</html>