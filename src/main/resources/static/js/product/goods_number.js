class GoodsApi {
    static #instance = null;

    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new GoodsApi();
        }
        return this.#instance;
    }

    getGoods(page, limitCount) {
        let responseData = null;

        const url = location.href;
        const category = url.substring(url.lastIndexOf("/") + 1);

        $.ajax({
            async: false,
            type: "get",
            url: "/api/goods/" + category,
            data: {
                "page": page,
                "limitCount": limitCount
            },
            dataType: "json",
            success: (response) => {
                responseData = response.data;
                console.log(responseData);
            },
            error: (error) => {
                console.log(error);
            }
        });
        console.log(responseData);
        return responseData;
    }
}

class PageNumber {
    #page = 0;
    #maxPageNumber = 0;
    #pageNumberList = null;
    #totalCount = 0;
    #limitCount = 0;
    constructor(page, totalCount, limitCount) {
        this.#limitCount = limitCount
        this.#page = page;
        this.#maxPageNumber = totalCount % this.#limitCount == 0 ? Math.floor(totalCount / this.#limitCount) : Math.floor(totalCount / this.#limitCount) + 1;
        this.#pageNumberList = document.querySelector(".page-number-list");
        this.#pageNumberList.innerHTML = "";
        this.#totalCount = totalCount;
        this.loadPageNumber();
    }

    loadPageNumber() {
        this.createPreButton();
        this.createNumberButtons();
        this.createNextButton();
        this.addPageButtonEvent();
        this.getPickListNum();
    }

    createPreButton() {
        if(this.#page != 1) {
            this.#pageNumberList.innerHTML += `
                <a href="javascript:void(0)"><li>&#60;</li></a>
            `;
        }
    }

    
    createNumberButtons() {
        const startIndex = this.#page % 16 == 0 ? this.#page - 16 : this.#page - (this.#page % 16) + 1;
        const endIndex = startIndex + 4 <= this.#maxPageNumber ? startIndex + 4 : this.#maxPageNumber;

        for(let i = startIndex; i <= endIndex; i++) {
            this.#pageNumberList.innerHTML += `
                <a href="javascript:void(0)"><li>${i}</li></a>
            `;
        }
    }

    createNextButton() {
        if(this.#page != this.#maxPageNumber) {
            this.#pageNumberList.innerHTML += `
                <a href="javascript:void(0)"><li>&#62;</li></a>
            `;
        }
    }

    addPageButtonEvent() {
        const pageButtons = this.#pageNumberList.querySelectorAll("li");
        pageButtons.forEach(button => {
            button.onclick = () => {
                if(button.textContent == "<") {
                    const nowPage = GoodsService.getInstance().goodsEntity.page;
                    GoodsService.getInstance().goodsEntity.page = Number(nowPage) - 1;
                    GoodsService.getInstance().loadGoods();

                }else if(button.textContent == ">") {
                    const nowPage = GoodsService.getInstance().goodsEntity.page;
                    GoodsService.getInstance().goodsEntity.page = Number(nowPage) + 1;
                    GoodsService.getInstance().loadGoods();

                }else {
                    const nowPage = GoodsService.getInstance().goodsEntity.page;
                    if(button.textContent != nowPage){
                        GoodsService.getInstance().goodsEntity.page = button.textContent;
                        GoodsService.getInstance().loadGoods();
                    }
                }
            }
        });
    }

    getPickListNum() {
      const pickListNum = document.querySelector(".pick_list_num");
      pickListNum.innerHTML = "";
      console.log(this.#totalCount);
      pickListNum.innerHTML = `
      <h4>상품 ${this.#totalCount} 개</h4>
      `;
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
        totalCount: 0,
        limitCount: 16
    }

    loadGoods() {
        const responseData = GoodsApi.getInstance().getGoods(this.goodsEntity.page, this.goodsEntity.limitCount);
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
            goodProducts.innerHTML += `
            <li class="goods-product">
                <div class="product-img">
                    <img src="/static/img/goods/goods_list/cup.jpg">
                </div>
                <div class="product-name">${product.productName}</div>
                <div class="product-price">${product.productPrice}</div>
            </li>
            `;
            
        });

    }
}

class CategoryName {
    static #instance = null;

    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new CategoryName();
        }
        return this.#instance;
    }

    getCategoryName() {
        const locationTit = document.querySelector(".location_tit");
        const goodsList = document.querySelector(".goods_list");
        
        const url = location.href;
        const categoryName = decodeURI(url.substring(url.lastIndexOf("/") + 1));
        locationTit.innerHTML = "";
        goodsList.innerHTML = "";

        locationTit.innerHTML = `
        <a href="#">${categoryName}></a>
        `;

        goodsList.innerHTML = `
        <h2>${categoryName}</h2>
        `;
        console.log(categoryName);
    }

}

window.onload = () => {
    GoodsService.getInstance().loadGoods();
    CategoryName.getInstance().getCategoryName();

}