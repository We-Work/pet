/*电话是否正确*/
var isTel = false;
function change(){
		var img = document.getElementById("securitycode");
		img.src = "/pet/SecurityCodeController?opt=create&t="+Math.random();
	}
function checkInput(){
	if(document.find_form.user_name.value == ""){
		alert("用户名不能为空");
		return false;
	}
	if(document.find_form.user_tel.value == ""){
		alert("手机号码不能为空");
		return false;
	}
	if(document.find_form.user_pwd.value == ""){
		alert("新密码不能为空");
		return false;
	}
	if(document.find_form.user_pwd.value.length < 6){
		alert("新密码不能小于6位");
		return false;
	}
	if(document.find_form.user_pwd_confirm.value == ""){
		alert("确认密码不能为空");
		return false;
	}
	if(document.find_form.user_pwd_confirm.value != document.find_form.user_pwd.value ){
		alert("两次输入密码不一致");
		return false;
	}
	if(document.find_form.securityCode.value == ""){
		alert("验证码不能为空");
		return false;
	}
	return true;
}
/*ajax验证电话号码*/

function checkTel(){
	var tel = document.find_form.user_tel.value.trim();
	var name = document.find_form.user_name.value.trim();
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
	var url = "/pet/AuthenController?type=checkTel&user_tel=" + tel + "&user_name=" + name + "&" + Math.random();
	xmlHttp.open("GET", url, true);
	setTimeout(2000);
	xmlHttp.send(null);
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
			if("success" == xmlHttp.responseText){
				isTel = true;
				document.getElementById("msg_tel").innerHTML = "";
			}else{
				isTel = false;
				document.getElementById("msg_tel").innerHTML = "电话号码错误";
			}
		}
	}
	
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
	var url = "/pet/SecurityCodeController?opt=check&code=" + document.find_form.securityCode.value+"&"+Math.random();
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
	setTimeout(null, 2000);
	return xmlHttp.onreadystatechange = function() {
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
			var state = xmlHttp.responseText;
			if("success" == state){
				document.getElementById("msg").innerHTML = "";
				if(isTel){
					document.getElementById("form1").submit();
				}
			}else{
				document.getElementById("msg").innerHTML = "验证码错误";
			}
		}
	};
	
}