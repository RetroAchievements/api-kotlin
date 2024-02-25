package org.retroachivements.api.core

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class DateFormat(val value: String = "yyyy-MM-dd")
