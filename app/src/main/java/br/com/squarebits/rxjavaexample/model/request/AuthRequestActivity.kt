package br.com.squarebits.lausgirl.data.request

import android.app.Activity
import android.content.Context

import br.com.squarebits.lausgirl.data.model.User
import br.com.squarebits.lausgirl.data.retrofit.ApiManager
import br.com.squarebits.lausgirl.data.retrofit.CustomCallback
import br.com.squarebits.lausgirl.data.retrofit.RequestInterface
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.RequestBody

/**
 * Created by Luan on 07/08/17.
 */

class AuthRequestActivity(private val activity: Activity, private val mListener: RequestListener) {
    private val context: Context

    init {
        this.context = activity.baseContext
    }

    interface RequestListener {
        fun onSuccess(user: User)
        fun onError(error: String)
    }


//    fun login(user: User) {
//
//
//        val json = Gson().toJson(user)
//        val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)
//
//
//        ApiManager(context)
//                .retrofit
//                .create(RequestInterface::class.java)
//                .getToken(body)
//                .enqueue(CustomCallback(activity, object : CustomCallback.OnResponse<User> {
//                    override fun onResponse(response: User?) {
//                        mListener.onSuccess(response!!)
//                    }
//
//                    override fun onFailure(t: Throwable?) {
//                        mListener.onError(t!!.message!!)
//                    }
//
//                    override fun onRetry(t: Throwable?) {
//                        login(user)
//                    }
//                }))
//    }
//
//
//    fun getMe(token:String,id:String) {
//
//
//        val header = HashMap<String,String>()
//        header.put("Authorization", "Bearer " + token)
//
//
//        ApiManager(context)
//                .retrofit
//                .create(RequestInterface::class.java)
//                .getMe(header,id)
//                .enqueue(CustomCallback(activity, object : CustomCallback.OnResponse<User> {
//                    override fun onResponse(response: User?) {
//                        mListener.onSuccess(response!!)
//                    }
//
//                    override fun onFailure(t: Throwable?) {
//                        mListener.onError(t!!.message!!)
//                    }
//
//                    override fun onRetry(t: Throwable?) {
//                        getMe(token,id)
//                    }
//                }))
//    }



}
