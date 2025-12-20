package org.retroachivements.api.data.pojo.game

import com.google.gson.annotations.SerializedName

class GetGameInfoAndUserProgress {

    data class Response(
        @SerializedName("ID")
        val id: Int,

        @SerializedName("Title")
        val title: String,

        @SerializedName("ConsoleID")
        val consoleId: Int,

        @SerializedName("ForumTopicID")
        val forumTopicId: Int,

        @SerializedName("Flags")
        val flags: String?,

        @SerializedName("ImageIcon")
        val imageIcon: String,

        @SerializedName("ImageTitle")
        val imageTitle: String,

        @SerializedName("ImageIngame")
        val imageInGame: String,

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

        @SerializedName("IsFinal")
        val isFinal: Boolean,

        @SerializedName("RichPresencePatch")
        val richPresencePatch: String,

        @SerializedName("PlayersTotal")
        val playersTotal: Int,

        @SerializedName("UserTotalPlaytime")
        val userTotalPlaytime: Int,

        @SerializedName("GuideURL")
        val guideUrl: String?,

        @SerializedName("ConsoleName")
        val consoleName: String,

        @SerializedName("ParentGameID")
        val parentGameId: String?,

        @SerializedName("NumDistinctPlayers")
        val numDistinctPlayers: Long,

        @SerializedName("NumAchievements")
        val numAchievements: Int,

        @SerializedName("Achievements")
        val achievements: HashMap<String, Achievement>,

        @SerializedName("NumAwardedToUser")
        val numAwardedToUser: Int,

        @SerializedName("NumAwardedToUserHardcore")
        val numAwardedToUserHardcore: Int,

        @SerializedName("NumDistinctPlayersCasual")
        val numDistinctPlayersCasual: Long,

        @SerializedName("NumDistinctPlayersHardcore")
        val numDistinctPlayersHardcore: Long,

        @SerializedName("UserCompletion")
        val userCompletion: String,

        @SerializedName("UserCompletionHardcore")
        val userCompletionHardcore: String
    ) {
        data class Achievement(
            @SerializedName("ID")
            val id: String,

            @SerializedName("NumAwarded")
            val numAwarded: Long,

            @SerializedName("NumAwardedHardcore")
            val numAwardedHardcore: Long,

            @SerializedName("Title")
            val title: String,

            @SerializedName("Description")
            val description: String,

            @SerializedName("Points")
            val points: Long,

            @SerializedName("TrueRatio")
            val trueRatio: Long,

            @SerializedName("Author")
            val author: String,

            @SerializedName("DateModified")
            val dateModified: String,

            @SerializedName("DateCreated")
            val dateCreated: String,

            @SerializedName("BadgeName")
            val badgeName: String,

            @SerializedName("DisplayOrder")
            val displayOrder: Int,

            @SerializedName("MemAddr")
            val memAddr: String,

            @SerializedName("type")
            val type: String?,

            @SerializedName("DateEarnedHardcore")
            val dateEarnedHardcore: String?,

            @SerializedName("DateEarned")
            val dateEarned: String?
        )
    }
}
