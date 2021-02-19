function validation(){
	if(document.getElementById("custName").value==0) {
		alert("회원성명 미입력");
		document.getElementById("custName").focus();
		return false;
	}
	if(document.getElementById("phone").value==0){
		alert("회원전화 미입력");
		document.getElementById("phone").focus();
		return false;
	}
	if(document.getElementById("address").value==0){
		alert("회원주소 미입력");
		document.getElementById("address").focus();
		return false;
	}
	if(document.getElementById("grade").value==0){
		alert("고객등급 미입력");
		document.getElementById("grade").focus();
		return false;
	}
	if(document.getElementById("city").value==0){
		alert("도시코드 미입력");
		document.getElementById("city").focus();
		return false;
	}
	return true;
}

function update(){
	if(validation()){
		alert("등록완료");
		document.getElementById("join").submit();
	}
}

function toList(){
	alert("목록으로");
	window.location.href="/ncs_java_yhs2/index.jsp?pp=list"
}