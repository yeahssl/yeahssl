const size = document.getElementById('size');
const color = document.getElementById('color');
const apply = document.getElementById('apply');
const registration = document.getElementById('registration');
const content = document.getElementById('content');
const result = document.getElementById('result');



apply.addEventListener('click', () => {

    content.style.color= color.value;
    content.style.fontSize = size.value + "px";


});

// 등록버튼 클릭 시 요소를 생성하여 content에 추가

registration.addEventListener('click', () => {
    const p = document.createElement("p");// p 태그 요소 생성
    p.innerText = content.value; // content에 작성된 내용 (값)을 p의 내용으로 대입
    const contentStyle = content.getAttribute("style"); // content 스타일 얻어오기
    p.setAttribute("style", contentStyle); // content 스타일을 p에 세팅
    result.appendChild(p); // result에 추가 
});