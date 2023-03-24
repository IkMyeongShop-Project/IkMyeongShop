
class AddressApi {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new AddressApi();
        }
        return this.#instance;
    }

    #daumApi = null;
    constructor() {
        this.#daumApi = new daum.Postcode({
            oncomplete: function(data) {
               const addressZonecode = document.querySelector(".address-zonecode")
               const addressAll = document.querySelector(".address-all")

                addressZonecode.value = data.zonecode;
                addressAll.value = data.address + `${data.buildingName != "" ? "(" + data.buildingName + ")" : ""}`;
            }
        });
    }

    addAddressButtonEvent() {
        document.querySelector(".btn_post_search").onclick = () => {
            this.#daumApi.open();
        }
    }
}