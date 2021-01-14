// JavaScript source code

function chk() {
    if (!frm.pw.value) {
        alert("비밀번호를 입력하세요.")
        frm.pw.focus();
        return false;
    } else if (frm.pw.value != frm.pwChk.value) {
        alert("확인번호가 비밀번호와 일치하지 않습니다.")
        frm.pw.value = "";
        frm.pwChk.value = "";
        frm.pw.focus();
        return false;
    }
    return true;
}