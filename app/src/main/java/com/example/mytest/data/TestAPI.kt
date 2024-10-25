package com.example.mytest.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class TestAPI {
    private val client: HttpClient = HttpClient()
    suspend fun getFiles() : String {
        val response: HttpResponse = client.get(URL)
        val answer: String = response.body()
        Log.d("OTVET", answer)
        return answer
    }
    companion object {
        const val URL = "https://catfact.ninja/fact"
    }
}