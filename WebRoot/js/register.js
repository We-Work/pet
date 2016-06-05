//更改验证码
function change(){
		var img = document.getElementById("securitycode");
		img.src = "/pet/SecurityCodeController?opt=create&t="+Math.random();
	}

var b_name = false;

//检查用户名使用可用
function checkName(){
	var name = document.login_form.user_name;
	if(name.value == ""){
		document.getElementById("msg_name").innerHTML = "<img height='21px' src='/pet/images/error.jpg'><lable style='color:red'>用户名不能为空</lable>"
	}else{
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
		xmlHttp.onreadystatechange = function(){
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
				var txt = xmlHttp.responseText;
				if("enable" == txt){
					document.getElementById("msg_name").innerHTML = "<img height='21px' src='/pet/images/right.jpg'>";
					b_name = true;
				}else if("disable" == txt){
					document.getElementById("msg_name").innerHTML = "<img height='21px' src='/pet/images/error.jpg'><lable style='color:red'>用户名已被使用</lable>"
				}
			}
		}
		var url = "/pet/TestController?user_name=" + name.value;
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
	}
}
//检查密码
function checkPassword(){
	var pwd = document.login_form.user_pwd;
	if(pwd.value == ""){
		document.getElementById("msg_pwd").innerHTML = "<img height='21px' src='/pet/images/error.jpg'><lable style='color:red'>密码不能为空</lable>";
	}else{
		if(pwd.value.toString().length < 6){
			document.getElementById("msg_pwd").innerHTML = "<img height='21px' src='/pet/images/error.jpg'><lable style='color:red'>密码必须大于6个字节</lable>";
		}else{
			document.getElementById("msg_pwd").innerHTML = "<img height='21px' src='/pet/images/right.jpg'>";
		}
	}
}
//检查手机号码
function checkTel(){
	var tel = document.login_form.user_tel;
	if(tel.value == ""){
		document.getElementById("msg_tel").innerHTML = "<img height='21px' src='/pet/images/error.jpg'><lable style='color:red'>密码不能为空</lable>";
	}else{
		document.getElementById("msg_tel").innerHTML = "<img height='21px' src='/pet/images/right.jpg'>";
	}
}





function checkInput(){
	if(document.login_form.user_name.value == "" && b_name){
		alert("用户名不能为空");
		return false;
	}
	if(document.login_form.user_pwd.value == ""){
		alert("密码不能小于6个字节");
		return false;
	}
	if(document.login_form.securityCode.value == ""){
		alert("验证码不能为空");
		return false;
	}
	if(document.login_form.user_tel.value == ""){
		alert("联系电话不能为空");
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
				document.getElementById("msg_code").innerHTML = "";
				document.getElementById("form1").submit();
			}else{
				document.getElementById("msg_code").innerHTML = "<img height='21px' src='/pet/images/error.jpg'><lable style='color:red'>验证码错误</lable>";
			}
		}
	};
	
}