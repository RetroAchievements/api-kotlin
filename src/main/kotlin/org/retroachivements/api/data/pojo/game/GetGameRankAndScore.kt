package org.retroachivements.api.data.pojo.game

import com.google.gson.annotations.SerializedName

class GetGameRankAndScore {

    class Response: ArrayList<Response.RankAndScore>() {
        data class RankAndScore(
            @SerializedName("User")
            val user: String,

            @SerializedName("NumAchievements")
            val numAchievements: Long,

            @SerializedName("TotalScore")
            val totalScore: Long,

            @SerializedName("LastAward")
            val lastAward: String
        )
    }
}
