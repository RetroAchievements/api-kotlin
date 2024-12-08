package org.retroachivements.api.data.pojo.user

import com.google.gson.annotations.SerializedName

class GetUserWantToPlayList {
    data class Response(
        @SerializedName("Count")
        val count: Long,
        @SerializedName("Total")
        val total: Long,
        @SerializedName("Results")
        val results: List<Result>,
    )

    data class Result(
        @SerializedName("ID")
        val id: Long,
        @SerializedName("Title")
        val title: String,
        @SerializedName("ConsoleID")
        val consoleId: Long,
        @SerializedName("ConsoleName")
        val consoleName: String,
        @SerializedName("ImageIcon")
        val imageIcon: String,
        @SerializedName("PointsTotal")
        val pointsTotal: Long,
        @SerializedName("AchievementsPublished")
        val achievementsPublished: Long,
    )

}
