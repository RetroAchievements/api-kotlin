package org.retroachivements.api.data.pojo.feed

import com.google.gson.annotations.SerializedName

class GetRecentGameAwards {
    data class Response(
        @SerializedName("Count")
        val count: Long,
        @SerializedName("Total")
        val total: Long,
        @SerializedName("Results")
        val results: List<Result>,
    )

    data class Result(
        @SerializedName("User")
        val user: String,
        @SerializedName("AwardKind")
        val awardKind: String,
        @SerializedName("AwardDate")
        val awardDate: String,
        @SerializedName("GameID")
        val gameId: Long,
        @SerializedName("GameTitle")
        val gameTitle: String,
        @SerializedName("ConsoleID")
        val consoleId: Long,
        @SerializedName("ConsoleName")
        val consoleName: String,
    )

}
