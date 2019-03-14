package dev.poteto.validated.rules

import dev.poteto.validated.DataType
import dev.poteto.validated.contracts.ValidationMessages
import dev.poteto.validated.contracts.ValidationRule

/**
 * Class for checking the field is empty or not
 * if empty then return false
 * @param target inherit
 * @param messages inherit
 * @param type inherit
 */
class ValidateRequired(
    target: CharSequence?,
    messages: ValidationMessages,
    type: DataType
) : ValidationRule(target, messages, type) {

    /**
     * @return check the target is empty or not
     */
    override fun check(): Boolean = (target ?: "").isNotEmpty()

    /**
     * @return message to show the field was required
     */
    override fun getMessage(): String = messages.required()

}