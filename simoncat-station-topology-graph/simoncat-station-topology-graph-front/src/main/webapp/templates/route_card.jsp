<script id="route_card_template" type="text/x-jsrender" charset="UTF-8">
<li class="route {{if !value.disuse}}enable{{/if}} {{if value.disuse}}value.disuse{{/if}} {{if #index == 0 && !value.disuse}}active{{/if}}" data-index="{{:#index}}">
	<div class="route_card">
		<div class="route_card_head {{if value.disuse}}value.disuse{{/if}}">
			<div class="route_scheme_name">
				<span class="route_scheme_tag" style="background: #67C395">{{if
					value.tag && value.tag !== ''}}<font color="#ffffff">{{:value.tag}}</font>{{/if}}
				</span>
				{{if edges.length >= 4}}
					{{:edges[0].start.name}}&nbsp;
					<span class="rarr">→</span>
					&nbsp;{{:edges[1].start.name}}&nbsp;
					<span class="rarr">→...→</span>
					&nbsp;{{:edges[edges.length - 1].start.name}}&nbsp;
					<span class="rarr">→</span>
					&nbsp;{{:edges[edges.length - 1].next.name}}
				{{else}}
					{{for edges}}
		      			{{:start.name}}&nbsp;
		      			<span class="rarr">→</span>&nbsp;
		    		{{/for}}
		    		{{:edges[edges.length - 1].next.name}}
	    		{{/if}}
			</div>
			<span class="route_card_head_info head">共 {{:edges.length}} 跳</span> <span
				class="busitemdelimiter">|</span> <span class="route_card_head_info">
				{{:value.totalDistance}} 公里</span> <span class="busitemdelimiter">|</span> <span
				class="route_card_head_info">剩余 {{:value.totalAvailableCableCount}} 光纤</span>
		</div>
		<div class="route_card_content {{if #index == 0}}active{{/if}}">
			{{for edges}}
			<h3 class="route_start_site">
				<span title="{{:start.name}}">{{:start.name}}</span>
			</h3>
			<table class="route_passed_site">
				<tbody>
					<tr>
						<th>
							<div class="cable_info_icon"></div>
						</th>
						<td class="route_card_wrapper_container">
							<div class="cable_info_detail">
								<div class="site_related_route_card_head_head">
									<div class="site_related_route_in_route_scheme_name">
										{{:value.connectionName}}</div>
									<span class="site_related_route_card_head_info head">{{:value.connectionLength}}
										公里</span> <span class="busitemdelimiter">|</span> <span
										class="site_related_route_card_head_info">剩余 {{:value.availableConnections}} 光纤</span>
								</div>
								<div class="site_related_route_card_content active">
									<div class="site_related_route_info_detail">
										<div class="row">
											<div class="site_related_route_in_route_info_item">光缆形式</div>
											<div class="site_related_route_in_route_info_item cable_type">{{:value.connectionType}}</div>
											<div class="site_related_route_in_route_info_item">光缆用途</div>
											<div
												class="site_related_route_in_route_info_item cable_purpose">{{:value.connectionPurpose}}</div>
										</div>
										<div class="row">
											<div class="site_related_route_in_route_info_item">总光纤数</div>
											<div class="site_related_route_in_route_info_item cable_type">{{:value.totalConnections}}</div>

											<div class="site_related_route_in_route_info_item">损坏光纤</div>
											<div
												class="site_related_route_in_route_info_item cable_purpose">{{:value.brokenConnections}}</div>
										</div>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			{{/for}}
			<h3 class="route_destination_site">
				<div class="route_destination_site_wrap">
					<span title="{{:edges[edges.length - 1].next.name}}">{{:edges[edges.length - 1].next.name}}</span>
				</div>
			</h3>
		</div>
	</div>
</li>
</script>