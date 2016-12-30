<script id="work_sheet_search_results_card_template" type="text/x-jsrender" charset="UTF-8">
{{if found}} {{for results}}
<div class="work_tickets_detail_map_content">
  <img
    src="images/{{if type == 'station'}}substation{{else type == 'connection'}}detail_connection{{/if}}.png"
    class="work_tickets_detail_map_content_img"> <span>{{:result}}</span> <i
    class="fa fa-plus-circle" aria-hidden="true"></i>
</div>
{{/for}} {{else}}
<div class="work_tickets_detail_map_content">
  <img src="images/sorry.jpg"> <span>没有搜索到与“</span>
  <span class="work_tickets_detail_map_content_sorry_key">{{:key}}</span>
  <span>”有关的站点或者光缆信息</span>
</div>
{{/if}}
</script>