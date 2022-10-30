const btnConfirm = document.querySelector(".btn_confirm");

btnConfirm.onclick = () => {
    const accountInputs = document.querySelectorAll(".account-input");

    let user = {
        username: accountInputs[0].value,
        password: accountInputs[1].value,
        checkPassword: accountInputs[2].value,
        name: accountInputs[3].value,
        email: accountInputs[4].value,
        cellphone: accountInputs[5].value,
        phone: accountInputs[6].value,
        address: accountInputs[7].value
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
        }
    }); 
}

function loadErrorMessage(errors){
    
    const errorsArray = Object.values(errors);
    errorsArray.forEach(error => {
        alert(error);
    });
}
