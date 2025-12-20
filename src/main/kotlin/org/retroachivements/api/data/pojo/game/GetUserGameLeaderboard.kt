package org.retroachivements.api.data.pojo.game

import com.google.gson.annotations.SerializedName

class GetUserGameLeaderboard {

    data class Response(

        @SerializedName("Count")
        val count: Int,

        @SerializedName("Total")
        val total: Int,

        @SerializedName("Results")
        val results: List<Result>
    ) {
        data class Result(

            @SerializedName("ID")
            val id: Int,

            @SerializedName("RankAsc")
            val rankAsc: Boolean,

            @SerializedName("Title")
            val title: String,

            @SerializedName("Description")
            val description: String,

            @SerializedName("Format")
            val format: String,

            @SerializedName("UserEntry")
            val userEntry: UserEntry
        ) {
            data class UserEntry(

                @SerializedName("User")
                val user: String,

                @SerializedName("ULID")
                val ulid: String,

                @SerializedName("Score")
                val score: Int,

                @SerializedName("FormattedScore")
                val formattedScore: String,

                @SerializedName("Rank")
                val rank: Int,

                @SerializedName("DateUpdated")
                val dateUpdated: String
            )
        }
    }
}
