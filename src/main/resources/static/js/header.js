function loadHeader() {
    let principal = Principal.getInstance().getPrincipal();
    console.log(principal);

    const principalList = document.querySelector(".sns_nav");

    if(principal == "") {
        principalList.innerHTML = `
            <li><a href="/account/login">로그인</a></li>
            <li><a href="/account/register">회원가입</a></li>
            <li><a href="/order/cart">장바구니0</a></li>
            <li><a href="#">고객센터</a></li>
            <li><a href="#"><img src="/static/img/header/top_btn_search.png" alt=""></a></li>
        `;
    } 
    else{
        principalList.innerHTML = `
            <li><a href="/logout">로그아웃</a></li>
            <li><a href="/order/cart">장바구니0</a></li>
            <li><a href="/mypage/index">마이페이지</a></li>
            <li><a href="#">고객센터</a></li>
            <li><a href="#"><img src="/static/img/header/top_btn_search.png" alt=""></a></li>
        `;
    }

}

loadHeader();