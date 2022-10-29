const RegisterEventService = {
    getCategorySelectObj: document.querySelectorAll(".product-inputs")[0],
    getNameInputObj: document.querySelectorAll(".product-inputs")[1],
    getPriceInputObj: document.querySelectorAll(".product-inputs")[2],

    init: function() {
        this.getNameInputObj.disabled = true;
        this.getPriceInputObj.disabled = true;
    },

    addCategorySelectEvent: function() {
        this.getCategorySelectObj.onchange = () => {
            if(this.getCategorySelectObj != "none") {
                this.getNameInputObj.disabled = false;
            }else {
                this.getNameInputObj.disabled = true;
            }
        }
    },

    addNameInputEvent: function() {
        this.getNameInputObj.onkeyup = () => {
            if(this.getNameInputObj.value.length != 0) {
                this.getPriceInputObj.disabled = false;
            }else {
                this.getPriceInputObj.disabled = true;
            }
        }
    }
}

const ProductRegistration = {
    registerEventService: RegisterEventService
}

window.onload = () => {
    ProductRegistration.registerEventService.init();
    ProductRegistration.registerEventService.addCategorySelectEvent();
    ProductRegistration.registerEventService.addNameInputEvent();
}