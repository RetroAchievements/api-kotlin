package org.retroachivements.api.data.pojo.game

import com.google.gson.annotations.SerializedName

class GetGameLeaderboards {

    data class Response(
        @SerializedName("Count")
        val count: Long,

        @SerializedName("Total")
        val total: Long,

        @SerializedName("Results")
        val results: List<Leaderboard>,
    )

    data class Leaderboard(
        @SerializedName("ID")
        val id: Long,

        @SerializedName("RankAsc")
        val rankAsc: Boolean,

        @SerializedName("Title")
        val title: String,

        @SerializedName("Description")
        val description: String,

        @SerializedName("Format")
        val format: String,

        @SerializedName("TopEntry")
        val topEntry: TopEntry,

        @SerializedName("Author")
        val author: String,

        @SerializedName("AuthorULID")
        val authorUlid: String
    )

    data class TopEntry(
        @SerializedName("User")
        val user: String,

        @SerializedName("ULID")
        val ulid: String,

        @SerializedName("Score")
        val score: Long,

        @SerializedName("FormattedScore")
        val formattedScore: String,
    )
}
