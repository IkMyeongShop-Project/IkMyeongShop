class CommonApi {

    static #instance = null;
    static getInstance(){
        if(this.#instance == null){
            this.#instance = new CommonApi();
        }
        return this.#instance;
    }

    getCategoryList() {
        let responseResult = null;
    
        $.ajax ({
          async: false,
          type: "get",
          url: "/api/admin/product/category",
          dataType: "json",
          success: (response) => {
            responseResult = response.data;
          },
          error: (error) => {
            console.log(error);
          }
        });
    
        return responseResult;
      }
    }    
    
    setCategorySelectOptions() {
        const categorySelect = document.querySelector(".product-inputs");
        categorySelect.innerHTML = `<option value="none">카테고리</option>`;
      
        const responseData = CommonApi.getInstance().getCategoryList();
        if(responseData != null) {
          if (responseData.length > 0) {
            responseData.forEach(product => {
              categorySelect.innerHTML += `
                <option value="${product.Id}">${product.name}</option>
              `;
            });
          }
        }
    }

class ProductApi{
    static #instance = null;
    static getInstance(){
        if(this.#instance == null){
            this.#instance = new ProductApi();
        }
        return this.#instance
    }

    registProductDtl(productDtlParams){
        $.ajax({
            async : false,
            type : "post",
            url : "/api/admin/product/dtl",
            contentType : "application/json",
            data : JSON.stringify(productDtlParams),
            dataType : "json",
            success : (response) =>{
                alert("추가 완료!");
                location.reload();
            },
            error : (error) =>{
                alert(`상품 추가 실패.
                ${error.responseJSON.data.error}
                `)
            }
        })
    }
    
}
    
class ProductImgFile{
    addDeleteEvent() {
        const deleteButtons = document.querySelectorAll(".delete-button");

        deleteButtons.forEach((deleteButton, i) => {
            deleteButton.onclick = () =>{
                if(confirm("상품을 지우시겠습니까?")){
                    this.newImgList.splice(i ,1);
                    this.loadImgs();    
                }
            }
        })
    };
}

window.onload = () =>{
    ProductImgFile.getInstance();
}