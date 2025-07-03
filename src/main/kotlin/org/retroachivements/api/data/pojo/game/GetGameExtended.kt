package org.retroachivements.api.data.pojo.game

import com.google.gson.annotations.SerializedName

class GetGameExtended {

    data class Response(
        @SerializedName("ID")
        val id: Long,

        @SerializedName("Title")
        val title: String,

        @SerializedName("ConsoleID")
        val consoleId: String,

        @SerializedName("ForumTopicID")
        val forumTopicId: Long,

        @SerializedName("Flags")
        val flags: String?,

        @SerializedName("ImageIcon")
        val imageIcon: String,

        @SerializedName("ImageTitle")
        val imageTitle: String,

        @SerializedName("ImageInGame")
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

        @SerializedName("IsFinal")
        val isFinal: Boolean,

        @SerializedName("RichPresencePatch")
        val richPresencePatch: String,

        @SerializedName("PlayersTotal")
        val playersTotal: Long,

        @SerializedName("AchievementSetVersionHash")
        val achievementSetVersionHash: String,

        @SerializedName("AchievementsPublished")
        val achievementsPublished: Long,

        @SerializedName("PointsTotal")
        val pointsTotal: Long,

        @SerializedName("GuideURL")
        val guideUrl: String?,

        @SerializedName("Updated")
        val updated: String,

        @SerializedName("ConsoleName")
        val consoleName: String,

        @SerializedName("ParentGameID")
        val parentGameId: String?,

        @SerializedName("NumDistinctPlayers")
        val numDistinctPlayers: Long,

        @SerializedName("NumAchievements")
        val numAchievements: Long,

        @SerializedName("Achievements")
        val achievements: HashMap<String, Achievement>,

        @SerializedName("Claims")
        val claims: ArrayList<Claim>,

        @SerializedName("NumDistinctPlayersCasual")
        val numDistinctPlayersCasual: Long,

        @SerializedName("NumDistinctPlayersHardcore")
        val numDistinctPlayersHardcore: Long
    ) {
        data class Achievement(
            @SerializedName("ID")
            val id: Long,

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

            @SerializedName("BadgeName")
            val badgeName: String,

            @SerializedName("DisplayOrder")
            val displayOrder: Long,

            @SerializedName("MemAddr")
            val memAddr: String,

            @SerializedName("Type")
            val type: String
        )

        data class Claim(
            @SerializedName("ID")
            val id: Long,

            @SerializedName("User")
            val user: String,

            @SerializedName("GameID")
            val gameId: String,

            @SerializedName("GameTitle")
            val gameTitle: String,

            @SerializedName("GameIcon")
            val gameIcon: String,

            @SerializedName("ConsoleName")
            val consoleName: String,

            @SerializedName("ClaimType")
            val claimType: Long,

            @SerializedName("SetType")
            val setType: Long,

            @SerializedName("Status")
            val status: Int,

            @SerializedName("Extension")
            val extension: Long,

            @SerializedName("Special")
            val special: Long,

            @SerializedName("Created")
            val created: String,

            @SerializedName("DoneTime")
            val doneTime: String,

            @SerializedName("Updated")
            val updated: String,

            @SerializedName("MinutesLeft")
            val minutesLeft: Long
        )
    }
}
