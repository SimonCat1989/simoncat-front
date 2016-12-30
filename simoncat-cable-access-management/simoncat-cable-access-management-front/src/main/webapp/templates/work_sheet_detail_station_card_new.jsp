<script id="work_sheet_detail_station_card_new_template" type="text/x-jsrender" charset="UTF-8">
<div class="work_tickets_detail_container">
  <div class="work_tickets_detail_row">
    <div class="work_tickets_detail_wide">
      <div class="input-group">
        <span class="input-group-addon"><i class="fa fa-id-card-o fa-fw"></i>通知单名称</span> <input
          class="form-control work_tickets_detail_group_input" type="text" placeholder="通知单名称" value="">
        <span class="work_tickets_detail_group_type">{{if plugmode}}接入{{else}}退出{{/if}}通知单</span>
      </div>
    </div>
    <div class="work_tickets_detail_narrow">
      <div class="input-group">
        <span class="input-group-addon"><i class="fa fa-tags fa-fw"></i>编号</span> <input
          class="form-control work_tickets_detail_id_input" type="text" placeholder="编号" value="">
      </div>
    </div>
  </div>
  <div class="work_tickets_detail_row">
    <div class="work_tickets_detail_wide">
      <div class="input-group">
        <span class="input-group-addon"><i class="fa fa-id-card-o fa-fw"></i>电路名称</span> <input
          class="form-control work_tickets_detail_title_input" type="text" placeholder="电路名称" value="">
      </div>
    </div>
    <div class="work_tickets_detail_narrow">
      <div class="input-group">
        <span class="input-group-addon"><i class="fa fa-tags fa-fw"></i>用户性质</span> <input
          class="form-control work_tickets_detail_user_kind_input" type="text" placeholder="用户性质" value="">
      </div>
    </div>
  </div>
  <div class="work_tickets_detail_row">
    <div class="work_tickets_detail_wide">
      <div class="input-group">
        <span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i>要求完成时间</span> <input
          class="form-control work_tickets_detail_deadline_input" type="text" placeholder="要求完成时间" value="">
      </div>
    </div>
    <div class="work_tickets_detail_narrow">
      <div class="input-group">
        <span class="input-group-addon"><i class="fa fa-rss fa-fw"></i>通道形式</span> <input
          class="form-control work_tickets_detail_channel_kind_input" type="text" placeholder="通道形式" value="">
      </div>
    </div>
  </div>
  <div class="work_tickets_detail_separator"></div>
  <div class="work_tickets_detail_stations_container">
    <div class="work_tickets_detail_stations_list">
    </div>
    <div class="work_tickets_detail_map">
      <div class="work_tickets_detail_map_searchbox">
        <input class="work_tickets_detail_map_searchbox_input" type="text" name="word"
          autocomplete="off" maxlength="256" placeholder="搜站点、查机房、找光缆" value=""> <i
          class="fa fa-search work_tickets_detail_map_searchbtn"
          aria-hidden="true"></i>
      </div>
      <div class="work_tickets_detail_map_contentbox">
      </div>
    </div>
  </div>
  <div class="work_tickets_detail_separator"></div>
  <div class="work_tickets_detail_buttons_container">
    <button class="work_tickets_detail_button work_tickets_detail_button_cancle"
      data-izimodal-close="">取消</button>
    <button class="work_tickets_detail_button work_tickets_detail_button_submit">审核</button>
  </div>
</div>
</script>