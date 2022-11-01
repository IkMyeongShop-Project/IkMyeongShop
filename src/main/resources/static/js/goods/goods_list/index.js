class CollectionsApi {
    static #instance = null;

    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new CollectionsApi();
        }
        return this.#instance;
    }

    getCollections(page) {
        let responseData = null;

        const url = location.href;
        const category = url.substring(url.lastIndexOf("/") + 1);

        $.ajax({
            async: false,
            type: "get",
            url: "/api/collections/" + category,
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

class PageScroll {
    static #instance = null;

    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new PageScroll();
        }
        return this.#instance;
    }
     
    addScrollPagingEvent() {
        const html = document.querySelector("html");
        const body = document.querySelector("body");

        body.onscroll = () => {
            let scrollStatus = body.offsetHeight - html.clientHeight - html.scrollTop;
            console.log("현재 스크롤 상태: " + scrollStatus);
            if(scrollStatus > -50 && scrollStatus < 50) {
                const nowPage = CollectionsService.getInstance().collectionsEntity.page;
                CollectionsService.getInstance().collectionsEntity.page = Number(nowPage) + 1;
                CollectionsService.getInstance().loadCollections();
            }

        }
    }

}
class CollectionsService {
    static #instance = null;

    static getInstance() {
        if(this.#instance == null) {    
            this.#instance = new CollectionsService();
        }
        return this.#instance;
    }

    pdtIdList = null;

    
    collectionsEntity = {
        page: 1,
        totalCount: 0,
        maxPage: 0
    }
    
    constructor() {
        this.pdtIdList = new Array();
    }

    loadCollections() {
        if(this.collectionsEntity.page == 1 || this.collectionsEntity.page < Number(this.collectionsEntity.maxPage) + 1) {
            const responseData = CollectionsApi.getInstance().getCollections(this.collectionsEntity.page);
            console.log(responseData);
            if(responseData.length > 0) {
                this.collectionsEntity.totalCount = responseData[0].productTotalCount;
                this.collectionsEntity.maxPage = responseData[0].productTotalCount % 16 == 0 
                                                ? responseData[0].productTotalCount / 16
                                                : Math.floor(responseData[0].productTotalCount / 16) + 1;
                this.getCollections(responseData);
            }else {
                alert("해당 카테고리에 등록된 상품 정보가 없습니다.");
                location.href = "/collections/all";
            }
        }
    }
    getCollections(responseData) {
        const collectionProducts = document.querySelector(".item_galley_type");

        responseData.forEach(product => {
            this.pdtIdList.push(product.productId);
            collectionProducts.innerHTML += `
            <li>
            <div class="item_cont">
                <div class="item_photo_box">
                    <img src="/static/img/items/${product.mainImg}">
                </div>
                <div class="item_info_cont">
                    <div class="item_name">
                        ${product.productName}
                    </div>
                    <div class="item_money_box">
                        <span>
                        ${product.productPrice}원
                        </span>
                    </div>
            </li>
            `;
        });
        this.addProductListEvent();
    }

    addProductListEvent(){
        const collectionProducts = document.querySelectorAll(".item_galley_type");

        collectionProducts.forEach((product, index)=>{
            product.onclick = () =>{
                location.href = "/product/" + this.pdtIdList[index];
            }
        })
    }
}
window.onload = () => {
    CollectionsService.getInstance().loadCollections();
    PageScroll.getInstance().addScrollPagingEvent();
}