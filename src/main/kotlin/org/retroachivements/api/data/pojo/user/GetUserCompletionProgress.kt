package org.retroachivements.api.data.pojo.user

import com.google.gson.annotations.SerializedName

class GetUserCompletionProgress {

    data class Response(
        @SerializedName("Count")
        val count: Long,

        @SerializedName("Total")
        val total: Long,

        @SerializedName("Results")
        val results: ArrayList<Progress>
    )

    data class Progress(
        @SerializedName("GameID")
        val gameId: Long,

        @SerializedName("Title")
        val title: String,

        @SerializedName("ImageIcon")
        val imageIcon: String,

        @SerializedName("ConsoleID")
        val consoleId: Int,

        @SerializedName("ConsoleName")
        val consoleName: String,

        @SerializedName("MaxPossible")
        val maxPossible: Long,

        @SerializedName("NumAwarded")
        val numAwarded: Long,

        @SerializedName("NumAwardedHardcore")
        val numAwardedHardcore: Long,

        @SerializedName("MostRecentAwardedDate")
        val mostRecentAwardedDate: String,

        @SerializedName("HighestAwardKind")
        val highestAwardKind: String,

        @SerializedName("HighestAwardDate")
        val highestAwardDate: String
    )
}
