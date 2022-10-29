class GoodsApi {
    static #instance = null;

    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new GoodsApi();
        }
        return this.#instance;
    }

    getGoods(page) {
        const responseData = null;

        const url = location.href;
        const category = url.substring(url.lastIndexOf("/") + 1);

        $.ajax({
            async: false,
            type: "get",
            url: "/api/goods/" + category,
            data: {
                "page": page
            },
            dataType: "json",
            success: (response) => {
                responseData = response.data;
            },
            error: (error) => {
                console.log(error);
            }
        });
        return responseData;
    }
}

class PageNumber {
    #page = 0;
    #pageNumberList = null;

    constructor(page, totalCount) {
        this.#page = page;
        this.#pageNumberList = document.querySelector(".page-number-list");
        this.loadPageNumber();

    }

    loadPageNumber() {
        this.createNumberButtons();
    }

    createNumberButtons() {
        for(let i = startIndex; i <= endIndex; i++) {
            this.#pageNumberList.innerHTML += `
                <a href="javascript:void(0)"><li>${i}</li></a>
            `;
        }
    }
}

class GoodsService {
    static #instance = null;

    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new GoodsService();
        }
        return this.#instance;
    }

    goodsEntity = {
        page: 1,
        totalCount: 0
    }

    loadGoods() {
        const responseData = GoodsApi.getInstance().getGoods(this.goodsEntity.page);
        console.log(responseData);
        if(responseData.length > 0) {
            this.goodsEntity.totalCount = responseData[0].productTotalCount;
            new PageNumber(this.goodsEntity.page, this.goodsEntity.totalCount);
            this.getGoods(responseData);
        }else {
            alert("해당 카테고리에 등록된 상품 정보가 없습니다.");
            location.href = "/goods/all"
        }
    }

    getGoods(responseData){
        const goodProducts = document.querySelector(".goods-products");
        goodProducts.innerHTML = '';

        responseData.forEach(product => {
            goodProducts.innerHTML = `
            <li class="goods-product">
                <div class="product-img">
                    <img src="/static/img/goods/goods_list/cup.jpg">
                </div>
                <div class="product-name">${product.productName}</div>
                <hr>
                <div class="product-price">${product.productPrice}</div>
            </li>
            `;
            
        });

    }
}


window.onload = () => {
    GoodsService.getInstance().loadGoods();
}