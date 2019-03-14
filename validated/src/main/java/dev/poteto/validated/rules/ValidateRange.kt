package dev.poteto.validated.rules

import dev.poteto.validated.DataType
import dev.poteto.validated.contracts.ValidationMessages
import dev.poteto.validated.contracts.ValidationRule

/**
 * Class to validating range number or characters length
 * @property from the minimal value
 * @property to maximum value
 * @param target inherit
 * @param messages inherit
 * @param type inherit
 */
class ValidateRange(
    private val from: Int,
    private val to: Int,
    target: CharSequence?,
    messages: ValidationMessages,
    type: DataType
) : ValidationRule(target, messages, type) {

    /**
     * Checking the number or string is between range
     */
    override fun check(): Boolean {
        return if (type == DataType.INT) {
            (target.toString().toIntOrNull() ?: 0) in from..to
        } else {
            (target?.length ?: 0) in from..to
        }
    }

    /**
     * Error message when the number or string out of range
     */
    override fun getMessage(): String {
        return if (type == DataType.INT) {
            messages.numberRange(from, to)
        } else {
            messages.charactersRange(from, to)
        }
    }
}