$("#summernote").summernote({
    height: 300,
    minHeight: null,
    maxHeight: null,
    // 에디터로 커서이동 autofocus와 같음
    focus: true,
    toolbar: [
        ['fontname', ['fontname']],
        // 폰트 크기 설정
        ['fontsize', ['fontsize']],
        // 폰트 스타일
        ['style', ['bold', 'italic', 'underline', 'strikethrough', 'clear']],
        // 글자 색
        ['color', ['forecolor', 'color']],
        // 글머리 번호, 번호, 문단 정렬
        ['para', ['ul', 'ol', 'paragraph']],
        // 표만들기
        ['table', ['table']],
        // 링크, 사진, 영상 첨부
        ['insert', ['link', 'picture', 'video']],
        // 확대해서 보기, 코드보기, 도움말
        ['view', ['fullscreen', 'codeview', 'help']]
    ],
    // 추가한 폰트
    fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
    // 추가한 폰트사이즈
    fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
    lang: 'ko-KR',
    placeholder: '바르고 고운말을 사용합시다.',
    tabsize: 2,
    callbacks: {
        onImageUpload: function (files, editor, welEditable) {
            // 파일 업로드(다중업로드를 위해 반복문 사용)
            for (var i = files.length - 1; i >= 0; i--) {
                uploadSummernoteImageFile(files[i], this);
            }
        }
    }
});

function uploadSummernoteImageFile(file, editor) {
    data = new FormData();
    data.append("file", file);
    $.ajax({
        data: data,
        type: "POST",
        url: "/uploadSummernoteImageFile",
        contentType: false,
        enctype: 'multipart/form-data',
        processData: false,
        success: function (data) {
            $(editor).summernote('insertImage', data.url);
        }
    });
}
