package org.retroachivements.api.core

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.util.*

/**
 * This class takes care of converting integer booleans to primitive booleans,
 * some values returned from RA can be represented as integers,
 * if they migrate, it could introduce breaking changes.
 */
internal class BooleanJsonDeserializer : JsonDeserializer<Boolean> {

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Boolean {

        val primitive = json.asJsonPrimitive
        if (primitive.isBoolean) {
            return primitive.asBoolean
        }

        if (primitive.isNumber) {
            return primitive.asNumber.toInt() == 1
        }

        return false
    }
}
