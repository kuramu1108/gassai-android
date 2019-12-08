package com.pocraft.gassai.api

data class Result<out T> (val status: Status, val data: T?, val message: String?) {
    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {
        fun <T> success(data: T?) = Result(Status.SUCCESS, data, null)

        fun <T> error(msg: String, data: T? = null) = Result(Status.ERROR, data, msg)

        fun <T> loading(data: T? = null) = Result(Status.LOADING, data ,null)

    }
}