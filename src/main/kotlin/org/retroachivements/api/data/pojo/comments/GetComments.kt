package org.retroachivements.api.data.pojo.comments

import com.google.gson.annotations.SerializedName

class GetComments {
    data class Response(
        @SerializedName("Count")
        val count: Long,
        @SerializedName("Total")
        val total: Long,
        @SerializedName("Results")
        val results: List<Result>,
    )

    data class Result(
        @SerializedName("User")
        val user: String,
        @SerializedName("Submitted")
        val submitted: String,
        @SerializedName("CommentText")
        val commentText: String,
    )

}
