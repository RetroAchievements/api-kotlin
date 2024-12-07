package org.retroachivements.api.data.pojo.game

import com.google.gson.annotations.SerializedName

class GetLeaderboardEntries {
    data class Response(
        @SerializedName("Count")
        val count: Long,
        @SerializedName("Total")
        val total: Long,
        @SerializedName("Results")
        val results: List<Entry>,
    )

    data class Entry(
        @SerializedName("User")
        val user: String,
        @SerializedName("DateSubmitted")
        val dateSubmitted: String,
        @SerializedName("Score")
        val score: Long,
        @SerializedName("FormattedScore")
        val formattedScore: String,
        @SerializedName("Rank")
        val rank: Long,
    )

}
