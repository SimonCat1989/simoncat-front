$(document).ready(function() {

  console.log("haha");
  
  $(".ticket-action").click(function() {
    if ("up" === $(this).find("i")[0].className) {
      $(this).html("展开<i class=\"down\"></i>");
    } else {
      $(this).html("收起<i class=\"up\"></i>");
    }
    $("#" + $(this).attr("data-target")).toggleClass("hidden");
  });
});