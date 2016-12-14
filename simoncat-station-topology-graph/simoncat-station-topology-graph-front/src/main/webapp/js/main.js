var stategrid = stategrid || {};
stategrid.cabletopoloy = stategrid.cabletopoloy || {};
stategrid.cabletopoloy.globaldata = stategrid.cabletopoloy.globaldata ||  {};
stategrid.cabletopoloy.globaldata.cursite = stategrid.cabletopoloy.globaldata.cursite || {};
stategrid.cabletopoloy.globaldata.site = stategrid.cabletopoloy.globaldata.site || {};
stategrid.cabletopoloy.globaldata.route = stategrid.cabletopoloy.globaldata.route || {};
stategrid.cabletopoloy.globaldata.curRoute = stategrid.cabletopoloy.globaldata.curRoute || {};

$(document).ready(function() {
	$(".route_content_box").tinyscrollbar();
	$(".site_content_box").tinyscrollbar();

	var $menuSearch = $("#search_menu");
	var $menuRoute = $("#route_menu");

	$menuSearch.click(function() {
		if (!$menuSearch.hasClass("selected")) {
			$menuSearch.addClass("selected");
			$menuRoute.removeClass("selected");
			$("#route_page").addClass("hidden");
			$("#site_page").removeClass("hidden");
		}
	});

	$menuRoute.click(function() {
		if (!$menuRoute.hasClass("selected")) {
			$menuRoute.addClass("selected");
			$menuSearch.removeClass("selected");
			$("#site_page").addClass("hidden");
			$("#route_page").removeClass("hidden");
		}
	});

	var siteManager = stategrid.cabletopoloy.siteManager;
	$("#siteSearchBtn").click(function() {
		var cachedData = stategrid.cabletopoloy.globaldata.site[$("#site_search_start_input").val()];
		if (cachedData) {
			doInitSitePanel_(cachedData);
		} else {
			siteManager.load($("#site_search_start_input").val(), function(data) {
				if (data && data.data && data.data.length > 0) {
					stategrid.cabletopoloy.globaldata.site[data.data[0].start.name] = data.data;
					doInitSitePanel_(data.data);
				}
			});
		}
	});
	
	$("#routeSearchBtn").click(function() {
		$.get("./index/search.do", {
			start_site_name : $("#start_input").val(),
			next_site_name : $("#end_input").val(),
			cable_count_min : ($("#cable_min_count").val() === undefined || $("#cable_min_count").val() === '') ? 0 : $("#cable_min_count").val() 
		}, function(data) {
			if (data && data.data && data.data.length > 0) {
				stategrid.cabletopoloy.globaldata.route = data.data;
				doInitRoutePanel_(data.data);
			}
		});
	});

	initDialog();
	initRemoveDialog_();
});

function bindSiteRelatedRouteCardEvent_() {
	$(".site_related_route").click(function(){
		stategrid.cabletopoloy.globaldata.cursite = {
				key: $(this).attr("data-key"),
				index: $(this).attr("data-index")
		};
		doActiveSiteRelatedRouteCard_($(this));
		doActiveMapForSiteRelatedCard_($(this).attr("data-key"), $(this).attr("data-index"));
	});
	
	$(".site_related_route").mouseenter(function(){
		doActiveMapForSiteRelatedCard_($(this).attr("data-key"), $(this).attr("data-index"));
	});
	$(".site_related_route").mouseleave(function(){
		resetActiveForSiteRelatedRoute_($(this).attr("data-key"), $(this).attr("data-index"));
	});
}

function doActiveSiteRelatedRouteCard_($targetCard) {
	if (!$targetCard.hasClass("active")) {
		$targetCard.addClass("active");
		$targetCard.find(".site_related_route_card_content").addClass("active");
	} else {
		$targetCard.removeClass("active");
		$targetCard.find(".site_related_route_card_content").removeClass("active");
	}
	$(".site_content_box").data("plugin_tinyscrollbar").update();
}

function doActiveMapForSiteRelatedCard_(key, index) {
	var data = stategrid.cabletopoloy.globaldata.site[key][index];
	stategrid.cabletopoloy.map.selectRoute([data]);
}

