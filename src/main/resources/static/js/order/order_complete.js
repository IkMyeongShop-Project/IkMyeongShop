const homeButton = document.querySelector(".home-button");
const loginButton = document.querySelector(".login-button");

homeButton.onclick = () => {
  location.href = "/goods/all";
}

loginButton.onclick = () => {
  location.href = "/";
}