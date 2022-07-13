package ru.patstudio.core.viewstate

class ViewState<T> (

    val status: Status,
    val data: T? = null,
    val error: Throwable? = null
)
enum class Status {

    LOADING,
    SUCCESS,
    ERROR

}