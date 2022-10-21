const btnComfirm = document.querySelector(".btn_comfirm");

btnComfirm.onclick = () => {
    const accountInpus = document.querySelectorAll(".caaount_inputs");

    let user = {
        userName: accountInpus[0].value,
        password: accountInpus[1].value,
        passwordChk: accountInpus[2].value,
        name: accountInpus[3].value,
        email: accountInpus[4].value
    }

    $.ajax({
        async: false,
        type: "post",
        url: "/api/account/register",
        contentType: "application/json",
        data: JSON.stringify(user),
        dataType: "json",
        success: (response) => {
            alert("회원가입 요청 성공");
            console.log(response);
        },
        error: (error) => {
            alert("회원가입 요청 실패");
            console.log(error.responseJSON.data);
            loadErrorMassage(error.responseJSON.data);
        }
    });
}

function loadErrorMassage(errors) {
    const errorList = document.querySelector(".errors")
    const errorMags = document.querySelector(".error-msgs");
    const errorArray = Object.values(errors)
    
    errorMags.innerHTML = "";

    errorArray.forEach(error => {
        errorMags.innerHTML += `
        <li>${error}</li>
        `;
    });

    errorList.classList.remove("errors-invisible");

}