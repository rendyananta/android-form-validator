package dev.poteto.formvalidator.rules

import android.util.Patterns
import dev.poteto.formvalidator.DataType
import dev.poteto.formvalidator.contracts.ValidationMessages
import dev.poteto.formvalidator.contracts.PredefinedValidationRule

/**
 * Class for validating phone
 */
class ValidatePhone(
    target: CharSequence?,
    messages: ValidationMessages,
    type: DataType
) : PredefinedValidationRule(target, messages, type) {

    /**
     * @return [Boolean] checking a valid phone number with a regex
     */
    override fun check(): Boolean = Patterns.PHONE.matcher(target).matches()

    /**
     * @return [String] when validating phone number comes to fail
     */
    override fun getMessage(): String = messages.phone()
}