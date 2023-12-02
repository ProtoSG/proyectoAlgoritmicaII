const wrapper = document.querySelector('.wrapper');
const loginLink = document.querySelector('.login-link');
const registerLink = document.querySelector('.register-link');

registerLink.addEventListener('click', ()=>{
    wrapper.classList.add('active');
});

loginLink.addEventListener('click', ()=>{
    wrapper.classList.remove('active');
});

function uncheck() {
    var checkbox1 = document.getElementById("alumno");
    var checkbox2 = document.getElementById("profesor");
    const carreraProfesional = document.getElementById("carreraProfesional");
    checkbox1.addEventListener('change', function () {
        if (checkbox1.checked) {
            checkbox2.checked = false;
            carreraProfesional.style.display = 'none';
        }
    });

    checkbox2.addEventListener('change', function () {
        if (checkbox2.checked) {
            checkbox1.checked = false;
            carreraProfesional.style.display = 'block';
        }else{
            carreraProfesional.style.display = 'none';
        }    
    });
}