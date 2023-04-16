function bell(){
    document.getElementById("bellDropdown").classList.toggle("show");
}

window.onclick = function(e){
    if (e.target.matches('.dropBtn1')) {
        var dropdowns = document.getElementById("bellDropdown");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}

function my(){
    document.getElementById("myDropdown").classList.toggle("show");
}

window.onclick = function(e){
    if (!e.target.matches('.dropBtn2')) {
        var dropdowns = document.getElementById("myDropdown");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}