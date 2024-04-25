package com.example.highlandscoffeegrowersapp.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.highlandscoffeegrowersapp.models.Purchase
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_PURCHASE_FERTILISER
import com.example.highlandscoffeegrowersapp.navigation.ROUTE_VIEW_FERTILISER_PURCHASE
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

//class PurchaseRepository(var navController: NavHostController, var context: Context) {
class PurchaseRepository(private val navController: NavHostController, private val context: Context) {

    var progress: ProgressDialog
    var purchase: ArrayList<Purchase>
    var successPurchase by mutableStateOf(false)

    init {
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait..")
        purchase = mutableListOf<Purchase>() as ArrayList<Purchase>
    }

    fun savePurchase(
//        context: String,
        selectedDate: String,
        growerName: String,
        growerID: String,
        selectedname: String,
        quantity: String,
        supplier: String, successPurchase: Boolean
    ) {
        var id = System.currentTimeMillis().toString()
        var purchaseData = Purchase(selectedDate,growerName, growerID, selectedname, quantity, supplier, id)
        var purchaseRef = FirebaseDatabase.getInstance().getReference()
            .child("Purchases/$id")
        progress.show()
        purchaseRef.setValue(purchaseData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Purchase saved.", Toast.LENGTH_SHORT).show()
                this.successPurchase = true
            } else {
                Toast.makeText(context, "Error: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun viewPurchase(purchase: MutableState<Purchase>, purchases: SnapshotStateList<Purchase>): SnapshotStateList<Purchase> {
        var ref = FirebaseDatabase.getInstance().getReference().child("Purchases")
        progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                progress.dismiss()
                purchases.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(Purchase::class.java)
                    purchase.value = value!!
                    purchases.add(value!!)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return purchases
}
    fun updatePurchase(selectedDate:String,growerName: String,growerID: String, selectedname:String,quantity:String,supplier:String,id:String) {
        var updateRef = FirebaseDatabase.getInstance().getReference().child("Purchases/$id")
        progress.show()
        var updateData = Purchase(selectedDate, growerName, growerID, selectedname,quantity,supplier,id)
        updateRef.setValue(updateData).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context, "Purchase Updated Successfully", Toast.LENGTH_SHORT).show()
                navController.navigate(ROUTE_PURCHASE_FERTILISER){
                    popUpTo(ROUTE_VIEW_FERTILISER_PURCHASE){
                        inclusive=true
                    }
                }
            }else{
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }

        }


    }

    fun deletePurchase(id:String) {
        var delRef = FirebaseDatabase.getInstance().getReference().child("Purchases/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener(){
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context,"Purchase deleted", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }

    }


}


