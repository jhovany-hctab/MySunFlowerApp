package appiscjhovany.mysunflowerapp.data

import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class DataHttp {
    lateinit var conn:HttpURLConnection
    public fun HttpGet(myURL: String?): String {
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        try {
            val inputStream: InputStream
            val result:String
            val url:URL


            // create URL
            url = URL(myURL)

            // create HttpURLConnection
            conn = url.openConnection() as HttpURLConnection

            // make GET request to the given URL
            conn.connect()

            // receive response as inputStream
            val data = conn.inputStream.bufferedReader().readText()

            // convert inputstream to string

            return data
        }finally {
            conn.disconnect()
        }

    }
}