class ProductApi {
    static #instance = null;
    static getInstace() {
        if(this.#instance == null) {
            this.#instance = new ProductApi();
        }
        return this.#instance;
    }

    getProductData() {
        let responseData = null;
        const url = location.href;
        const pdtId = url.substring(url.lastIndexOf("/") + 1);

        $.ajax({
            async: false,
            type: "get",
            url: "/api/product/" + pdtId,
            dataType: "json",
            success: response => {
                responseData - response.data;
            },
            error: error => {
                console.log(error);
            }
        });
        return responseData;
    }

}

class ProductDetail {

    constructor() {
        const responseData = ProductApi.getInstace().getProductData();
        this.loadProductDetail(responseData);
    }

    loadProductImgs(responseData) {
        const productImages = document.querySelector(".item_photo_view");
        productImages.innerHTML =``;

        responseData.pdtImgs.forEach(img => {
            productImages.innerHTML = `
            <div class="item_photo">
                <img src="/static/img/goods/goods_list/cup.jpg" alt="">
                <div class="slick-list.draggable">
                    <div class="mini_img">
                        <img class="img_cl" src="/static/upload/product/${img}" alt="cup">
                    </div>
                </div>
            </div>
            `;
        })
    }

    loadProductDetail(responseData) {
        document.querySelector(".goods-title").textContent = responseData.pdtName;
        document.querySelector(".item_price").textContent = responseData.pdtPrice;
    }

    loadProductDesigns(responseData) {
        const productDesigns = document.querySelector(".option_bar");
        productDesigns.innerHTML = ``;

        Object.keys(responseData.pdtDesign).forEach(design => {
            productDesigns.innerHTML += `
            <option value="${design}">${design} : ${stock} + "개"</option>
            `;
        }) //<option type="radio" id="item-design--${value.pdtDesign} value="${design}" ${value.pdtStock == 0 ? 'disabled' : ''}>${design} : ${stock} + "개"</option>

    }


}

window.onload = () => {
    console.log(ProductApi.getInstace().getProductData());
    new ProductDetail();
}