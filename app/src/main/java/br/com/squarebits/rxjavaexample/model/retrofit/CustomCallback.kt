package br.com.squarebits.lausgirl.data.retrofit

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View

import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.net.ConnectivityManager
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import br.com.squarebits.rxjavaexample.R


/**
 * Created by Luan on 17/10/17.
 */
@SuppressWarnings("unused")
class CustomCallback<T> : Callback<T> {

    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

