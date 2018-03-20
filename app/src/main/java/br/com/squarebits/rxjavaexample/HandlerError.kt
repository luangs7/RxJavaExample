package br.com.squarebits.rxjavaexample

import br.com.squarebits.rxjavaexample.model.BaseRequest
import com.google.gson.Gson
import retrofit2.adapter.rxjava.HttpException

/**
 * Created by Luan on 20/03/18.
 */
class HandlerError(var t:Throwable) {

    lateinit var throwable:Throwable
    lateinit var message:String
        init {
            this.throwable = t
        }


    fun onFailure():String{
        var response = throwable as HttpException
        try{
            message = parceMessage()!!
        }catch (e:Exception){

            when(response.code()){
                401 -> message = "Não autorizado."
                404 -> message = "Não encontrado."
                500 -> message = "Problema interno."
                429 -> message = "Não autorizado."
                else -> message = ""
            }
        }


        return message
    }

    fun parceMessage():String?{
        val error = throwable as HttpException
        val errorBody = error.response().errorBody().string()
        return Gson().fromJson<BaseRequest>(errorBody, BaseRequest::class.java).message
    }

}