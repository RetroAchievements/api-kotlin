package org.retroachivements.api.data.pojo.user

import com.google.gson.annotations.SerializedName

class GetUserSetRequests {

    data class Response(

        @SerializedName("RequestedSets")
        val requestedSets: List<Set>,

        @SerializedName("TotalRequests")
        val totalRequests: Int,

        @SerializedName("PointsForNext")
        val pointsForNext: Int
    ) {
        data class Set(

            @SerializedName("GameID")
            val gameId: Int,

            @SerializedName("Title")
            val title: String,

            @SerializedName("ConsoleID")
            val consoleId: Int,

            @SerializedName("ConsoleName")
            val consoleName: String,

            @SerializedName("ImageIcon")
            val imageIcon: String
        )
    }
}
