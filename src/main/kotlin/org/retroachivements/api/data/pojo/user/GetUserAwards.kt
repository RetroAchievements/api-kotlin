package org.retroachivements.api.data.pojo.user

import com.google.gson.annotations.SerializedName

class GetUserAwards {

    data class Response(
        @SerializedName("TotalAwardsCount")
        val totalAwardsCount: Long,

        @SerializedName("HiddenAwardsCount")
        val hiddenAwardsCount: Long,

        @SerializedName("MasteryAwardsCount")
        val masteryAwardsCount: Long,

        @SerializedName("CompletionAwardsCount")
        val completionAwardsCount: Long,

        @SerializedName("BeatenHardcoreAwardsCount")
        val beatenHardcoreAwardsCount: Long,

        @SerializedName("EventAwardsCount")
        val eventAwardsCount: Long,

        @SerializedName("SiteAwardsCount")
        val siteAwardsCount: Long,

        @SerializedName("VisibleUserAwards")
        val visibleUserAwards: ArrayList<Award>
    ) {
        data class Award(
            @SerializedName("AwardedAt")
            val awardedAt: String,

            @SerializedName("AwardType")
            val awardType: String,

            @SerializedName("AwardData")
            val awardData: Long,

            @SerializedName("AwardDataExtra")
            val awardDataExtra: Int,

            @SerializedName("DisplayOrder")
            val displayOrder: Int,

            @SerializedName("Title")
            val title: String,

            @SerializedName("ConsoleID")
            val consoleId: Long,

            @SerializedName("ConsoleName")
            val consoleName: String,

            @SerializedName("Flags")
            val flags: Int,

            @SerializedName("ImageIcon")
            val imageIcon: String
        )
    }
}
