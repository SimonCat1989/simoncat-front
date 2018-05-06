$(document).ready(function() {

	var $btnCopy = $("#btn_copy_taobao_token");

	$btnCopy.click(function() {
	  $btnCopy.hide();
	  $("#btn_copy_taobao_token span").html("淘口令已复制!");
	  $btnCopy.addClass("clicked");
		$("#input_taobao_token").select();
		document.execCommand('copy');
		$btnCopy.fadeIn();
	});
});