package com.example.highlandscoffeegrowersapp.models

class Purchase {
    var selectedDate:String = ""
    var growerName:String = ""
    var growerID:String = ""
    var selectedname:String = ""
    var quantity:String = ""
    var supplier:String = ""
    var id:String = ""

    constructor(
        selectedDate: String,
        growerName : String,
        growerID: String,
        selectedname: String,
        quantity: String,
        supplier: String,
        id: String,
    ) {
        this.selectedDate = selectedDate
        this.growerName = growerName
        this.growerID = growerID
        this.selectedname = selectedname
        this.quantity = quantity
        this.supplier = supplier
        this.id = id
    }
    constructor()

}
