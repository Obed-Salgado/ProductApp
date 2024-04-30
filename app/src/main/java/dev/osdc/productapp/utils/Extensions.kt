package dev.osdc.productapp.utils

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import dev.osdc.productapp.data.model.Product
import java.io.ByteArrayOutputStream

fun ImageView.load(url: String){
    if(url.isNotEmpty()){
        Glide
            .with(this.context)
            .load(url)
            .centerCrop()
            .into(this)
    }
}

fun ImageView.load(bitmap: Bitmap){
    Glide
        .with(this.context)
        .load(bitmap)
        .centerCrop()
        .into(this)
}

fun Activity.toast(text: String, length: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, text, length).show()
}

fun Fragment.toast(text: String, length: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this.requireContext(), text, length).show()
}

fun Product.isNotEmpty(): Boolean{
    return this.name.isNotEmpty() && this.description.isNotEmpty()
}

fun String.toBitMap(): Bitmap{
    Base64.decode(this, Base64.DEFAULT).apply {
        return BitmapFactory.decodeByteArray(this, 0, size)
    }
}

fun Bitmap.toBase64(): String{
    ByteArrayOutputStream().apply {
        this@toBase64.compress(Bitmap.CompressFormat.JPEG, 100, this)
        val byteArray = this.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }
}
