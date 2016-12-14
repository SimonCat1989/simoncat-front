<script id="site_related_route_edit_dialog_template" type="text/x-jsrender" charset="UTF-8">
<div class="site_related_route_card">
	<div class="site_related_route_card_head">
		<div class="site_related_route_scheme_name">
			{{:start.name}}&nbsp;<span class="rarr">→</span>&nbsp;{{:next.name}} <input type="text"
				id="site_related_route_edit_name" value="{{:value.connectionName}}"
				class="text ui-widget-content ui-corner-all">
		</div>
	</div>

	<div class="site_related_route_card_content active">
		<table class="site_related_route_info_detail">
			<tbody>
				<tr>
					<td><label for="site_related_route_edit_distance">光缆长度</label></td>
					<td><input type="text" id="site_related_route_edit_distance"
						value="{{:value.connectionLength}}" class="text ui-widget-content ui-corner-all"></td>
					<td><label for="site_related_route_edit_used">已用光纤</label></td>
					<td><input type="text" id="site_related_route_edit_used"
						value="{{:value.availableConnections}}" class="text ui-widget-content ui-corner-all"></td>
				</tr>
				<tr>
					<td><label for="site_related_route_edit_cable_type">光缆形式</label></td>
					<td><input type="text" id="site_related_route_edit_cable_type"
						value="{{:value.connectionType}}" class="text ui-widget-content ui-corner-all"></td>
					<td><label for="site_related_route_edit_cable_purpose">光缆用途</label></td>
					<td><input type="text"
						id="site_related_route_edit_cable_purpose" value="{{:value.connectionPurpose}}"
						class="text ui-widget-content ui-corner-all"></td>
				</tr>
				<tr>
					<td><label for="site_related_route_edit_total_cable_count">总光纤数</label></td>
					<td><input type="text"
						id="site_related_route_edit_total_cable_count" value="{{:value.totalConnections}}"
						class="text ui-widget-content ui-corner-all"></td>
					<td><label for="site_related_route_edit_broken_cable_count">损坏光纤</label></td>
					<td><input type="text"
						id="site_related_route_edit_broken_cable_count" value="{{:value.brokenConnections}}"
						class="text ui-widget-content ui-corner-all"></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div style="display:none;">
		<span id="site_related_route_edit_file_name">{{:value.excelMeta.fileName}}</span>
        <span id="site_related_route_edit_sheet_name">{{:value.excelMeta.sheetName}}</span>
		<span id="site_related_route_edit_row_pos">{{:value.excelMeta.rowPosition}}</span>
		<span id="site_related_route_edit_start_site_name">{{:start.name}}</span>
		<span id="site_related_route_edit_next_site_name">{{:next.name}}</span>
	</div>
</div>
</script>