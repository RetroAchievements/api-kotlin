package org.retroachivements.api.data.pojo.user

import com.google.gson.annotations.SerializedName

class GetUserProgress {

    class Response: HashMap<String, Response.Progress>() {
        data class Progress (
            @SerializedName("NumPossibleAchievements")
            val numPossibleAchievements: Long,

            @SerializedName("PossibleScore")
            val possibleScore: Long,

            @SerializedName("NumAchieved")
            val numAchieved: Long,

            @SerializedName("ScoreAchieved")
            val scoreAchieved: Long,

            @SerializedName("NumAchievedHardcore")
            val numAchievedHardcore: Long,

            @SerializedName("ScoreAchievedHardcore")
            val scoreAchievedHardcore: Long
        )
    }
}
