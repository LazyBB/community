function post() {
    let questionId = $("#question-id").val();
    let comment = $("#comment-text").val();
    $.ajax({
        type:"POST",
        url:"/comment",
        contentType:'application/json',
        data:JSON.stringify({
            "parentId":questionId,
            "comment":comment,
            "type":1
        }),
        success: function (response) {
           if (response.code==200){
               $("#comment-body").hide();
           }else {
               alert(response.message);
           }
        },
        dataType:"json"
    })
}