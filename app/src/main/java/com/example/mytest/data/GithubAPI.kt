package com.example.mytest.data

import android.util.Log
import com.google.gson.annotations.SerializedName
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.gson.gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

interface GithubAPI {
    val client: HttpClient
        get() = HttpClient {
            install(ContentNegotiation) {
                gson()
            }
        }
    // Получить файлы из репозитория
    fun getFiles(){
        GlobalScope.launch {
            val request = client.get("$URL?Accept=$ACCEPT&Authorization=$TOKEN&X-GitHub-Api-Version=$API_VERSION")
            val answer = request.body<Answer>()
            Log.d("OTVET",answer.text.toString())
        }
    }
    // Заголовки
    companion object {
        const val URL = "https://api.github.com/repos/OWNER/REPO/contents/PATH"
        const val ACCEPT = "application/vnd.github+json"
        const val TOKEN = "-"
        const val API_VERSION = "2022-11-28"
    }
    // Ответ
    data class Answer (
        @SerializedName("endOfWord") var endOfWord : Boolean? = null,
        @SerializedName("pos") var pos : Int? = null,
        @SerializedName("text") var text : ArrayList<String> = arrayListOf()
    )
}