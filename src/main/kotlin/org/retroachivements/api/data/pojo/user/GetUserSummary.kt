package org.retroachivements.api.data.pojo.user

import com.google.gson.annotations.SerializedName

class GetUserSummary {

    data class Response(
        @SerializedName("User")
        val user: String,

        @SerializedName("RecentlyPlayedCount")
        val recentlyPlayedCount: Long,

        @SerializedName("RecentlyPlayed")
        val recentlyPlayed: ArrayList<RecentGame>,

        @SerializedName("MemberSince")
        val memberSince: String,

        @SerializedName("LastActivity")
        val lastActivity: Activity,

        @SerializedName("RichPresenceMsg")
        val richPresenceMsg: String?,

        @SerializedName("RichPresenceMsgDate")
        val richPresenceMsgDate: String?,

        @SerializedName("LastGameID")
        val lastGameId: Long,

        @SerializedName("LastGame")
        val lastGame: LastGame,

        @SerializedName("ContribCount")
        val contribCount: Long,

        @SerializedName("ContribYield")
        val contribYield: Long,

        @SerializedName("TotalPoints")
        val totalPoints: Long,

        @SerializedName("TotalSoftcorePoints")
        val totalSoftcorePoints: Long,

        @SerializedName("TotalTruePoints")
        val totalTruePoints: Long,

        @SerializedName("Permissions")
        val permissions: Int,

        @SerializedName("Untracked")
        val untracked: Int,

        @SerializedName("ID")
        val id: Long,

        @SerializedName("UserWallActive")
        val userWallActive: Int,

        @SerializedName("Motto")
        val motto: String?,

        @SerializedName("Rank")
        val rank: Long,

        @SerializedName("Awarded")
        val awarded: HashMap<String, Award>,

        @SerializedName("RecentAchievements")
        val recentAchievements: HashMap<String, HashMap<String, Achievement>>,

        @SerializedName("Points")
        val points: Long,

        @SerializedName("SoftcorePoints")
        val softcorePoints: Long,

        @SerializedName("UserPic")
        val userPic: String,

        @SerializedName("TotalRanked")
        val totalRanked: Long,

        @SerializedName("Status")
        val status: String
        ) {

        data class Achievement(
            @SerializedName("ID")
            val id: Long,

            @SerializedName("GameID")
            val gameId: Long,

            @SerializedName("GameTitle")
            val gameTitle: String,

            @SerializedName("Title")
            val title: String,

            @SerializedName("Description")
            val description: String,

            @SerializedName("Points")
            val points: Long,

            @SerializedName("BadgeName")
            val badgeName: String,

            @SerializedName("IsAwarded")
            val isAwarded: Boolean,

            @SerializedName("DateAwarded")
            val dateAwarded: String,

            @SerializedName("HardcoreAchieved")
            val hardcoreAchieved: Int
        )

        data class Award(
            @SerializedName("NumPossibleAchievements")
            val numPossibleAchievements: Long,

            @SerializedName("PossibleScore")
            val possibleScore: Long,

            @SerializedName("NumAchieved")
            val numAchieved: Long,

            @SerializedName("ScoreAchieved")
            val scoreAchieved: Long,

            @SerializedName("NumAchievedHardcore")
            val numAchievedHardcore: Long,

            @SerializedName("ScoreAchievedHardcore")
            val scoreAchievedHardcore: Long
        )

        data class Activity(
            @SerializedName("ID")
            val id: Long,

            @SerializedName("timestamp")
            val timestamp: String?,

            @SerializedName("lastupdate")
            val lastUpdate: String?,

            @SerializedName("activitytype")
            val activityType: Int,

            @SerializedName("User")
            val user: String,

            @SerializedName("data")
            val data: String?,

            @SerializedName("data2")
            val data2: String?
        )

        data class RecentGame(
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
            val lastPlayed: String
        )

        data class LastGame(
            @SerializedName("ID")
            val id: Long,

            @SerializedName("Title")
            val title: String,

            @SerializedName("ConsoleID")
            val consoleId: Long,

            @SerializedName("ForumTopicID")
            val forumTopicId: Long,

            @SerializedName("Flags")
            val flags: Long,

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
            val isFinal: Int,

            @SerializedName("ConsoleName")
            val consoleName: String,

            @SerializedName("RichPresencePatch")
            val richPresencePatch: String?
        )
    }
}
