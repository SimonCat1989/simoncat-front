<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html charset=UTF-8"></meta>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"></meta>
<meta name="viewport" content="width=device-width, initial-scale=1.0"></meta>
<title>光纤资源管理系统</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="lib/bootstrap-3.3.7/css/bootstrap.min.css"></link>
<link rel="stylesheet" type="text/css" href="lib/flat-ui/css/flat-ui.min.css"></link>
<link rel="stylesheet" type="text/css" href="lib/font-awesome-4.7.0/css/font-awesome.min.css"></link>
<link rel="stylesheet" type="text/css" href="lib/animate/animate.css"></link>
<link rel="stylesheet" type="text/css" href="lib/iziModal/css/iziModal.min.css"></link>
<link rel="stylesheet" type="text/css" href="css/left_side_menu.css"></link>
<link rel="stylesheet" type="text/css" href="css/work_sheets.css"></link>
<link rel="stylesheet" type="text/css" href="css/navi.css"></link>
<link rel="stylesheet" type="text/css" href="css/main.css"></link>

<script src="lib/jquery-3.1.1/jquery-3.1.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="lib/jsrender/jsrender.js"></script>
<script src="lib/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="lib/iziModal/js/iziModal.min.js"></script>
<script src="js/main.js"></script>
</head>
<body>
  <div id="wrapper">
    <div class="overlay"></div>

    <!-- Sidebar -->
    <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
      <li class="sidebar-brand"><a href="#">目录</a></li>
      <li><a href="#"> <i class="fa fa-fw fa-list-alt"></i> 工作单管理
      </a></li>

      <!-- <li class="dropdown"><a href="#" class="dropdown-toggle"
        data-toggle="dropdown"> <i class="fa fa-fw fa-plus"></i>
          Dropdown <span class="caret"></span>
      </a>
        <ul class="dropdown-menu" role="menu">
          <li class="dropdown-header">Dropdown heading</li>
          <li><a href="#">Action</a></li>
          <li><a href="#">Another action</a></li>
          <li><a href="#">Something else here</a></li>
          <li><a href="#">Separated link</a></li>
          <li><a href="#">One more separated link</a></li>
        </ul></li> -->
    </ul>
    </nav>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
      <div class="navi">
        <button type="button" class="hamburger is-closed animated fadeInLeft"
          data-toggle="offcanvas">
          <span class="hamb-top"></span> <span class="hamb-middle"></span> <span class="hamb-bottom"></span>
        </button>
        <div class="logo">
          <img alt="logo" src="images/logo1.jpg">
        </div>
        <div class="user">
          <img alt="user" src="images/user.png">
          <div class="user_info">
            <div class="user_name">刘琳颖</div>
            <div class="user_office">国家电网信息通信公司</div>
          </div>
        </div>
      </div>
      <div class="container">
        <div id="work_tickets" class="row">
          <div id="work_tickets_tab">
            <ul class="work_tickets_ul">
              <li class="work_tickets_li"><a href="" class="work_tickets_a"
                name="work_tickets_pending"><i class="work_tickets_icon fa fa-eye"></i>审核中</a></li>
              <li class="work_tickets_li"><a href="" class="work_tickets_a"
                name="work_tickets_working"><i class="work_tickets_icon fa fa-tasks"></i>工作中</a></li>
              <li class="work_tickets_li"><a href="" class="work_tickets_a"
                name="work_tickets_submitting"><i class="work_tickets_icon fa fa-laptop"></i>待提交</a></li>
              <li class="work_tickets_li"><a href="" class="work_tickets_a"
                name="work_tickets_submitted"><i class="work_tickets_icon fa fa-archive"></i>已完成</a></li>
            </ul>
          </div>
          <div class="work_tickets_content">
            <div id="work_tickets_pending" class="work_tickets_container">
              <h2 class="header">光缆资源信息库管理系统 > 工作单管理 > 审核中</h2>
              <div id="work_tickets_pending_container" class="work_tickets_grid_container"></div>
            </div>
            <div id="work_tickets_working" class="work_tickets_container">
              <h2 class="header">光缆资源信息库管理系统 > 工作单管理 > 工作中</h2>
              <div id="work_tickets_working_container" class="work_tickets_grid_container"></div>
            </div>
            <div id="work_tickets_submitting" class="work_tickets_container">
              <h2 class="header">光缆资源信息库管理系统 > 工作单管理 > 待提交</h2>
              <div id="work_tickets_submitting_container" class="work_tickets_grid_container"></div>
            </div>
            <div id="work_tickets_submitted" class="work_tickets_container">
              <h2 class="header">光缆资源信息库管理系统 > 工作单管理 > 已完成</h2>
              <div id="work_tickets_submitted_container" class="work_tickets_grid_container"></div>
            </div>
          </div>
        </div>
        <div class="work_tickets_float_menu">
          <div class="work_tickets_float_menu_plus">
            <div class="work_tickets_float_menu_cross"></div>
          </div>
          <div class="work_tickets_float_menu_list">
            <a href="#" class="link-home"><span>接入单</span></a> <a href="#" class="link-my"><span>退出单</span></a>
            <a href="#" class="link-cart"><span>更多</span></a>
          </div>
        </div>
      </div>
    </div>
    <!-- /#page-content-wrapper -->
    <div id="work_sheet_detail_station_card_new_dialog" class="iziModal work_tickets_detail"></div>
    <div id="work_sheet_detail_station_card_dialog" class="iziModal work_tickets_detail"></div>
  </div>
  <!-- /#wrapper -->

  <%@include file="templates/work_sheet_card.jsp"%>
  <%@include file="templates/work_sheet_detail_station_card_new.jsp"%>
  <%@include file="templates/work_sheet_detail_station_card.jsp"%>
  <%@include file="templates/work_sheet_detail_station_list_card.jsp"%>
  <%@include file="templates/work_sheet_search_results_card.jsp"%>
</body>
</html>