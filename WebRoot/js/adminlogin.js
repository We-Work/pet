function change(){
		var img = document.getElementById("securitycode");
		img.src = "/pet/SecurityCodeController?opt=create&t="+Math.random();
	}
function checkInput(){
	if(document.login_form.admin_name.value == ""){
		alert("用户名不能为空");
		return false;
	}
	if(document.login_form.admin_pwd.value == ""){
		alert("密码不能为空");
		return false;
	}
	if(document.login_form.securityCode.value == ""){
		alert("验证码不能为空");
		return false;
	}
	return true;
}
/*ajax验证码*/
function checkCode(){
	if(!checkInput()){
		return false;
	}
	var xmlHttp = null;
	try{
		xmlHttp = new XMLHttpRequest();
	}catch (e) {
		try{
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}catch (e) {
			alert("抱歉!你的浏览器不支持Ajax请求");
		}
	}
	var url = "/pet/SecurityCodeController?opt=check&code=" + document.login_form.securityCode.value+"&"+Math.random();
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
	setTimeout(null, 2000);
	return xmlHttp.onreadystatechange = function() {
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
			var state = xmlHttp.responseText;
			if("success" == state){
				document.getElementById("msg").innerHTML = "";
				document.getElementById("form1").submit();
			}else{
				document.getElementById("msg").innerHTML = "验证码错误";
			}
		}
	};
	
}