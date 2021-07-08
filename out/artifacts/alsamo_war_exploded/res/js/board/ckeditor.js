ClassicEditor
    .create( document.querySelector('#ckeditor'),{
    ckfinder: {
        uploadUrl: '/ck/fileupload' // 내가 지정한 업로드 url (post로 요청감)
    },
    alignment: {
        options: [ 'left', 'center', 'right' ]
    }
})
    .then( editor => {
        console.log( editor );
    })
    .catch( error => {
        console.error( error );
    } );