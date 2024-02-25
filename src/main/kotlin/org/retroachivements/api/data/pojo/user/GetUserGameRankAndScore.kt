package org.retroachivements.api.data.pojo.user

import com.google.gson.annotations.SerializedName

class GetUserGameRankAndScore {

    class Response: ArrayList<Response.RankAndScore>() {
        data class RankAndScore(
            @SerializedName("User")
            val user: String,

            @SerializedName("TotalScore")
            val totalScore: Long,

            @SerializedName("LastAward")
            val lastAward: String,

            @SerializedName("UserRank")
            val userRank: Int
        )
    }
}
