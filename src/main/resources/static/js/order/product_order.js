
class ImportApi {
    #IMP = null;

    constructor() {
        this.#IMP = window.IMP;
        this.#IMP.init("imp52106714");
        this.addPaymentEvent();
    }

    addPaymentEvent() {
        document.querySelector(".btn_order_buy").addEventListener("click", () => {
            console.log("requestPay");
            this.requestPay();
        })
    }

    requestPay() {
        const pdtName = document.querySelector(".product-name").innerHTML;
        const pdtPrice = Number(document.querySelector(".product-price").innerHTML);
        const name = document.querySelector(".principal-name").value;
        const zoneCode = document.querySelector(".address-zonecode").value;
        const addressAll = document.querySelector(".address-all").value;
        const addressDetail = document.querySelector(".address-detail").value;
        const address = addressAll + " " + addressDetail;
        const phone = document.querySelector(".phone-number").value;

        //필수 항목 체크
        const requiredList = {
            "principal-name": name,
            "address-zonecode": zoneCode,
            "address-all": addressAll,
            "phone-number": phone
        }

        const missingList = Object.keys(requiredList).filter(field => !requiredList[field]);
        if (missingList.length > 0) {
            missingList.forEach(field => {
                document.querySelector(`.${field}`).style.borderColor = "red";
            })
        }


        console.log("pdtName", pdtName);
        console.log("pdtPrice", pdtPrice)
        console.log("name", name);
        console.log("zoneCode", zoneCode);
        console.log("addressAll", addressAll);
        console.log("addressDetail", addressDetail);
        console.log("address", address);
        console.log("phone", phone);

        if(!this.#IMP) {
            console.error("IMP not initialized");
            return;
        }

        if (!pdtName || !pdtPrice || !name || !zoneCode || !address || !phone) {
            console.error("Missing required information");
        
            // 필수 입력란에 빨간 테두리 적용
            const requiredFields = ['.product-name', '.product-price', '.principal-name', '.address-zonecode', '.address-all', '.address-detail', '.phone-number'];
            requiredFields.forEach(field => {
                const input = document.querySelector(field);
                if (!input.value) {
                    input.style.borderColor = 'red';
                }
            });
        
            return;
        }
        
        IMP.request_pay({
            pg: "kakaopay",
            pay_method: "card",
            merchant_uid: "GOODS-" + new Date().getTime(),
            name: pdtName,
            amount: pdtPrice,
            buyer_name: name,
            buyer_tel: phone,
            buyer_addr: address,
            buyer_postcode: zoneCode
        }, function (rsp) {
            if(rsp.success) {
                console.log("Payment Success")
            } else {
                console.log("Payment Failed")
            }
        });
    }

}

window.onload = () => {
    AddressApi.getInstance().addAddressButtonEvent();
    new ImportApi();
    new pdtPrice();
}