// 이 파일 자체가 Script 태그 라고 생각

/* 범위 주석 */

function btnClick2(){
    alert("external 버튼이 클릭됨");
}

// 라이트모드
function lightMode(){
    const body = document.querySelector("body");

    // ** JS는 카멜 표기법! **
    body.style.backgroundColor = 'white';
    body.style.color = 'black';

}

// 다크모드
function darkMode(){
    const body = document.querySelector("body");

    // ** JS는 카멜 표기법! **
    body.style.backgroundColor = 'black';
    body.style.color = 'white';
}