function resetActiveForSiteRelatedRoute_(key, index) {
	var curCard = stategrid.cabletopoloy.globaldata.cursite;
	if (index !== curCard.index) {
		doActiveMapForSiteRelatedCard_(curCard.key, curCard.index);
	}
}

function bindRouteCardEvent_() {
	$(".route.enable").click(function(){
		doActiveRouteCard_($(this));
		
		stategrid.cabletopoloy.globaldata.curRoute = {
			index: $(this).attr("data-index")
		};
		
		doActiveMapForRoute_($(this).attr("data-index"));
	});
	
	$(".route.enable").mouseenter(function(){
		doActiveMapForRoute_($(this).attr("data-index"));
	});
	
	$(".route.enable").mouseleave(function(){
		resetActiveForRoute_($(this).attr("data-index"));
	});
}

function doActiveRouteCard_($targetCard) {
	if (!$targetCard.hasClass("active")) {
		$targetCard.addClass("active");
		$targetCard.find(".route_card_content").addClass("active");
	} else {
		$targetCard.removeClass("active");
		$targetCard.find(".route_card_content").removeClass("active");
	}
	$(".site_content_box").data("plugin_tinyscrollbar").update();
}

function doActiveMapForRoute_(index) {
	var data = stategrid.cabletopoloy.globaldata.route[index].routes;
	stategrid.cabletopoloy.map.selectRoute(data);
}

function resetActiveForRoute_(index) {
	var curCard = stategrid.cabletopoloy.globaldata.curRoute;
	if (index !== curCard.index) {
		doActiveMapForRoute_(curCard.index);
	}
}

function doInitSitePanel_(data) {
	var siteCardData = {};
	siteCardData.name = data[0].start.name;
	siteCardData.count = data.length;
	var siteCardTemplate = $.templates("#site_card_template");
	$(".site_card").html(siteCardTemplate.render(siteCardData));

	var template = $.templates("#site_related_route_card_template");
	$(".site_related_route_list").html(template.render(data));

	$(".site_content_box").data("plugin_tinyscrollbar").update();
	
	stategrid.cabletopoloy.globaldata.cursite = {
			key: data[0].start.name,
			index: 0
	};
	doActiveMapForSiteRelatedCard_(data[0].start.name, 0);
	initDialog();
	initRemoveDialog_();
	bindSiteRelatedRouteCardEvent_();
}

function doInitRoutePanel_(data) {
	var routeCardTemplate = $.templates("#route_card_template");
	$(".route_list").html(routeCardTemplate.render(data));
	
	$(".route_content_box").data("plugin_tinyscrollbar").update();
	
	stategrid.cabletopoloy.globaldata.curRoute = {
		index: 0
	};
	doActiveMapForRoute_(0);
	bindRouteCardEvent_();
}

function doUpdate_() {
	var site_related_route_edit_name = $("#site_related_route_edit_name").val();
	var site_related_route_edit_distance = $(
			"#site_related_route_edit_distance").val();
	var site_related_route_edit_used = $("#site_related_route_edit_used").val();
	var site_related_route_edit_cable_type = $(
			"#site_related_route_edit_cable_type").val();
	var site_related_route_edit_cable_purpose = $(
			"#site_related_route_edit_cable_purpose").val();
	var site_related_route_edit_total_cable_count = $(
			"#site_related_route_edit_total_cable_count").val();
	var site_related_route_edit_broken_cable_count = $(
			"#site_related_route_edit_broken_cable_count").val();
	var file_name = $("#site_related_route_edit_file_name").html();
	var sheet_name = $("#site_related_route_edit_sheet_name").html();
	var row_pos = $("#site_related_route_edit_row_pos").html();
	var start_site_name = $("#site_related_route_edit_start_site_name").html();
	var next_site_name = $("#site_related_route_edit_next_site_name").html();

	$.get("./index/update.do", {
		routeName : site_related_route_edit_name,
		distance : site_related_route_edit_distance,
		cableCountUsed : site_related_route_edit_used,
		cableTypeName : site_related_route_edit_cable_type,
		cablePurpose : site_related_route_edit_cable_purpose,
		cableCountTotal : site_related_route_edit_total_cable_count,
		cableCountBroken : site_related_route_edit_broken_cable_count,
		fileName : file_name,
		sheetName : sheet_name,
		rowPos : row_pos,
		startSiteName : start_site_name,
		nextSiteName : next_site_name
	}, function(response) {
		if (response.data === 'succ') {
			// update dom
			var key = stategrid.cabletopoloy.globaldata.cursite.key;
			var index = stategrid.cabletopoloy.globaldata.cursite.index;
			var editingRoute = stategrid.cabletopoloy.globaldata.site[key][index];
			editingRoute.name = site_related_route_edit_name;
			editingRoute.distance = site_related_route_edit_distance;
			editingRoute.usedCableCount = site_related_route_edit_used;
			editingRoute.cableType = site_related_route_edit_cable_type;
			editingRoute.cablePurpose = site_related_route_edit_cable_purpose;
			editingRoute.totalCableCount = site_related_route_edit_total_cable_count;
			editingRoute.brokenCableCount = site_related_route_edit_broken_cable_count;
			$("#siteSearchBtn").click();
			$.toast({
				heading : '保存成功',
				showHideTransition : 'slide',
				icon : 'success'
			});
		}
	});
}

