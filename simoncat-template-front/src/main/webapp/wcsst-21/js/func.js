
$(document).ready(function() {
	$('.slider').jcarousel( {
		initCallback: slider_initCallback,
		itemFirstInCallback: slider_firstInCallback,
		scroll: 1,
		wrap : 'both',
		// This tells jCarousel NOT to autobuild prev/next buttons
		buttonNextHTML: null,
		buttonPrevHTML: null
	});
	
	var sliderNav = $('.slider-holder .nav');
	sliderNav.css({ left : (sliderNav.parent().width() - sliderNav.width()) / 2 })
});

function slider_initCallback (carousel) {
	$(".btn-prev").click(function () {
		carousel.prev();
		return false;
	});
	
	$(".btn-next").click(function () {
		carousel.next();
		return false;
	});
	
	$('.slider-holder .nav a').bind('click', function() {
		carousel.scroll($.jcarousel.intval($(this).attr('rel')));
		return false;
	});
}

function slider_firstInCallback(carousel, item, idx, state) {
	$('.slider-holder .nav a').removeClass('active');
	$('.slider-holder .nav a').eq(idx-1).addClass('active');
}