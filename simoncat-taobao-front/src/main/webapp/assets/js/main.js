/*
	Striped by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
 */

(function($) {

  skel.breakpoints({
    desktop : '(min-width: 737px)',
    wide : '(min-width: 1201px)',
    narrow : '(min-width: 737px) and (max-width: 1200px)',
    narrower : '(min-width: 737px) and (max-width: 1000px)',
    mobile : '(max-width: 736px)'
  });

  $(function() {

    var $window = $(window), $body = $('body'), $document = $(document);

    // Disable animations/transitions until the page has loaded.
    $body.addClass('is-loading');

    $window.on('load', function() {
      $body.removeClass('is-loading');
    });

    // Fix: Placeholder polyfill.
    $('form').placeholder();

    // Prioritize "important" elements on mobile.
    skel.on('+mobile -mobile', function() {
      $.prioritize('.important\\28 mobile\\29', skel.breakpoint('mobile').active);
    });

    // Off-Canvas Sidebar.

    // Height hack.
    var $sc = $('#sidebar, #content'), tid;

    $window.on('resize', function() {
      window.clearTimeout(tid);
      tid = window.setTimeout(function() {
        $sc.css('min-height', $document.height());
      }, 100);
    }).on('load', function() {
      $window.trigger('resize');
    }).trigger('resize');

    // Title Bar.
    $(
        '<div id="titleBar">' + '<a href="#sidebar" class="toggle"></a>' + '<span class="title">'
            + $('#logo').html() + '</span>' + '</div>').appendTo($body);

    // Sidebar
    $('#sidebar').panel({
      delay : 500,
      hideOnClick : true,
      hideOnSwipe : true,
      resetScroll : true,
      resetForms : true,
      side : 'left',
      target : $body,
      visibleClass : 'sidebar-visible'
    });

    // Fix: Remove navPanel transitions on WP<10 (poor/buggy performance).
    if (skel.vars.os == 'wp' && skel.vars.osVersion < 10)
      $('#titleBar, #sidebar, #main').css('transition', 'none');
    
    // Init banner
    $('.mhn-slide').owlCarousel({
      nav:true,
      loop:true,
      slideBy:'page',
      rewind:false,
      responsive:{
        0:{items:1},
        480:{items:2},
        600:{items:3},
        1000:{items:4}
      },
      smartSpeed:70,
      onInitialized:function(e){
        $(e.target).find('img').each(function(){
          if(this.complete){
            $(this).closest('.mhn-inner').find('.loader-circle').hide();
            $(this).closest('.mhn-inner').find('.mhn-img').css('background-image','url('+$(this).attr('src')+')');
          }else{
            $(this).bind('load',function(e){
              $(e.target).closest('.mhn-inner').find('.loader-circle').hide();
              $(e.target).closest('.mhn-inner').find('.mhn-img').css('background-image','url('+$(this).attr('src')+')');
            });
          }
        });
      },
      navText:['<svg viewBox="0 0 24 24"><path d="M15.41 7.41L14 6l-6 6 6 6 1.41-1.41L10.83 12z"></path></svg>','<svg viewBox="0 0 24 24"><path d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z"></path></svg>']
    });

  });

})(jQuery);