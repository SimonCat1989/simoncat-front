$(document).ready(function () {
	$('#toggle').click(function () {
		if ($("#demo-settings").is(":hidden")) {
			$("#demo-settings").show();
			$("#toggle").animate({left:"+=260"}, 0);
		} else {
			$("#demo-settings").hide();
			$("#toggle").animate({left:"0"}, 0);
		}
	})
	$(".change").click(function () { 
		var id = $(this).attr('id');
		$("#hypnosis-bg").hide();
	    $("body").removeClass();
	    $("body").addClass(id);
	});
});