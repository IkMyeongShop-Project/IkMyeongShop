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
  static #instance = null;
  
  static getInstance() {
    if(this.#instance == null) {
      this.#instance = new ProductService();
    }
    return this.#instance;
  }
  readProduct() {
    const responseData = CommonApi.getInstance().getProduct();
    const updateList = document.querySelectorAll(".update-list");
    console.log(responseData[0]);
    console.log(responseData.pdtPrice);
    console.log(responseData.pdtDesign);
    console.log(responseData.pdtStock);
    updateList[0].innerHTML = "";
    updateList[0].innerHTML = ` 가격 :
    <input type="text" class="product-inputs numberChk" value=${responseData.pdtPrice} placeholder="가격">`;
    updateList[1].innerHTML = "";
    updateList[1].innerHTML = ` 디자인 :
    <input type="text" class="product-inputs" value=${responseData.pdtDesign} placeholder="디자인">`;
    updateList[2].innerHTML = "";
    updateList[2].innerHTML = ` 재고 :
    <input type="text" class="product-inputs numberChk" value=${responseData.pdtStock} placeholder="재고">`;
  }
}

window.onload = () => {
  ProductService.getInstance().readProduct();
}