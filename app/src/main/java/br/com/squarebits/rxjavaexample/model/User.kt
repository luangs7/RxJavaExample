package br.com.squarebits.lausgirl.data.model

import android.os.Parcel
import android.os.Parcelable
import br.com.squarebits.rxjavaexample.model.Item

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User() : Parcelable {
        @SerializedName("id")
        var id: String? = null

        @SerializedName("name")
        var name: String? = null

        @SerializedName("itens")
        @Expose
        var itens: List<Item>? = null

        constructor(id: String, itens: List<Item>) : this(){
            this.id = id
            this.itens = itens
        }

        constructor(source: Parcel) : this(
        )

        override fun describeContents() = 0

        override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {}

        companion object {
                @JvmField
                val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
                        override fun createFromParcel(source: Parcel): User = User(source)
                        override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
                }
        }
}

