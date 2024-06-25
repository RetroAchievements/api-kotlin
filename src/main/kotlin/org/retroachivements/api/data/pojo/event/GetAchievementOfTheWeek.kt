package org.retroachivements.api.data.pojo.event

import com.google.gson.annotations.SerializedName

class GetAchievementOfTheWeek {

    data class Response(
        @SerializedName("Achievement")
        val achievement: Achievement,

        @SerializedName("StartAt")
        val startAt: String,

        @SerializedName("TotalPlayers")
        val totalPlayers: Long,

        @SerializedName("Console")
        val console: Console,

        @SerializedName("ForumTopic")
        val forumTopic: ForumTopic,

        @SerializedName("Game")
        val game: Game,

        @SerializedName("Unlocks")
        val unlocks: ArrayList<Unlock>,

        @SerializedName("UnlocksCount")
        val unlocksCount: Long,

        @SerializedName("UnlocksHardcoreCount")
        val unlocksHardcoreCount: Long
    ) {
        data class Achievement(
            @SerializedName("ID")
            val id: Long,

            @SerializedName("Title")
            val title: String,

            @SerializedName("Description")
            val description: String,

            @SerializedName("Points")
            val points: Long,

            @SerializedName("TrueRatio")
            val trueRatio: Long,

            @SerializedName("Type")
            val type: String?,

            @SerializedName("Author")
            val author: String,

            @SerializedName("DateCreated")
            val dateCreated: String,

            @SerializedName("DateModified")
            val dateModified: String
        )

        data class Console(
            @SerializedName("ID")
            val id: Long,

            @SerializedName("Title")
            val title: String
        )

        data class ForumTopic(
            @SerializedName("ID")
            val id: String
        )

        data class Game(
            @SerializedName("ID")
            val id: Long,

            @SerializedName("title")
            val title: String
        )

        data class Unlock(
            @SerializedName("User")
            val user: String,

            @SerializedName("RAPoints")
            val raPoints: Long,

            @SerializedName("DateAwarded")
            val dateAwarded: String,

            @SerializedName("HardcoreMode")
            val hardcoreMode: Int,

            @SerializedName("RASoftcorePoints")
            val raSoftcorePoints: Int
        )
    }
}
