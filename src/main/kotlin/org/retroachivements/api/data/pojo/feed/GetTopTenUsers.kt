package org.retroachivements.api.data.pojo.feed

import com.google.gson.annotations.SerializedName

class GetTopTenUsers {

    class Response: ArrayList<Response.User>() {
        data class User(
            @SerializedName("1")
            val userName: String,

            @SerializedName("2")
            val totalPoints: Long,

            @SerializedName("3")
            val totalRatioPoints: Long
        )
    }
}
