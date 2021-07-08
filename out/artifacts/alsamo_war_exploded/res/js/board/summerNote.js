SummerNote
    .create(document.querySelector('#summernote'),{
        height: 300,
        focus: true,
        lang: "ko-KR",
        placeholder: '바르고 고운말을 사용합시다.',
        tabsize: 2,
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'underline', 'clear']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture', 'video']],
            ['view', ['fullscreen', 'codeview', 'help']]
        ]
    });