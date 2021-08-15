<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="swiper-container">
    <div class="swiper-wrapper">
        <div class="swiper-slide"><img id="jack" data-name="잭_대니얼스" title="잭_대니얼스, 위스키"
                                       width=240px
                                       src="/res/swiper/jack.png"></div>
        <div class="swiper-slide"><img id="jim" data-name="짐빔" title="짐빔, 위스키" width=240px
                                       onclick="searchAl('jim');"
                                       src="/res/swiper/Jim.png"></div>
        <div class="swiper-slide"><img id="hose" data-name="호세_쿠엘보" title="호세_쿠엘보, 데킬라"
                                       width=240px
                                       src="/res/swiper/Jose.png"></div>
        <div class="swiper-slide"><img id="bacadi" data-name="바카디" title="바카디 화이트, 럼"
                                       width=240px
                                       src="/res/swiper/bacardiWhite.png"></div>
        <div class="swiper-slide"><img id="captain" data-name="" title="캡틴모건, 럼"
                                       width=240px
                                       src="/res/swiper/captain.png"></div>
        <div class="swiper-slide"><img id="maker" data-name="" title="메이커스 마커, 위스키"
                                       width=240px src="/res/swiper/maker.png"></div>
        <div class="swiper-slide"><img id="callua" data-name="" title="칼루아, 리큐어"
                                       width=240px src="/res/swiper/callua.png"></div>
        <div class="swiper-slide"><img id="valentain" data-name="" title="발렌타인, 위스키"
                                       width=240px src="/res/swiper/valentain.png"></div>
        <div class="swiper-slide"><img id="vodca1" data-name="" title="앱솔루트, 보드카"
                                       width=240px src="/res/swiper/vodca1.png"></div>
        <div class="swiper-slide"><img id="yegger" data-name="" title="예거마이스터, 리큐어"
                                       width=240px src="/res/swiper/yegger.png"></div>
        <div class="swiper-slide"><img id="bom" data-name="" title="붐베이, 진"
                                       width=240px src="/res/swiper/bom.png"></div>
    </div>
    <%-- 네이게이션 버튼 --%>
    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>
    <%--스크롤바 --%>
    <div class="swiper-scrollbar"></div>
</div>
<div class="py-4 bg-light mt-auto">
    <div class="d-flex align-items-center justify-content-between small">
        <div class="text-muted">Copyright 2021. Alsamo All pictures cannot be copied without permission.</div>
        <div>
            <i class="fab fa-github"></i> <a href="https://github.com/jincheol2578">JINCHEOL KIM</a>
            &middot;
            <i class="fab fa-github"></i> <a href="https://github.com/heckevil">heckevil</a>
        </div>
    </div>
</div>
<script>
    var swiper = new Swiper('.swiper-container', {
        slidesPerView: 3,
        spaceBetween: 6,
        slidesPerGroup: 3,
        loopFillGroupWithBlank: true,

        loop: false,
        loopAdditionalSlides: 1,
        pagination: false,
        autoplay: {
            delay: 5500,
            disableOnInteraction: false,
        },
        navigation: {
            nextEl: '.swiper-button-next', // 다음 버튼
            prevEl: '.swiper-button-prev', // 이번 버튼
        },
        scrollbar: {
            el: ".swiper-scrollbar",
            hide: true,
        },
    });
</script>