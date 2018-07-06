<c:forEach items="${essays.getEssays()}" var="data" varStatus="index">
  <article class="box post post-excerpt">
    <header>
      <h2>
        <a href="essay.do?essayId=${data.getId()}" target="_blank">${data.getTitle()}</a>
      </h2>
      <p>
        <img src="${data.getAuthorAvatar()}" />${data.getAuthor()}
      </p>
    </header>
    <div class="info">
      <span class="date"><span class="month">${data.getCreateMonth()}<span>${data.getCreateMonthSuffix()}</span></span>
        <span class="day">${data.getCreateDay()}</span><span class="year">,
          ${data.getCreateYear()}</span></span>
      <ul class="stats">
        <li><a href="#" class="icon fa-comment">${data.getComment()}</a></li>
        <li><a href="#" class="icon fa-heart">${data.getHeart()}</a></li>
        <li><a href="#" class="icon fa-twitter">${data.getTwitter()}</a></li>
        <li><a href="#" class="icon fa-facebook">${data.getFacebook()}</a></li>
      </ul>
    </div>
    <div class="container">
      <div class="mhn-slide owl-carousel">
        <c:forEach items="${data.getBooks()}" var="book">
          <div class="mhn-item">
            <div class="mhn-inner">
              <img src="${book.getCover()}">
              <div class="mhn-img">
                <div class="loader-circle">
                  <div class="loader-stroke-left"></div>
                  <div class="loader-stroke-right"></div>
                </div>
              </div>
              <div class="mhn-text">
                <h4>《${book.getName()}》</h4>
                <p>
                  <i class="icon fa-copyright" style="margin-right: 2px;"></i>${book.getAuthor()}</p>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
    <p>
      <strong>${data.getKeyword()}</strong> ${data.getDescription()}
    </p>
    <p>
      <a href="essay.do?essayId=${data.getId()}" target="_blank"><span
        class="contentForAll">查看全文</span></a>
    </p>
  </article>
</c:forEach>
