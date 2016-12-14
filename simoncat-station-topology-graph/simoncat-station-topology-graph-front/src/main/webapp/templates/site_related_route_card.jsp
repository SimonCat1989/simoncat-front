<script id="site_related_route_card_template" type="text/x-jsrender" charset="UTF-8">

<li class="site_related_route {{if #index == 0}} selected active {{/if}}" data-index="{{:#index}}" data-key="{{:start.name}}">
	<div class="site_related_route_card">
		<div class="site_related_route_card_head">
			<div class="site_related_route_scheme_name">
				{{:start.name}}&nbsp;<span class="rarr">→</span>&nbsp;{{:next.name}}
			</div>
			<span class="site_related_route_card_head_info head">{{:value.connectionName}}</span> <span
				class="busitemdelimiter">|</span> <span
				class="site_related_route_card_head_info">{{:value.connectionLength}} 公里</span> <span
				class="busitemdelimiter">|</span> <span
				class="site_related_route_card_head_info">剩余 {{:value.availableConnections}} 光纤</span>
		</div>
		{{if #index == 0}}
		<div class="site_related_route_card_content active">
		{{else}}
		<div class="site_related_route_card_content">
		{{/if}}
			<table class="site_related_route_info_detail">
				<tbody>
					<tr>
						<td><span class="site_related_route_info_item">光缆形式</span></td>
						<td><span class="site_related_route_info_item cable_type">{{:value.connectionType}}</span>
						</td>
						<td><span class="site_related_route_info_item">光缆用途</span></td>
						<td><span class="site_related_route_info_item cable_purpose">{{:value.connectionPurpose}}</span>
						</td>
					</tr>
					<tr>
						<td><span class="site_related_route_info_item">总光纤数</span></td>
						<td><span class="site_related_route_info_item cable_type">{{:value.totalConnections}}</span>
						</td>
						<td><span class="site_related_route_info_item">损坏光纤</span></td>
						<td><span class="site_related_route_info_item cable_purpose">{{:value.brokenConnections}}</span>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="site_related_route_card_tool">
			<img alt="修改" src="" data-index="{{:#index}}" data-key="{{:start.name}}" class="site_related_route_card_tool_edit" /> 
			<img alt="删除" src="" data-index="{{:#index}}" data-key="{{:start.name}}" class="site_related_route_card_tool_delete" />
		</div>
	</div>
</li>
</script>
