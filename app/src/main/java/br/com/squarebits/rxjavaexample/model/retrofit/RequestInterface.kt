package br.com.squarebits.lausgirl.data.retrofit

import br.com.squarebits.lausgirl.data.model.*
import br.com.squarebits.rxjavaexample.model.Item
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.HeaderMap
import retrofit2.http.GET
import rx.Observable
import java.util.*


/**
 * Created by Luan on 17/10/17.
 */
interface RequestInterface {

    @GET("o1lc3")
    abstract fun getUser(): Observable<User>

    @GET("17emp7")
    abstract fun getItens(): Observable<List<Item>>


}