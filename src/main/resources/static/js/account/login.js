// const registerButton = document.querySelector(".btn_member_join")

// registerButton.onclick = () =>{
//     const accountInput = document.querySelectorAll(".member_warning")

//     let user = {
//         Id : accountInput[0].value,
//         Password : accountInput[1].value,
//         RePassword : accountInput[2].value,
//         email : accountInput[3].value,
//         Phone : accountInput[4].value,
//         Call : accountInput[5].value,
//         Address : accountInput[6].value

//     }
//     $.ajax({
//         async: false,
//         type: "post", 
//         url: "/api/account/register", 
//         contentType: "application/json",
//         data: JSON.stringify(user), 
      
//         dataType: "json",  
//         success: (response, textStatus, request) => {    
//           console.log(response);
//           const successURL = request.getResponseHeader("Location");
//           location.replace(successURL + "?email=" + response.data)
//         },
//         error: (error) => {       
//           console.log(error.responseJSON.data);
//           loadErrorMessage(error.responseJSON.data)
//         }
//       });
//     }

const registerForWardButton = document.querySelectorAll(".btn_member_join")[0]

registerForWardButton.onclick = () =>{
  location.href = "/account/register"
}