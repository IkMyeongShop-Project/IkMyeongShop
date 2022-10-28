const homeButton = document.querySelector(".home-button");
const loginButton = document.querySelector(".login-button");

homeButton.onclick = () => {
  location.href = "/";
}

loginButton.onclick = () => {
  location.href = "/account/login";
}

const str = window.location.href.split("=").at(-1);

const textSub = document.querySelector(".text-sub");
textSub.innerHTML = `<strong>${str}</strong>님의 회원가입을 축하합니다.`;