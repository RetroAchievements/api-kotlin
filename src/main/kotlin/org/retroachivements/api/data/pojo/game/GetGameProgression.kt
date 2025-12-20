package org.retroachivements.api.data.pojo.game

import com.google.gson.annotations.SerializedName

class GetGameProgression {

    data class Response(

        @SerializedName("ID")
        val id: Int,

        @SerializedName("Title")
        val title: String,

        @SerializedName("ConsoleID")
        val consoleId: Int,

        @SerializedName("ConsoleName")
        val consoleName: String,

        @SerializedName("ImageIcon")
        val imageIcon: String,

        @SerializedName("NumDistinctPlayers")
        val numDistinctPlayers: Int,

        @SerializedName("TimesUsedInBeatMedian")
        val timesUsedInBeatMedian: Int,

        @SerializedName("TimesUsedInHardcoreBeatMedian")
        val timesUsedInHardcoreBeatMedia: Int,

        @SerializedName("MedianTimeToBeat")
        val medianTimeToBeat: Int,

        @SerializedName("MedianTimeToBeatHardcore")
        val medianTimeToBeatHardcore: Int,

        @SerializedName("TimesUsedInCompletionMedian")
        val timesUsedInCompletionMedian: Int,

        @SerializedName("TimesUsedInMasteryMedian")
        val timesUsedInMasteryMedian: Int,

        @SerializedName("MedianTimeToComplete")
        val mediaTimeToComplete: Int,

        @SerializedName("MedianTimeToMaster")
        val medianTimeToMaster: Int,

        @SerializedName("NumAchievements")
        val numAchievements: Int,

        @SerializedName("Achievements")
        val achievements: List<Achievement>
    ) {
        data class Achievement(

            @SerializedName("ID")
            val id: Int,

            @SerializedName("Title")
            val title: String,

            @SerializedName("Description")
            val description: String,

            @SerializedName("Points")
            val points: Int,

            @SerializedName("TrueRatio")
            val trueRatio: Int,

            @SerializedName("Type")
            val type: String?,

            @SerializedName("BadgeName")
            val badgeName: String,

            @SerializedName("NumAwarded")
            val numAwarded: Int,

            @SerializedName("NumAwardedHardcore")
            val numAwardedHardcore: Int,

            @SerializedName("TimesUsedInUnlockMedian")
            val timesUsedInUnlockMedian: Int,

            @SerializedName("TimesUsedInHardcoreUnlockMedian")
            val timesUsedInHardcoreUnlockMedian: Int,

            @SerializedName("MedianTimeToUnlock")
            val medianTimeToUnlock: Int,

            @SerializedName("MedianTimeToUnlockHardcore")
            val medianTimeToUnlockHardcore: Int
        )
    }
}
