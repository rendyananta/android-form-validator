package dev.poteto.formvalidator.rules

import dev.poteto.formvalidator.DataType
import dev.poteto.formvalidator.contracts.ValidationMessages
import dev.poteto.formvalidator.contracts.ValidationRule

/**
 * Class for validating email
 * @param target inherit
 * @param messages inherit
 * @param type inherit
 */
class ValidateEmail(
    target: CharSequence?,
    messages: ValidationMessages,
    type: DataType
) : ValidationRule(target, messages, type) {

    /**
     * Check the email is valid or not with regex method
     */
    override fun check(): Boolean = Regex("(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
            .matches(target ?: "")

    /**
     * @return message when target is not a valid email
     */
    override fun getMessage(): String = messages.email()
}