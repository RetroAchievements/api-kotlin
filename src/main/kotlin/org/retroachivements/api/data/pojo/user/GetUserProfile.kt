package org.retroachivements.api.data.pojo.user

import com.google.gson.annotations.SerializedName

class GetUserProfile {
    data class Response(
        @SerializedName("User")
        val user: String,

        @SerializedName("UserPic")
        val userPic: String,

        @SerializedName("MemberSince")
        val memberSince: String,

        @SerializedName("RichPresenceMsg")
        val richPresenceMsg: String?,

        @SerializedName("ContribYield")
        val contribYield: Int,

        @SerializedName("ContribCount")
        val contribCount: Int,

        @SerializedName("TotalPoints")
        val totalPoints: Int,

        @SerializedName("TotalSoftcorePoints")
        val totalSoftcorePoints: Int,

        @SerializedName("TotalTruePoints")
        val totalTruePoints: Long,

        @SerializedName("Permissions")
        val permissions: Int,

        @SerializedName("Untracked")
        val untracked: Int,

        @SerializedName("ID")
        val id: Long,

        @SerializedName("UserWallActive")
        val userWallActive: Boolean,

        @SerializedName("Motto")
        val motto: String?,
    )
}
