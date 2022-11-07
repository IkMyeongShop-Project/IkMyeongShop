
const ReButton = document.querySelector(".product-button");

ReButton.onclick = () =>{

}

const PageNumber = document.querySelectorAll(".page-number-list li")[0]

PageNumber.onclick = () =>{
    alert("2로")}

const sideList = document.querySelectorAll(".side-content-menulist a")[1]

sideList.onclick =() =>{
    alert("등록으로 이동")
    location.href = "/admin/product/register";

}
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
            url:  "/admin/api/v1/product" + page,
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
