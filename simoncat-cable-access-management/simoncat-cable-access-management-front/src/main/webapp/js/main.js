var stategrid = stategrid || {};
stategrid.cableaccess = stategrid.cableaccess || {};

$(document).ready(function() {
  var trigger = $('.hamburger'), overlay = $('.overlay'), isClosed = false;

  trigger.click(function() {
    hamburger_cross();
  });

  function hamburger_cross() {

    if (isClosed == true) {
      overlay.hide();
      trigger.removeClass('is-open');
      trigger.addClass('is-closed');
      isClosed = false;
    } else {
      overlay.show();
      trigger.removeClass('is-closed');
      trigger.addClass('is-open');
      isClosed = true;
    }
  }

  $('[data-toggle="offcanvas"]').click(function() {
    $('#wrapper').toggleClass('toggled');
  });

  initData();
  $.get("./worksheets/pending/load.do", function(data){
    stategrid.cableaccess.data = $.extend(true, [], data["pending"]);
    initWorkTicketsTabs();
    initWorkTicketsContents();
    initWorkTicketsFloatMenu();
    initDialog();
  });
  
});

function initData() {
  // Init data
  stategrid.cableaccess.data = fetchWorkTicketPendingData();
  stategrid.cableaccess.templates = {
    "workTicketCard" : $.templates("#work_sheet_card_template"),
    "workTicketNewCard" : $.templates("#work_sheet_detail_station_card_new_template"),
    "workTicketDetailCard" : $.templates("#work_sheet_detail_station_card_template"),
    "workTicketStationCard" : $.templates("#work_sheet_detail_station_list_card_template"),
    "workTicketSearchResultsCard" : $.templates("#work_sheet_search_results_card_template")
  };
}

function initWorkTicketsTabs() {

  // Hide all tab container
  $(".work_tickets_container").hide();

  $(".work_tickets_li:first").attr("id", "active");
  $(".work_tickets_container:first").fadeIn();

  $(".work_tickets_a").click(function(e) {
    e.preventDefault();

    var $closestLiElement = $(this).closest(".work_tickets_li");
    if ($closestLiElement.attr("id") !== "active") {
      $(".work_tickets_container").hide();
      $(".work_tickets_li").attr("id", "");
      $closestLiElement.attr("id", "active");
      $('#' + $(this).attr('name')).fadeIn();
    }
  });
};

function initWorkTicketsContents() {
  var workTicketCardTemplate = stategrid.cableaccess.templates["workTicketCard"];
  $("#work_tickets_pending_container").html(workTicketCardTemplate.render(stategrid.cableaccess.data));
  $("#work_tickets_working_container").html(workTicketCardTemplate.render(stategrid.cableaccess.data));
  $("#work_tickets_submitting_container").html(workTicketCardTemplate.render(stategrid.cableaccess.data));
  $("#work_tickets_submitted_container").html(workTicketCardTemplate.render(stategrid.cableaccess.data));
}

function initWorkTicketsFloatMenu() {
  $(".work_tickets_float_menu_plus").click(function(e) {
    $(".work_tickets_float_menu").toggleClass("open")
  });
}

function initDialog() {
  $("#work_sheet_detail_station_card_new_dialog").html(
      stategrid.cableaccess.templates["workTicketNewCard"].render({}));
  $("#work_sheet_detail_station_card_new_dialog .work_tickets_detail_stations_list").html(
      stategrid.cableaccess.templates["workTicketStationCard"].render(stategrid.cableaccess.data[0]));
  $(document).on(
      "click",
      ".work_tickets_detail_map_searchbtn",
      function(e) {
        var $resultContainer = $(".work_tickets_detail_map_contentbox");
        $resultContainer.hide();
        $resultContainer.html();
        var searchedKey = $(".work_tickets_detail_map_searchbox_input").val();
        var searchedResults = getSearchResults(searchedKey);
        if (searchedResults) {
          $resultContainer.html(stategrid.cableaccess.templates["workTicketSearchResultsCard"]
              .render(searchedResults));
          $resultContainer.fadeIn();
        }
      });

  $(document).on("keyup", ".work_tickets_detail_map_searchbox_input", function(e) {
    if (event.keyCode == "13") {
      $(".work_tickets_detail_map_searchbtn").click();
    }
  });

  var workTicketDetailStationCardTemplate = stategrid.cableaccess.templates["workTicketDetailCard"];
  $("#work_sheet_detail_station_card_dialog").html(workTicketDetailStationCardTemplate.render({}));

  $("#work_sheet_detail_station_card_new_dialog").iziModal({
    title : "新增工作单详细信息",
    headerColor : "rgb(0, 106, 106)",
    iconClass : "fa fa-pencil-square-o",
    width : "90%",
    padding : 20,
    transitionInModal : 'fadeIn',
    transitionOutModal : 'fadeOut',
  });
  $("#work_sheet_detail_station_card_dialog").iziModal({
    title : "工作单详细信息",
    headerColor : "rgb(0, 106, 106)",
    iconClass : "fa fa-pencil-square-o",
    width : "90%",
    padding : 20,
    transitionInModal : 'fadeIn',
    transitionOutModal : 'fadeOut',
  });

  $(document).on('closed', '#work_sheet_detail_station_card_new_dialog', function(e) {
    $("#work_sheet_detail_station_card_new_dialog").addClass("work_tickets_detail");
    $(".work_tickets_detail_map_searchbox_input").val("");
    $(".work_tickets_detail_map_contentbox").html();
    $(".work_tickets_detail_map_contentbox").hide();

  });
  $(document).on('closed', '#work_sheet_detail_station_card_dialog', function(e) {
    $("#work_sheet_detail_station_card_dialog").addClass("work_tickets_detail");
  });

  $(".link-home").click(function(e) {
    $("#work_sheet_detail_station_card_new_dialog").iziModal('open', this);
  });
  $("#work_tickets_pending_container .work_tickets_card").click(function(e) {
    $("#work_sheet_detail_station_card_dialog").iziModal('open', this);
  });
}

