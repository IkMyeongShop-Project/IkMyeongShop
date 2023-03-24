 class pdtPrice {
    constructor() {
        this.TotalPay();
        this.Mileage();
    }

    TotalPay() {
        const pdtPrice = document.querySelector(".product-price").textContent;
        const PaySumList = document.querySelectorAll(".totalPay");

        PaySumList.forEach(PaySum => {
            PaySum.innerHTML = Number(pdtPrice) + 2500;
        })
        
        console.log(pdtPrice);
    }

    Mileage() {
        const pdtPrice = document.querySelector(".product-price").textContent;
        const MileageList = document.querySelectorAll(".mileage");

        MileageList.forEach(Mileage => {
            Mileage.innerHTML = Number(pdtPrice) * 0.01
        })
    }
}
