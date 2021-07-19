<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="border-end bg-white" id="sidebar-wrapper">
    <div class="sidebar-heading border-bottom bg-light">Alsamo</div>
    <div class="list-group list-group-flush">
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/board/list">게시판</a>
        <%--        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#"></a>--%>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/alcohol/alcoholList">알콜
            위키</a>
    </div>
    <%-- Swiper --%>
    <div id="swContainer">
        <div class="swiper-container">
            <div class="swiper-wrapper">
                <div class="swiper-slide"><img title="잭다니얼스, 위스키" width=240px src="/res/swiper/jack.png"></div>
                <div class="swiper-slide"><img title="짐빔, 위스키" width=240px src="/res/swiper/Jim.png"></div>
                <div class="swiper-slide"><img title="호세꾸엘보, 데킬라" width=240px src="/res/swiper/Jose.png"></div>
                <div class="swiper-slide"><img title="바카디 화이트, 럼" width=240px src="/res/swiper/bacardiWhite.png"></div>
                <div class="swiper-slide"><img title="캡틴모건, 럼" width=240px src="/res/swiper/captain.png"></div>
                <div class="swiper-slide"><img title="메이커스 마커, 위스키" width=240px src="/res/swiper/maker.png"></div>
            </div>
        </div>
    </div>
</div>

<script>
    var swiper = new Swiper('.swiper-container', {
        slidesPerView: 'auto',
        spaceBetween: 6,
        loop: false,
        loopAdditionalSlides: 1,
        pagination: false,
        autoplay: {
            delay: 2000,
            disableOnInteraction: false,
        },
    });


</script>