function fetchWorkTicketPendingData() {
  return [ {
    "plugmode" : false,
    "plugmode_text" : "退出通知单",
    "group" : "上海市电力公司话路运动",
    "id" : "沪电调通第20160697号",
    "title" : "青浦供电公司-220kv干练变电站华为10G（光缆）",
    "user_kind" : "华为三级网",
    "deadline" : "2016-03-15 17:00",
    "channel_kind" : "光纤",
    "status" : "0",
    "stations" : [ {
      "name" : "青浦供电公司",
      "prev" : "",
      "prev_status" : -1,
      "next" : "三级网青青0000(I)PTK16",
      "next_port_1" : 5,
      "next_port_2" : 6,
      "next_status" : 0,
    }, {
      "name" : "220kv青浦变电站（通）",
      "prev" : "三级网青青0000(I)PTK16",
      "prev_port_1" : 5,
      "prev_port_2" : 6,
      "prev_status" : 0,
      "next" : "24芯联络缆(I)",
      "next_port_1" : 15,
      "next_port_2" : 16,
      "next_status" : 0,
    }, {
      "name" : "220kv青浦变电站（继）",
      "prev" : "24芯联络缆(I)",
      "prev_port_1" : 15,
      "prev_port_2" : 16,
      "prev_status" : 0,
      "next" : "三级网塘青2A54(I)OHK48",
      "next_port_1" : 15,
      "next_port_2" : 16,
      "next_status" : 0,
    }, {
      "name" : "500kv练塘变电站（220kv继1）",
      "prev" : "三级网塘青2A54(I)OHK48",
      "prev_port_1" : 15,
      "prev_port_2" : 16,
      "prev_status" : 0,
      "next" : "三级网塘练2A94(I)OHK48",
      "next_port_1" : 13,
      "next_port_2" : 14,
      "next_status" : 0,
    }, {
      "name" : "220kv干练变电站（继）",
      "prev" : "三级网塘练2A94(I)OHK48",
      "prev_port_1" : 13,
      "prev_port_2" : 14,
      "prev_status" : 0,
      "next" : "24芯联络缆(I)",
      "next_port_1" : 11,
      "next_port_2" : 12,
      "next_status" : 0,
    }, {
      "name" : "220kv干练变电站（通）",
      "prev" : "24芯联络缆(I)",
      "prev_port_1" : 11,
      "prev_port_2" : 12,
      "prev_status" : 0,
      "next" : "",
      "next_status" : -1,
    } ]
  }, {
    "plugmode" : true,
    "plugmode_text" : "接入通知单",
    "group" : "上海市电力公司话路运动",
    "id" : "沪电调通第20151290号",
    "title" : "市区供电公司-220kv蕰藻浜变电站DSC10G（光路）",
    "user_kind" : "华为三级网",
    "deadline" : "2014-06-05 17:00",
    "channel_kind" : "光纤",
    "status" : "0",
    "stations" : [ {
      "name" : "市区供电公司",
      "prev" : "",
      "prev_status" : -1,
      "next" : "光缆1231",
      "next_status" : 0,
    }, {
      "name" : "220kv洞庭变电站（通）",
      "prev" : "光缆1231",
      "prev_status" : 0,
      "next" : "光缆1231",
      "next_status" : 0,
    }, {
      "name" : "220kv洞庭变电站（继）",
      "prev" : "光缆1231",
      "prev_status" : 0,
      "next" : "光缆1231",
      "next_status" : 0,
    }, {
      "name" : "220kv森林变电站（继）",
      "prev" : "光缆1231",
      "prev_status" : 0,
      "next" : "光缆1231",
      "next_status" : 0,
    }, {
      "name" : "220kv蕰藻浜变电站（继）",
      "prev" : "光缆1231",
      "prev_status" : 0,
      "next" : "",
      "next_status" : -1,
    } ]
  } ];
};

function getSearchResults(key) {
  if (key) {
    if (key === "三级网") {
      return {
        "found" : true,
        "key" : key,
        "results" : [ {
          "result" : "三级网市区供电公司",
          "type" : "station"
        }, {
          "result" : "三级网青青0000(I)PTK16",
          "type" : "connection"
        }, {
          "result" : "三级网塘练2A94(I)OHK48",
          "type" : "connection"
        } ]
      };
    }
    return {
      "found" : false,
      "key" : key
    };
  }
  return null;
}