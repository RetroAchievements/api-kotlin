package org.retroachivements.api.data.pojo.system

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import org.retroachivements.api.core.BooleanJsonDeserializer

class GetConsoleID {

    class Response: ArrayList<Response.Console>() {
        data class Console (
            @SerializedName("ID")
            val id: Long,

            @SerializedName("Name")
            val name: String,

            @SerializedName("IconURL")
            val iconUrl: String,

            @JsonAdapter(BooleanJsonDeserializer::class)
            @SerializedName("Active")
            val active: Boolean,

            @JsonAdapter(BooleanJsonDeserializer::class)
            @SerializedName("IsGameSystem")
            val isGameSystem: Boolean
        )
    }
}
