package org.retroachivements.api.data.pojo.game

import com.google.gson.annotations.SerializedName

class GetGameHashes {
    data class Response(
        @SerializedName("Results")
        val results: List<Result>,
    )

    data class Result(
        @SerializedName("Name")
        val name: String,

        @SerializedName("MD5")
        val md5: String,

        @SerializedName("Labels")
        val labels: List<String>,

        @SerializedName("PatchUrl")
        val patchUrl: String?,
    )

}
