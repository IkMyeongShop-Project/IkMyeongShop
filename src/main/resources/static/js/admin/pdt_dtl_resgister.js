class CommonApi {

    static #instance = null;
    static getInstance(){
        if(this.#instance == null){
            this.#instance = new CommonApi();
        }
        return this.#instance;
    }

getProductMstList(){
    let responseData = null;
    $.ajax({
        async : false, 
        type : "get",
        url : "/api/admin/option/products/mst",
        dataType : "json",
        success : (response) => {
            responseData = response.data;
        },
        error : (error) => {
            console.log(error);
        }
    });
    return responseData;
    }

    getProductOptionList(){
        let responseData = null;
        $.ajax({
            async : false, 
            type : "get",
            url : "/api/admin/option/products/Option/" + productId, 
            dataType : "json",
            success : (response) => {
                responseData = response.data;
            },
            error : (error) => {
                console.log(error);
            }
        });
        return responseData;
    }
}

class ProductApi{
    static #instance = null;
    static getInstance(){
        if(this.#instance == null){
            this.#instance = new ProductApi();
        }
        return this.#instance;
    }

    registProductDtl(productDtlParams){
        $.ajax({
            async : false,
            type : "post",
            url : "/api/admin/product/dtl",
            contentType : "application/json",
            data : JSON.stringify(productDtlParams),
            dataType : "json",
            success : (response) => {
                alert("추가 완료!");
                location.reload();
            },
            error : (error) => {
                console.log(error);
                alert(`상품 추가 실패.
                ${error.responseJSON.data.error}
                `)
            }
        })
    }
    registImgFiles(formData) {
        $.ajax({
            async : false,
            type : "post",
            url : "/api/admin/product/img",
            enctype: "multipart/form-data",
            contentType : false,
            processData : false,

            data : formData,
            dataType : "json",
            success : (response) => {
                alert("이미지 등록 성공");
                location.reload();
            },
            error:(error) => {
                console.log(error);
            }
        });
    }

}