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
});

function initWorkTicketsTabs() {
  $(".work_tickets_li").click(function(e) {

    // make sure we cannot click the slider
    if ($(this).hasClass('work_tickets_slider')) {
      return;
    }

    /* Add the slider movement */

    // what tab was pressed
    var whatTab = $(this).index();

    // Work out how far the slider needs to go
    var howFar = 160 * whatTab;

    $(".work_tickets_slider").css({
      left : howFar + "px"
    });

    /* Add the ripple */

    // Remove olds ones
    $(".ripple").remove();

    // Setup
    var posX = $(this).offset().left, posY = $(this).offset().top, buttonWidth = $(this).width(), buttonHeight = $(this).height();

    // Add the element
    $(this).prepend("<span class='ripple'></span>");

    // Make it round!
    if (buttonWidth >= buttonHeight) {
      buttonHeight = buttonWidth;
    } else {
      buttonWidth = buttonHeight;
    }

    // Get the center of the element
    var x = e.pageX - posX - buttonWidth / 2;
    var y = e.pageY - posY - buttonHeight / 2;

    // Add the ripples CSS and start the animation
    $(".ripple").css({
      width : buttonWidth,
      height : buttonHeight,
      top : y + 'px',
      left : x + 'px'
    }).addClass("rippleEffect");
  });
}