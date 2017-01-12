<script id="work_sheet_card_template" type="text/x-jsrender" charset="UTF-8">
<div class="work_tickets_card {{if plugmode}}work_tickets_card_plug{{else}}work_tickets_card_unplug{{/if}} col-md-6" data-index="{{:#index}}">
  <p class="work_tickets_card_title">{{:title}}</p>
  <div class="work_tickets_card_subtitle">
    <div class="work_tickets_card_subtitle_id">
      <img src="images/sheetid.png" /> <span>{{:id}}</span>
    </div>
    <div class="work_tickets_card_subtitle_time">
      <img src="images/datetime.png" /> <span>要求完成时间：</span><span class="work_tickets_card_subtitle_time_value">{{:deadline}}</span>
    </div>
  </div>
  <div class="work_tickets_card_separator"></div>
  <div class="work_tickets_card_station_container">
    <div class="work_tickets_card_station_container_row">
      {{for stations}} {{if prev.status != -1}}
      <div class="work_tickets_card_station_connection_status_wrap left">
        <img src="images/{{if prev.status == 0}}status_ready{{else prev.status == 1}}status_occupied{{else prev.status == 2}}status_finished{{else prev.status == 3}}status_submitted{{/if}}.png" class="work_tickets_card_station_connection_status">
      </div>
      {{/if}}
      <div class="work_tickets_card_station_wrap {{if #index == 0}}first{{/if}}">
        <img src="images/substation.png" class="work_tickets_card_station_img"> <span>{{:name}}</span>
      </div>
      {{if next.status != -1}}
      <div class="work_tickets_card_station_connection_status_wrap right">
        <img src="images/{{if next.status == 0}}status_ready{{else next.status == 1}}status_occupied{{else next.status == 2}}status_finished{{else next.status == 3}}status_submitted{{/if}}.png" class="work_tickets_card_station_connection_status">
      </div>
      <div class="work_tickets_card_station_connection_wrap">
        <img src="images/connection.png" class="work_tickets_card_station_connection">
      </div>
      {{/if}} {{if #index%4 == 3}}
    </div>
    <div class="work_tickets_card_station_container_row">{{/if}} {{/for}}</div></div>
    <div class="work_tickets_card_separator"></div>
    <button class="work_tickets_card_button work_tickets_card_button_{{if status == 0}}pass{{else}}fail{{/if}}">审核{{if status == 1}}未{{/if}}通过</button>
  </div>
</script>