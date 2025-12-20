package org.retroachivements.api.data.pojo.game

import com.google.gson.annotations.SerializedName

class GetGame {

    data class Response(
        @SerializedName("ID")
        val id: String,

        @SerializedName("Title")
        val title: String,

        @SerializedName("ForumTopicID")
        val forumTopicID: String,

        @SerializedName("ConsoleID")
        val consoleID: String,

        @SerializedName("ConsoleName")
        val consoleName: String,

        @SerializedName("Flags")
        val flags: String,

        @SerializedName("ImageIcon")
        val imageIcon: String,

        @SerializedName("GameIcon")
        val gameIcon: String,

        @SerializedName("ImageTitle")
        val imageTitle: String,

        @SerializedName("ImageIngame")
        val imageIngame: String,

        @SerializedName("ImageBoxArt")
        val imageBoxArt: String,

        @SerializedName("Publisher")
        val publisher: String,

        @SerializedName("Developer")
        val developer: String,

        @SerializedName("Genre")
        val genre: String,

        @SerializedName("Released")
        val released: String?,

        @SerializedName("ReleasedAtGranularity")
        val releasedAtGranularity: String?,

        @SerializedName("GameTitle")
        val gameTitle: String,

        @SerializedName("Console")
        val console: String
    )
}
