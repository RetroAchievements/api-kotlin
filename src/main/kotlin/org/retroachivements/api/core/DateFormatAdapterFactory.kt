package org.retroachivements.api.core

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class DateFormatAdapterFactory : TypeAdapterFactory {

    override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T>? {
        if (type.rawType != Date::class.java) {
            return null
        }

        val dateFormat: DateFormat = getDateFormat(type.rawType)
        val adapter = createAdapter(dateFormat)

        return adapter as TypeAdapter<T>
    }

    private fun createAdapter(dateFormat: DateFormat): TypeAdapter<Date?> {
        return object: TypeAdapter<Date?>() {

            override fun write(out: JsonWriter, value: Date?) {
                if (value == null) {
                    out.nullValue()
                } else {
                    out.value(dateFormat.format(value))
                }
            }

            override fun read(`in`: JsonReader): Date? {
                return null
            }
        }
    }

    private fun getDateFormat(type: Class<*>): DateFormat {

        // obtain the date formatting annotation from [type]
        val annotation = type.getAnnotation(org.retroachivements.api.core.DateFormat::class.java)
        if (annotation != null) {
            // obtain the pattern provided
            val pattern: String = annotation.value

            // return the custom formatted pattern
            return SimpleDateFormat(pattern)
        } else {

            // return the default formatted pattern
            return SimpleDateFormat("MM/dd/yyyy")
        }
    }
}
