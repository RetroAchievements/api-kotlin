package org.retroachivements.api.data.pojo.game

import com.google.gson.annotations.SerializedName

class GetAchievementCount {

    data class Response(
        @SerializedName("GameID")
        val gameId: Long,

        @SerializedName("AchievementIDs")
        val achievementIds: ArrayList<Long>
    )
}
