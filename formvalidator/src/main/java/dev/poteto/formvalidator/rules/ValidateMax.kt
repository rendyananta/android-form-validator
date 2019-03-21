package dev.poteto.formvalidator.rules

import dev.poteto.formvalidator.DataType
import dev.poteto.formvalidator.contracts.ValidationMessages
import dev.poteto.formvalidator.contracts.PredefinedValidationRule

/**
 * Validate Max
 * This class is multi type target of validation
 * @property min
 * @param target inherit
 * @param messages inherit
 * @param type inherit
 */
class ValidateMax(
    private val min: Int,
    target: CharSequence?,
    messages: ValidationMessages,
    type: DataType
) : PredefinedValidationRule(target, messages, type) {

    /**
     * @return result of checking the limit value
     * or minimal length of characters
     */
    override fun check(): Boolean {
        return if (type == DataType.INT) {
            (target.toString().toIntOrNull() ?: 0) < min
        } else {
            (target?.length ?: 0) < min
        }
    }

    /**
     * @return message when validation fails
     */
    override fun getMessage(): String {
        return if (type == DataType.INT) {
            messages.numberMax(min)
        } else {
            messages.charactersMax(min)
        }
    }
}