function check(){
	var f1 = document.f1;
	if(f1.pet_type.value == ""){
		alert("请选择主题类型!");
		return false;
	}
	if(f1.pet_title.value == ""){
		alert("请填写标题");
		return false;
	}
	if(f1.pet_introd.value == ""){
		alert("请填写内容");
		return false;
	}
	if(f1.file1.value == "" && f1.file2.value == "" && f1.file3.value == ""){
		alert("必须选择一张图片");
		return false;
	}
}