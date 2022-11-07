class CommonApi {
  static #instance = null;
  
  static getInstance() {
    if(this.#instance == null) {
      this.#instance = new CommonApi();
    }
    return this.#instance;
  }

  getProduct() {
    let responseResult = null;

    const url = location.href;
    let urlList = new Array();
    urlList = url.split("/");
    const pdtId = urlList[urlList.length-2];
    const pdtDesign = decodeURI(urlList[urlList.length-1]); 
    $.ajax ({
      async: false,
      type: "get",
      url: "/api/admin/product/" + pdtId + "/"+ pdtDesign,
      dataType: "json",
      success: (response) => {
        responseResult = response.data;
        console.log(response.data);
      },
      error: (error) => {
        console.log(error);
      }
    });

    return responseResult;
  }
}

class ProductService {
  productData = null;

  constructor(product) {
    this.productData = product;
    this.readProduct();
  }

  readProduct() {  // pdtId, pdtDtlId 필요? 
    const registHeader = document.querySelector(".regist-header");
    registHeader.innerHTML = `
    <input type="hidden" class="product-inputs" value=${this.productData.id}>
    <input type="hidden" class="product-inputs" value=${this.productData.pdtDtlId}>
    <div class="update-list">
    </div>
    <div class="update-list">
    </div>
    <div class="update-list">
    </div>
    `;
    const updateList = document.querySelectorAll(".update-list");
    updateList[0].innerHTML = "";
    updateList[0].innerHTML = ` 가격 :
    <input type="text" class="product-inputs numberChk" value=${this.productData.pdtPrice} placeholder="가격">`;
    updateList[1].innerHTML = "";
    updateList[1].innerHTML = ` 디자인 :
    <input type="text" class="product-inputs" value=${this.productData.pdtDesign} placeholder="디자인">`;
    updateList[2].innerHTML = "";
    updateList[2].innerHTML = ` 재고 :
    <input type="text" class="product-inputs numberChk" value=${this.productData.pdtStock} placeholder="재고">`;
  }
}

window.onload = () => {
  new ProductService(CommonApi.getInstance().getProduct());
}