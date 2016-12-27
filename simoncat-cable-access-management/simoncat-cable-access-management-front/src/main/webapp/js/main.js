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

  initWorkTicketsTabs();
  initWorkTicketsContents();
  initWorkTicketsFloatMenu();
  initDialog();
});

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
  var workTicketCardTemplate = $.templates("#work_sheet_card_template");
  $("#work_tickets_pending_container").html(workTicketCardTemplate.render(fetchWorkTicketPendingData()));
}

function initWorkTicketsFloatMenu() {
  $(".work_tickets_float_menu_plus").click(function(e) {
    $(".work_tickets_float_menu").toggleClass("open")
  });
}

function initDialog() {
  $(".work_tickets_card").click(function(e) {
    openDialog();
  });
}

function openDialog() {
  $("#modal-default").iziModal({
    title : "工作票详细信息",
    headerColor : "#17BCE8",
    iconClass : "fa fa-pencil-square-o",
    width : "90%",
    padding : 20,
    transitionInModal: 'fadeIn',
    transitionOutModal: 'fadeOut',
  });
  $("#modal-default").iziModal('open', this);
}

function fetchWorkTicketPendingData() {
  return [ {
    "plugmode" : true,
    "title" : "市区供电公司-220kv蕰藻浜变电站DSC10G（光路）",
    "id" : "沪电调通第20151290号",
    "deadline" : "2014-06-05 17:00",
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
      "name" : "闸北电厂（继）",
      "prev" : "光缆1231",
      "prev_status" : 0,
      "next" : "光缆1231",
      "next_status" : 0,
    }, {
      "name" : "闸北电厂（通）",
      "prev" : "光缆1231",
      "prev_status" : 0,
      "next" : "光缆1231",
      "next_status" : 0,
    }, {
      "name" : "220kv钢铁变电站（通）",
      "prev" : "光缆1231",
      "prev_status" : 0,
      "next" : "光缆1231",
      "next_status" : 0,
    }, {
      "name" : "220kv蕰藻浜变电站（通）",
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
  }, {
    "plugmode" : false,
    "title" : "市区供电公司-220kv蕰藻浜变电站DSC10G（光路）",
    "id" : "沪电调通第20151290号",
    "deadline" : "2014-06-05 17:00",
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
      "next_status" : 2,
    }, {
      "name" : "220kv洞庭变电站（继）",
      "prev" : "光缆1231",
      "prev_status" : 3,
      "next" : "光缆1231",
      "next_status" : 0,
    }, {
      "name" : "220kv森林变电站（继）",
      "prev" : "光缆1231",
      "prev_status" : 1,
      "next" : "光缆1231",
      "next_status" : 2,
    }, {
      "name" : "220kv蕰藻浜变电站（继）",
      "prev" : "光缆1231",
      "prev_status" : 0,
      "next" : "",
      "next_status" : -1,
    } ]
  } ];
}