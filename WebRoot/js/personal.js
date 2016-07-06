function checkInput(){
	if(document.personalForm.user_name.value == ""){
		alert("用户名不能为空");
		return false;
	}
	if(document.personalForm.user_tel.value == ""){
		alert("电话号码不能为空");
		return false;
	}
	if(document.personalForm.user_address.value==""){
		alert("请填写地址");
		return false;
	}
	return true;
}