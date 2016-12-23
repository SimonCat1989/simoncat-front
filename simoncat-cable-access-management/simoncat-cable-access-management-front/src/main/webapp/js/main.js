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
  initWorkTicketsFloatMenu();
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

function initWorkTicketsFloatMenu() {
  $(".work_tickets_float_menu_plus").click(function(e){
    $(".work_tickets_float_menu").toggleClass("open")
  });
}