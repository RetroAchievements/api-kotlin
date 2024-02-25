package org.retroachivements.api.data.pojo.user

import com.google.gson.annotations.SerializedName

class GetUserRecentlyPlayedGames {

    class Response: ArrayList<Response.Game>() {
        data class Game(
            @SerializedName("GameID")
            val gameId: Long,

            @SerializedName("ConsoleID")
            val consoleId: Long,

            @SerializedName("ConsoleName")
            val consoleName: String,

            @SerializedName("Title")
            val title: String,

            @SerializedName("ImageIcon")
            val imageIcon: String,

            @SerializedName("LastPlayed")
            val lastPlayed: String,

            @SerializedName("NumPossibleAchievements")
            val numPossibleAchievements: Long,

            @SerializedName("PossibleScore")
            val possibleScore: Long,

            @SerializedName("NumAchievedHardcore")
            val numAchievedHardcore: Long,

            @SerializedName("ScoreAchievedHardcore")
            val scoreAchievedHardcore: Long
        )
    }
}
