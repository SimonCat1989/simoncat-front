<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<title>后台系统</title>
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link href="css/navi.css" rel="stylesheet" type="text/css" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/side_menu.css" rel="stylesheet" type="text/css" />
<link href="css/site_search.css" rel="stylesheet" type="text/css" />
<link href="css/route_search.css" rel="stylesheet" type="text/css" />
<link href="css/sort_type.css" rel="stylesheet" type="text/css" />
<link href="css/route_card.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="lib/jquery-tinyScrollbar/css/tinyscrollbar.css" type="text/css"
	media="screen" />

<script type="text/javascript" src="lib/jquery/jquery-1.11.3.js"></script>
<script type="text/javascript" src="lib/jsrender/jsrender.js"></script>
<script type="text/javascript"
	src="lib/jquery-tinyScrollbar/jquery.tinyscrollbar.js"></script>

<link href="lib/jquery-ui/css/jquery-ui.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="lib/jquery-ui/jquery-ui.js"></script>

<link href="lib/jquery-toast/jquery.toast.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="lib/jquery-toast/jquery.toast.js"></script>

<script type="text/javascript" src="lib/echarts/echarts.js"></script>
<script data-require-id="echarts/chart/map"
	src="lib/echarts/chart/map.js" async=""></script>
</head>
<body>
	<div class="navi">
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

	<!-- side menu start -->
	<div class="side_menu">
		<ul>
			<li id="search_menu" class="menu_item selected"><a
				data-index="1" class="menu_item_link"> <img
					class="menu_item_icon" alt="搜索" src="images/site_tab_icon.png">
					<span>搜索</span>
			</a></li>
			<li id="route_menu" class="menu_item"><a data-index="2"
				class="menu_item_link"> <img class="menu_item_icon" alt="路线"
					src="images/route_tab_icon.png"> <span>路由</span>
			</a></li>
		</ul>
	</div>

	<div class="main">
		<div id="site_page" class="site_container">
			<div class="site_search_box">
				<div class="site_search_form">
					<div class="site_input_box">
						<p class="site_input start">
							<i></i><input type="text" id="site_search_start_input" value=""
								placeholder="请输入起点" maxlength="256"></input>
						</p>
					</div>
					<input value="搜索" class="site_submit" id="siteSearchBtn" title=""
						type="button">
				</div>
			</div>
			<div class="site_search_key">
				<div class="site_card"></div>
			</div>
			<div class="site_content_box tiny_scrollbar">
				<div class="scrollbar">
					<div class="track">
						<div class="thumb">
							<div class="end"></div>
						</div>
					</div>
				</div>
				<div class="viewport">
					<div class="overview">
						<div class="special">
							<ul class="site_related_route_list">
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="route_page" class="search_container hidden">
			<div class="search_box">
				<div class="search_form">
					<div class="route_switch" title="切换起终点">
						<a></a>
					</div>
					<div class="route_input_box">
						<p class="route_input start">
							<i></i><input type="text" id="start_input" value=""
								placeholder="请输入起点" maxlength="256"></input>
						</p>
						<p class="route_input end">
							<i></i><input type="text" id="end_input" value=""
								placeholder="请输入终点" maxlength="256"></input>
						</p>
						<p class="route_input start">
							<i></i><input type="number" id="cable_min_count" value="" placeholder="请输入最少纤芯数，默认为0" min="0">
						</p>
					</div>
					<input value="搜索" class="route_submit" id="routeSearchBtn" title=""
						type="button">
				</div>
			</div>
			<!-- <div class="route_sort_box">
				<table>
					<tbody>
						<tr>
							<td class="route_sort_item selected" id="route_type_recommend">推荐路线</td>
							<td class="route_sort_item" id="route_type_less_node">跳数最少</td>
							<td class="route_sort_item" id="route_type_less_distance">距离最短</td>
							<td class="route_sort_item long_word"
								id="route_type_higher_available">剩余光纤最多</td>
						</tr>
					</tbody>
				</table>
			</div> -->

			<div class="route_content_box tiny_scrollbar">
				<div class="scrollbar">
					<div class="track">
						<div class="thumb">
							<div class="end"></div>
						</div>
					</div>
				</div>
				<div class="viewport">
					<div class="overview">
						<div class="special">
							<ul class="route_list">
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="cable_toplogy_container" class="map_container"></div>
	</div>

	<div id="site_related_route_edit_dialog" title="光缆路径修改"></div>
	<div id="site_related_route_remove_dialog" title="光缆路径删除"></div>

	<%@include file="templates/site_card.jsp"%>
	<%@include file="templates/route_card.jsp"%>
	<%@include file="templates/site_related_route_card.jsp"%>
	<%@include file="templates/site_related_route_edit_dialog.jsp"%>
	<%@include file="templates/site_related_route_remove_dialog.jsp"%>
	<script type="text/javascript" src="js/site_manager.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript" src="js/route_main.js"></script>
	<script type="text/javascript" src="js/map.js"></script>
</body>
</html>