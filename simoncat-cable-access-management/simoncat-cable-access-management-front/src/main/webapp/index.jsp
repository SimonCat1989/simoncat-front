<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
      <li class="sidebar-brand"><a href="#"> 国家电网光纤管理 </a></li>
      <li><a href="#"> <i class="fa fa-fw fa-list-alt"></i> 工作单管理
      </a></li>
      <li><a href="#"> <i class="fa fa-fw fa-folder"></i> Page one
      </a></li>
      <li><a href="#"> <i class="fa fa-fw fa-file-o"></i> Second page
      </a></li>
      <li><a href="#"> <i class="fa fa-fw fa-cog"></i> Third page
      </a></li>
      <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> <i class="fa fa-fw fa-plus"></i> Dropdown <span class="caret"></span>
      </a>
        <ul class="dropdown-menu" role="menu">
          <li class="dropdown-header">Dropdown heading</li>
          <li><a href="#">Action</a></li>
          <li><a href="#">Another action</a></li>
          <li><a href="#">Something else here</a></li>
          <li><a href="#">Separated link</a></li>
          <li><a href="#">One more separated link</a></li>
        </ul></li>
      <li><a href="#"> <i class="fa fa-fw fa-bank"></i> Page four
      </a></li>
      <li><a href="#"> <i class="fa fa-fw fa-dropbox"></i> Page 5
      </a></li>
      <li><a href="#"> <i class="fa fa-fw fa-twitter"></i> Last page
      </a></li>
    </ul>
    </nav>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
      <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
        <span class="hamb-top"></span> <span class="hamb-middle"></span> <span class="hamb-bottom"></span>
      </button>
      <div class="container">
        <div id="work_tickets" class="row">
          <div id="work_tickets_tab">
            <ul class="work_tickets_ul">
              <li class="work_tickets_li"><a href="" class="work_tickets_a" name="work_tickets_pending"><i class="work_tickets_icon fa fa-eye"></i>审核中</a></li>
              <li class="work_tickets_li"><a href="" class="work_tickets_a" name="work_tickets_working"><i class="work_tickets_icon fa fa-tasks"></i>工作中</a></li>
              <li class="work_tickets_li"><a href="" class="work_tickets_a" name="work_tickets_submitting"><i class="work_tickets_icon fa fa-laptop"></i>待提交</a></li>
              <li class="work_tickets_li"><a href="" class="work_tickets_a" name="work_tickets_submitted"><i class="work_tickets_icon fa fa-archive"></i>已完成</a></li>
            </ul>
          </div>
          <div class="work_tickets_content">
            <div id="work_tickets_pending" class="work_tickets_container">
              <h2 class="header">审核中</h2>
              <div id="work_tickets_pending_container" class="work_tickets_grid_container"></div>
            </div>
            <div id="work_tickets_working" class="work_tickets_container">
              <h2 class="header">工作中</h2>
              <div id="work_tickets_working_container" class="work_tickets_grid_container"></div>
            </div>
            <div id="work_tickets_submitting" class="work_tickets_container">
              <h2 class="header">待提交</h2>
              <div id="work_tickets_submitting_container" class="work_tickets_grid_container"></div>
            </div>
            <div id="work_tickets_submitted" class="work_tickets_container">
              <h2 class="header">已完成</h2>
              <div id="work_tickets_submitted_container" class="work_tickets_grid_container"></div>
            </div>
          </div>
        </div>
        <div class="work_tickets_float_menu">
          <div class="work_tickets_float_menu_plus">
            <div class="work_tickets_float_menu_cross"></div>
          </div>
          <div class="work_tickets_float_menu_list">
            <a href="" class="link-home"><span>接入单</span></a> <a href="" class="link-my"><span>退出单</span></a> <a href="" class="link-cart"><span>更多</span></a>
          </div>
        </div>
      </div>
    </div>
    <!-- /#page-content-wrapper -->
    <div id="modal-default" class="iziModal work_tickets_detail">
      <div class="work_tickets_detail_container">
        <div class="work_tickets_detail_group">
          上海市电力公司话路运动<span>退出通知单</span>
        </div>
        <div class="work_tickets_detail_id">沪电调通第20160697号</div>
        <div class="work_tickets_detail_row">
          <div class="work_tickets_detail_wide">
            <div class="input-group">
              <span class="input-group-addon"><i class="fa fa-id-card-o fa-fw"></i>电路名称</span> <input class="form-control" type="text" placeholder="电路名称">
            </div>
          </div>
          <div class="work_tickets_detail_narrow">
            <div class="input-group">
              <span class="input-group-addon"><i class="fa fa-tags fa-fw"></i>用户性质</span> <input class="form-control" type="text" placeholder="用户性质">
            </div>
          </div>
        </div>
        <div class="work_tickets_detail_row">
          <div class="work_tickets_detail_wide">
            <div class="input-group">
              <span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i>要求完成时间</span> <input class="form-control" type="text" placeholder="要求完成时间">
            </div>
          </div>
          <div class="work_tickets_detail_narrow">
            <div class="input-group">
              <span class="input-group-addon"><i class="fa fa-rss fa-fw"></i>通道形式</span> <input class="form-control" type="text" placeholder="通道形式">
            </div>
          </div>
        </div>
        <div class="work_tickets_detail_separator"></div>
        <div class="work_tickets_detail_stations_container">
          <div class="work_tickets_detail_stations_list">
            <div class="work_tickets_detail_station_li work_tickets_detail_station_card">
              <img src="images/substation.png" class="work_tickets_detail_station_card_img"> <span>市区供电公司</span>
            </div>
            <div class="work_tickets_detail_station_connection_container">
              <div class="work_tickets_detail_station_connection_container_wrap">
                <div class="work_tickets_detail_station_connection_wrap">
                  <img src="images/detail_connection.png" class="work_tickets_detail_station_connection">
                </div>
                <div class="work_tickets_detail_station_connection_wrap left">
                  <img src="images/detail_connection.png" class="work_tickets_detail_station_connection left">
                </div>
              </div>
              <div class="work_tickets_detail_station_connection_status_wrap_container">
                <div class="work_tickets_detail_station_li work_tickets_detail_station_connection_status_wrap">
                  <img src="images/status_ready.png" class="work_tickets_detail_station_connection_status"> <span>市区供电公司市区供电公司市区供电公司电公司市区供电公司市区供电公司电公司市区供电公司市区供电公司市区供电公司</span>
                </div>
                <div class="work_tickets_detail_station_li work_tickets_detail_station_connection_status_wrap left">
                  <img src="images/status_ready.png" class="work_tickets_detail_station_connection_status"> <span>市区供电公司区供电公司市区供电公司市区供电公</span>
                </div>
              </div>
            </div>
            <div class="work_tickets_detail_station_li work_tickets_detail_station_card">
              <img src="images/substation.png" class="work_tickets_detail_station_card_img"> <span>市区供电公司</span>
            </div>
          </div>
          <div class="work_tickets_detail_stations_map">
            <div class="work_tickets_detail_stations_map_searchbox">
              <input class="work_tickets_detail_stations_map_searchbox_input" type="text" name="word" autocomplete="off" maxlength="256" placeholder="搜站点、查机房、找光缆" value="">
              <i class="fa fa-search work_tickets_detail_stations_map_searchbox_searchbtn" aria-hidden="true"></i>
            </div>
            <div class="work_tickets_detail_stations_map_contentbox">
              <div class="work_tickets_detail_stations_map_content">
                <img src="images/substation.png" class="work_tickets_detail_stations_map_content_img"> <span>市区供电公司</span> <i class="fa fa-plus-circle" aria-hidden="true"></i>
              </div>
              <div class="work_tickets_detail_stations_map_content">
                <img src="images/detail_connection.png" class="work_tickets_detail_stations_map_content_img"> <span>三级网青青0000(I)PTK16第5,6芯</span> <i class="fa fa-plus-circle"
                  aria-hidden="true"></i>
              </div>
              <div class="work_tickets_detail_stations_map_content">
                <img src="images/detail_connection.png" class="work_tickets_detail_stations_map_content_img"> <span>三级网塘练2A94(I)OHK48第13,14芯</span> <i
                  class="fa fa-plus-circle" aria-hidden="true"></i>
              </div>
            </div>
            <div class="map_mark postion" data-toggle="popover" data-trigger="hover" data-placement="top" data-content="市区供电公司"></div>
            <div class="map_mark postion2" data-toggle="popover" data-trigger="hover" data-placement="top" data-content="三级网青青0000(I)PTK16第5,6芯"></div>
          </div>
        </div>
        <div class="work_tickets_detail_separator"></div>
        <div class="work_tickets_detail_buttons_container">
          <button class="work_tickets_detail_button work_tickets_detail_button_cancle" data-izimodal-close="">取消</button>
          <button class="work_tickets_detail_button work_tickets_detail_button_submit">提交</button>
        </div>
      </div>
    </div>

  </div>
  <!-- /#wrapper -->

  <%@include file="templates/work_sheet_card.jsp"%>
</body>
</html>