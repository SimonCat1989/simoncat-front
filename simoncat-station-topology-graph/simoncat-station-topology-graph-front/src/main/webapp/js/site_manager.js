var stategrid = stategrid || {};
stategrid.cabletopoloy = stategrid.cabletopoloy || {};
stategrid.cabletopoloy.siteManager = {
	load : function(siteName, callback) {
		$.get("./index/load.do", {
			site_name : siteName
		}, function(data) {
			callback(data);
		});
	}
}