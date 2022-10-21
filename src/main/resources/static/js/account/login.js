//const loginButton = document.querySelector(".login-button");
//
//loginButton.onclick = () => {
//    const accountInputs = document.querySelectorAll(".account_input");
//
//    let user = {
//        userName: accountInputs[0].value,
//        password: accountInputs[1].value
//    }
//
//    let ajaxOption = {
//        async: false,
//        type: "post",
//        url: "/api/account/login",
//        contentType: "application/json",
//        data: JSON.stringify(user),
//        dataType: "json",
//        success: (response) => {
//            alert("로그인 요청 성공");
//            console.log(response);
//        },
//        error: (error) => {
//            alert("로그인 요청 실패");
//            console.log(error.responseJSON.userName);
//        }
//    }
//
//    $.ajax(ajaxOption);
//}