function initRemoveDialog_() {
	var dialog = $("#site_related_route_remove_dialog").dialog({
		autoOpen : false,
	      resizable: true,
	      height:180,
	      width:600,
	      modal: true,
	      buttons: {
	        'Yes': function() {
	        	var file_name = $("#site_related_route_edit_file_name").html();
	        	var sheet_name = $("#site_related_route_edit_sheet_name").html();
	        	var row_pos = $("#site_related_route_edit_row_pos").html();
	        	$.get("./index/remove.do", {
	        		fileName : file_name,
	        		sheetName : sheet_name,
	        		rowPos : row_pos
	        	}, function(response) {
	        		if (response.data === 'succ') {
	        			//update
	        			var key = stategrid.cabletopoloy.globaldata.cursite.key;
	        			var index = stategrid.cabletopoloy.globaldata.cursite.index;
	        			stategrid.cabletopoloy.globaldata.site[key].splice(index, 1);
	        			$("#siteSearchBtn").click();
	        			$.toast({
	        				heading : '保存成功',
	        				showHideTransition : 'slide',
	        				icon : 'success'
	        			});
	        		}
	        	});
	          $( this ).dialog( "close" );
	        },
	        'Cancel': function() {
	          $( this ).dialog( "close" );
	        }
	      }
	    });
	
	$(".site_related_route_card_tool_delete")
	.on(
			"click",
			function(e) {
				var key = e.target.getAttribute("data-key");
				var index = e.target.getAttribute("data-index");
				var siteRelatedRouteRemoveDialogTemplate = $.templates("#site_related_route_remove_dialog_template");
				$("#site_related_route_remove_dialog").html(siteRelatedRouteRemoveDialogTemplate.render(stategrid.cabletopoloy.globaldata.site[key][index]));
				stategrid.cabletopoloy.globaldata.cursite = {
						key: key,
						index: index
				}
				dialog.dialog("open");
			});
}

function initDialog() {
	var dialog = $("#site_related_route_edit_dialog").dialog({
		autoOpen : false,
		height : 245,
		width : 565,
		modal : true,
		buttons : {
			"OK" : function() {
				doUpdate_();
				dialog.dialog("close");
			},
			'Cancel' : function() {
				dialog.dialog("close");
			}
		},
		close : function() {
		}
	});

	$(".site_related_route_card_tool_edit").on("click",function(e) {
		var key = e.target.getAttribute("data-key");
		var index = e.target.getAttribute("data-index");
		var siteRelatedRouteEditDialogTemplate = $
		.templates("#site_related_route_edit_dialog_template");
		$("#site_related_route_edit_dialog")
		.html(
				siteRelatedRouteEditDialogTemplate
						.render(stategrid.cabletopoloy.globaldata.site[key][index]));
		stategrid.cabletopoloy.globaldata.cursite = {
				key: key,
				index: index
		}
		dialog.dialog("open");
	});
}