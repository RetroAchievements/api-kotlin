package org.retroachivements.api.data.pojo.achievement

import com.google.gson.annotations.SerializedName

class GetAchievementUnlocks {

    class Response: ArrayList<Response.Unlocks>() {
        data class Unlocks(
            @SerializedName("Achievement")
            val achievement: Achievement,

            @SerializedName("Console")
            val console: Console,

            @SerializedName("Game")
            val game: Game,

            @SerializedName("UnlocksCount")
            val unlocksCount: Long,

            @SerializedName("UnlocksHardcoreCount")
            val unlocksHardcoreCount: Long,

            @SerializedName("TotalPlayers")
            val totalPlayers: Long,

            @SerializedName("Unlocks")
            val unlocks: ArrayList<Unlock>
        ) {

            data class Unlock(
                @SerializedName("User")
                val user: String,

                @SerializedName("RAPoints")
                val raPoints: Long,

                @SerializedName("DateAwarded")
                val dateAwarded: String,

                @SerializedName("HardcoreMode")
                val hardcoreMode: Int
            )

            data class Game(
                @SerializedName("ID")
                val id: Long,

                @SerializedName("Title")
                val title: String
            )

            data class Console(
                @SerializedName("ID")
                val id: Long,

                @SerializedName("Title")
                val title: String
            )

            data class Achievement(
                @SerializedName("ID")
                val id: Long,

                @SerializedName("Title")
                val title: String,

                @SerializedName("Description")
                val description: String,

                @SerializedName("Points")
                val points: Long,

                @SerializedName("TruePoints")
                val trueRatio: Long,

                @SerializedName("Author")
                val author: String,

                @SerializedName("DateCreated")
                val dateCreated: String,

                @SerializedName("DateModified")
                val dateModified: String,

                @SerializedName("Type")
                val type: String
            )
        }
    }
}
