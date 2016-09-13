$(document).ready(function() {
  $.localScroll();
  $(".front_curtain").delay(1000).fadeOut(500);
  $("#wrapper-header").delay(1500).animate({
    opacity : '1',
    width : '100%'
  }, 500);
  $("#wrapper-navbar").delay(2000).animate({
    opacity : '1',
    height : '60px'
  }, 500);
  $("#main-container-image").delay(2500).animate({
    opacity : '1'
  }, 500);

  initPage();
});

/* TRANSITION PAGE */
$('html, body').hide();

$(document).ready(function() {
  $('html, body').fadeIn('slow');
});

/* DISABLE HOVER EFFECT WHILE YOU SCROLL FOR A SMOOTHY NAVIGATION */

var body = document.body, timer;

window.addEventListener('scroll', function() {

  clearTimeout(timer);

  if (!body.classList.contains('disable-hover'))
    body.classList.add('disable-hover')

  timer = setTimeout(function() {
    body.classList.remove('disable-hover')
  }, 200);

}, false);

/* BOUTON NEXT */

$(document).on('touchstart mouseover', '#oldnew-next', function(event) {

  event.stopPropagation();
  event.preventDefault();
  if (event.handled !== true) {

    $("#oldnew-next").stop().animate({
      scale : '1.2',
      opacity : '0.5'
    }, 300);

    event.handled = true;
  } else {
    return false;
  }
});

$(document).on('touchend mouseout', '#oldnew-next', function(event) {

  event.stopPropagation();
  event.preventDefault();
  if (event.handled !== true) {

    $("#oldnew-next").stop().animate({
      scale : '1',
      opacity : '1'
    }, 300);

    event.handled = true;
  } else {
    return false;
  }
});

/* BOUTON PREV */

$(document).on('touchstart mouseover', '#oldnew-prev', function(event) {

  event.stopPropagation();
  event.preventDefault();
  if (event.handled !== true) {

    $("#oldnew-prev").stop().animate({
      scale : '1.2',
      opacity : '0.5'
    }, 300);

    event.handled = true;
  } else {
    return false;
  }
});

$(document).on('touchend mouseout', '#oldnew-prev', function(event) {

  event.stopPropagation();
  event.preventDefault();
  if (event.handled !== true) {

    $("#oldnew-prev").stop().animate({
      scale : '1',
      opacity : '1'
    }, 300);

    event.handled = true;
  } else {
    return false;
  }
});

/* FORMULAIRE NEWSLETTER */

$("form").on("submit", function(event) {
  event.preventDefault();
  $.post("/burstfly/form-burstfly-modified.asp", $("form").serialize(), function(data) {// alert(data);
  });
});

function initPage() {
  $.getJSON("data/categories.json", function(categoryData) {

    $("#wrapper-bouton-icon").html($.templates("#category_card").render($.map(categoryData, function(value, key) {
      return value;
    })));

    $.getJSON("data/templates.json", function(templatesData) {
      var data = templatesData["data"];
      for ( var card in data) {
        data[card]["icon_class"] = categoryData[data[card]["type"]]["icon"];
      }
      $("#main-container").html($.templates("#template_card").render(templatesData));
    });
  });
}
