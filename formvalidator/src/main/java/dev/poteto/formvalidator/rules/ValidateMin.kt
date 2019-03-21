package dev.poteto.formvalidator.rules

import dev.poteto.formvalidator.DataType
import dev.poteto.formvalidator.contracts.ValidationMessages
import dev.poteto.formvalidator.contracts.PredefinedValidationRule

/**
 * Validate Min
 * This class is multi type target of validation
 * @property min
 * @param target inherit
 * @param messages inherit
 * @param type inherit
 */
class ValidateMin(
    private val min: Int,
    target: CharSequence?,
    messages: ValidationMessages,
    type: DataType
) : PredefinedValidationRule(target, messages, type) {

    /**
     * @return result of checking the minimal value
     * or minimal length of characters
     */
    override fun check(): Boolean {
        return if (type == DataType.INT) {
            (target.toString().toIntOrNull() ?: 0) > min
        } else {
            (target?.length ?: 0) > min
        }
    }

    /**
     * @return message when validation fails
     */
    override fun getMessage(): String {
        return if (type == DataType.INT) {
            messages.numberMin(min)
        } else {
            messages.charactersMin(min)
        }
    }
}