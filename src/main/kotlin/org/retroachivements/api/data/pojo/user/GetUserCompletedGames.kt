package org.retroachivements.api.data.pojo.user

import com.google.gson.annotations.SerializedName

class GetUserCompletedGames {

    class Response: ArrayList<Response.Game>() {
        data class Game(
            @SerializedName("GameID")
            val gameId: Long,

            @SerializedName("Title")
            val title: String,

            @SerializedName("ImageIcon")
            val imageIcon: String,

            @SerializedName("ConsoleID")
            val consoleId: Long,

            @SerializedName("ConsoleName")
            val consoleName: String,

            @SerializedName("MaxPossible")
            val maxPossible: Long,

            @SerializedName("NumAwarded")
            val numAwarded: Long,

            @SerializedName("PctWon")
            val pctWon: String,

            @SerializedName("HardcoreMode")
            val hardcoreMode: Long
        )
    }
}
