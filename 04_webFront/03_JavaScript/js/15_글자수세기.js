document.getElementById("content").addEventListener("input", () => {
    // input 이벤트 : 입력과 관련된 모든 행동
    // input, textarea 등 입력  가능한 요소에 값이 입력되면 인식
    const text = document.getElementById("content").value;
    const span = document.getElementById("count");
    
    span.innerText = text.length;

    if(text.length > 100) {
        span.classList.add("error");
    } else { 
        span.classList.remove("error");
    }


    // 요소.classList.toggle("클래스명");
    // - 요소에 클래스가 없으면 추가 (true 반환)
    // - 요소에 클래스가 있으면 제거 (false 반환)
});


