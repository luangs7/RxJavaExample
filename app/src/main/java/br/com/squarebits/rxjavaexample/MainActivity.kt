package br.com.squarebits.rxjavaexample


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import br.com.squarebits.lausgirl.data.model.User
import br.com.squarebits.lausgirl.data.retrofit.ApiManager
import br.com.squarebits.lausgirl.data.retrofit.RequestInterface
import br.com.squarebits.rxjavaexample.model.Item
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.RequestBody
import org.jetbrains.anko.longToast
import rx.Observable
import rx.Single
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Func2
import rx.schedulers.Schedulers
import java.util.function.BiFunction
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var userRequest = User()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getData(userRequest)

    }

    fun showUser(user: User){
        longToast(user.name!!)
    }




    fun saveUser(user: User){
        this.userRequest = user
    }


    fun getData(mUser: User) {
        val apiManager = ApiManager(this).retrofit.create(RequestInterface::class.java)


//        ----------------------- AVOID CALLBACK HELL, ONE BEGINS ONLY WHEN THE FIRST ONE ENDS -----------------

//        apiManager.getUser()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnNext { session -> saveUser(session) }
//                .flatMap { people -> Observable.from(people.itens) }
//                .flatMap { carId ->
//                    apiManager.getItens()
//                }
//                .subscribe(
//                        {itens -> user.itens = itens},
//                        {error -> longToast(error.message.toString())},
//                        {Log.e("user",user.toString())}
//                )




//        ---------------------- COMBINE TWO REQUESTS AT THE SAME TIME ----------------------------

        val observableUser = apiManager.getUser().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        val observableItem = apiManager.getItens().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())


        val combined = Observable.zip(observableItem, observableUser, object : Func2<List<Item>,User , User> {
                override fun call(responseOne: List<Item>, responseTwo: User): User {
                    responseTwo.itens = responseOne
                    saveUser(responseTwo)
                    return userRequest
                }
            })

        combined.subscribe(
                {},
                {error ->
                    if(error.message != null)
                        longToast(HandlerError(error).onFailure())
                    else
                        longToast(toString(error.stackTrace))
                },
                {updateUi()}
        )

    }


    fun updateUi(){
        this.hello.text = Gson().toJson(this.userRequest)
    }

    fun toString(stackTraceElements: Array<StackTraceElement>?): String {
        if (stackTraceElements == null)
            return ""
        val stringBuilder = StringBuilder()
        for (element in stackTraceElements)
            stringBuilder.append(element.toString()).append("\n")
        return stringBuilder.toString()
    }
}
