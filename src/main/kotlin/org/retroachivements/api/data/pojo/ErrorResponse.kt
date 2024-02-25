package org.retroachivements.api.data.pojo

data class ErrorResponse(
    val message: String,
    val errors: ArrayList<Error>
) {
    data class Error (
        val status: Int,
        val code: String,
        val title: String
    )
}
