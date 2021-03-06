<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html class="kz-pc">
<head>
<base href="<%=basePath%>">
<title>淘宝返利机器人</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="MobileOptimized" content="320">
<meta name="viewport"
  content="initial-scale=1.0,user-scalable=no,minimum-scale=1.0, maximum-scale=1.0,width=device-width">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no, email=no">
<meta http-equiv="x-dns-prefetch-control" content="on">
<!--DTD WML-->
<meta http-equiv="Cache-Control" content="no-transform">

<link rel="stylesheet" type="text/css" href="css/ui.css">
<link rel="stylesheet" type="text/css" href="css/mobile.css">
<link rel="stylesheet" type="text/css" href="css/mod.css">
<link rel="stylesheet" type="text/css" href="css/portal_basic.css">
<link rel="stylesheet" type="text/css" href="css/theme.css">
<link rel="stylesheet" type="text/css" href="css/site.css">
<link rel="stylesheet" type="text/css" href="css/page.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body class="t3">
  <div class="kz-pc-header kz-b-c-t kz-f-c-tc">
    <div class="kz-pc-header-inner">
      <a data-pc-title="" style="max-width: 276px; margin-left: 20px;">淘宝返利机器人</a>
    </div>
  </div>
  <div id="phone-main" class="phone-main kz-pc-main">
    <div class="page-w " style="background-color: tranparent; background-size:;">
      <div id="page-content" class="page-content">
        <div class="mod mod-pic mod-picone" style="margin:;">
          <a href="javascript:;"><img src="${good}" title="" height=""></a>
        </div>
        <div class="mod mod-space" style="margin:;">
          <div class="space" style="height: 10px"></div>
        </div>
        <div class="mod mod-pic mod-picone" style="margin:;">
          <a href="javascript:;"><img src="images/flow.png" title="" height=""></a>
        </div>
        <div class="new-button" style="text-align:">
          <a id="btn_copy_taobao_token" class="new-button-link cus-button-1525086374795"><span>复制淘口令</span></a>
        </div>
        <input id="input_taobao_token" style="left: -100px; top: -100px; position: absolute;" value="${token}">
      </div>
    </div>
  </div>

  <script type="text/javascript" src="lib/jquery/jquery-1.11.3.min.js"></script>
  <script type="text/javascript" src="js/main.js"></script>
</body>
</html>