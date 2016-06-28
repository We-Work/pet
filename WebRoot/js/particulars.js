function showReplyBox(box,auth){
	$(document).ready(function(){
		$(".rp_box").html("");
	});
	
	if(checkAuthen(auth)){
		document.getElementById("reply_box"+box.id).innerHTML = "" +
		"<form action='ReplyController' method='post'>"+
		"<div class='rp_box_in'>"+
		"<div><strong>发表回复</strong></div>"+
		"<textarea id='txt_reply' name='reply_content' rows='5' cols='95'></textarea>"+
		"<input type='hidden' name='reply_comment_id' value='"+ box.id +"'>"+
		"<input type='hidden' name='type' value='addReply'>"+
		"<div class='rp_box_btn'><input type='submit' value='提交'></div>"+
		"</div>"+
		"</form>";
	}
}

function checkAuthen(auth){
	if(auth == "false"){
		alert("你需要登录才可以发表评论");
		document.getElementById("txt_comment").readOnly=true;
		if(document.getElementById("txt_reply")){
			document.getElementById("txt_reply").readOnly=true;
		}
		return false;
	}else{
		return true;
	}
}