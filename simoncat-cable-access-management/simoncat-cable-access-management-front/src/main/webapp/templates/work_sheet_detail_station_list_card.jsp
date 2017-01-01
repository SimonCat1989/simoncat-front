<script id="work_sheet_detail_station_list_card_template" type="text/x-jsrender" charset="UTF-8">
{{for stations}} {{if prev_status != -1}}
<div class="work_tickets_detail_station_connection_container left">
  <div class="work_tickets_detail_station_connection_container_wrap">
    <div class="work_tickets_detail_station_connection_wrap left">
      <img src="images/detail_connection.png" class="work_tickets_detail_station_connection left">
    </div>
  </div>
  <div class="work_tickets_detail_station_connection_status_wrap_container">
    <div
      class="work_tickets_detail_station_li work_tickets_detail_station_connection_status_wrap left">
      <img
        src="images/{{if prev_status == 0}}status_ready{{else prev_status == 1}}status_occupied{{else prev_status == 2}}status_finished{{else prev_status == 3}}status_submitted{{/if}}.png"
        class="work_tickets_detail_station_connection_status"> <span>{{:prev}}第<input
        type="text" class="work_tickets_detail_station_connection_input" name="word"
        autocomplete="off" maxlength="5" value="{{:prev_port_1}}" data-index="{{#index}}"><span>,</span><input
        type="text" class="work_tickets_detail_station_connection_input" name="word"
        autocomplete="off" maxlength="5" value="{{:prev_port_2}}" data-index="{{#index}}"><span>芯</span>
    </div>
  </div>
</div>
{{/if}}
<div class="work_tickets_detail_station_li work_tickets_detail_station_card">
  <img src="images/substation.png" class="work_tickets_detail_station_card_img"> <span>{{:name}}</span>
</div>
{{if next_status != -1}}
<div class="work_tickets_detail_station_connection_container">
  <div class="work_tickets_detail_station_connection_container_wrap">
    <div class="work_tickets_detail_station_connection_wrap">
      <img src="images/detail_connection.png" class="work_tickets_detail_station_connection">
    </div>
  </div>
  <div class="work_tickets_detail_station_connection_status_wrap_container">
    <div class="work_tickets_detail_station_li work_tickets_detail_station_connection_status_wrap">
      <img
        src="images/{{if next_status == 0}}status_ready{{else next_status == 1}}status_occupied{{else next_status == 2}}status_finished{{else next_status == 3}}status_submitted{{/if}}.png"
        class="work_tickets_detail_station_connection_status"> <span>{{:next}}第</span><input
        type="text" class="work_tickets_detail_station_connection_input" name="word"
        autocomplete="off" maxlength="5" value="{{:next_port_1}}" data-index="{{#index}}"><span>,</span><input
        type="text" class="work_tickets_detail_station_connection_input" name="word"
        autocomplete="off" maxlength="5" value="{{:next_port_2}}" data-index="{{#index}}"><span>芯</span>
    </div>
  </div>
</div>
{{/if}}
{{/for}}
</script>