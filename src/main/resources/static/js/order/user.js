//select와 input 엘리먼트를 가져옴
const emailSelect = document.querySelector("emailDomain");
const emailInput = document.querySelector(".input-email");

//select 값이 변경될 때마다 실행되는 함수
function onChangeEmail() {
    const selectValue = emailSelect.value;
    //직접입력이 아닌 경우에만 처리하기 위해 if문 사용
    if (selectValue != "self") {
        const inputValue = emailInput.value;
        //직접 입력한 값이 도메인을 포함하지 않는 경우에만 추가되도록 하기 위해 if함수 추가.
        if (!inputValue.includes(selectValue)) {
            emailInput.value = inputValue + "@" + selectValue;
        }
    }
}


// class emailDomain {
//     constructor() {
//         this.emailDomain = document.querySelector("#emailDomain");
//         this.principalEmail = document.querySelector(".input-email");

//         this.emailDomain.addEventListener('change', () => {
//             if ()
//         })
//     }

// }