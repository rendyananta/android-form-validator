package dev.poteto.formvalidator.rules

import dev.poteto.formvalidator.DataType
import dev.poteto.formvalidator.contracts.ValidationMessages
import dev.poteto.formvalidator.contracts.ValidationRule

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