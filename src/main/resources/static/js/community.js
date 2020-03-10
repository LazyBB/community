/*
上传评论
 */
function post() {
    let questionId = $("#question-id").val();
    let comment = $("#comment-text").val();
    PostComment(questionId,1,comment);
}
function PostComment(targetId,type,comment) {
    if (!comment) {
        alert("回复不能为空~~");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "parentId": targetId,
            "comment": comment,
            "type": type
        }),
        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
            } else {
                if (response.code == 100) {
                    let isAccept = confirm(response.message);
                    if (isAccept) {
                        window.open("https://github.com/login/oauth/authorize?client_id=427b838bf362dea7e8fe&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        window.localStorage.setItem("isClose", true);
                    }
                } else {
                    alert(response.message);
                }
            }
        },
        dataType: "json"
    })

}

function comment(e) {
    let commentId = e.getAttribute("data-id");
    let comment =$("#reply-"+commentId).val();
    PostComment(commentId,2,comment);
}
/*
  二级评论控制
*/
function collapseComment(e) {
    let id = e.getAttribute("data-id");
    let comments =$("#comment-"+id);
    var collapse = e.getAttribute("data-collapse");
    if (collapse){
        comments.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("menu-active");
    }else {
        var subCommentContainer = $("#comment-" + id);
        if (subCommentContainer.children().length != 1) {
            //展开二级评论
            comments.addClass("in");
            // 标记二级评论展开状态
            e.setAttribute("data-collapse", "in");
            e.classList.add("menu-active");
        }else {
            $.getJSON("/comment/" + id, function (data) {
                $.each(data.data.reverse(), function (index, comment) {
                    var mediaLeftElement = $("<div/>", {
                        "class": "media-left"
                    }).append($("<img/>", {
                        "class": "media-object img-rounded",
                        "src": comment.user.avatarUrl
                    }));

                    var mediaBodyElement = $("<div/>", {
                        "class": "media-body"
                    }).append($("<h5/>", {
                        "class": "media-heading",
                        "html": comment.user.name
                    })).append($("<div/>", {
                        "html": comment.comment
                    })).append($("<div/>", {
                        "class": "menu"
                    }).append($("<span/>", {
                        "class": "pull-right",
                        "html": moment(comment.gmtCreate).format('YYYY-MM-DD')
                    })));

                    var mediaElement = $("<div/>", {
                        "class": "media"
                    }).append(mediaLeftElement).append(mediaBodyElement);

                    var commentElement = $("<div/>", {
                        "class": "col-lg-12 col-md-12 col-sm-12 col-xs-12 comments"
                    }).append(mediaElement);

                    subCommentContainer.prepend(commentElement);
                });
                //展开二级评论
                comments.addClass("in");
                // 标记二级评论展开状态
                e.setAttribute("data-collapse", "in");
                e.classList.add("menu-active");
            });
        }
    }
}

function showSelectTag() {
    $("#select-tag").show();
}

function selectTag(e) {
    var value = e.getAttribute("data-tag");
    var previous = $("#tag").val();
    if (previous.indexOf(value) == -1) {
        if (previous) {
            $("#tag").val(previous + ',' + value);
        } else {
            $("#tag").val(value);
        }
    }
}
