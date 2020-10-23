package dev.poteto.formvalidator.rules

import dev.poteto.formvalidator.DataType
import dev.poteto.formvalidator.contracts.PredefinedValidationRule
import dev.poteto.formvalidator.contracts.ValidationMessages
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Class for validating email
 * @param target inherit
 * @param messages inherit
 * @param type inherit
 */
class ValidateCurrency(
    target: CharSequence?,
    messages: ValidationMessages,
    type: DataType
) : PredefinedValidationRule(target, messages, type) {

    /**
     * Check the email is valid or not with regex method
     */
    override fun check(): Boolean {
        val p: Pattern = Pattern.compile("^(?:0|[1-9]\\d{0,2}(?:\\.\\d{3})*),\\d{2}$")
        val m: Matcher = p.matcher(target.toString())
        if (!m.matches()){
            return false
        }
        return true
    }

    /**
     * @return message when validation fails
     */
    override fun getMessage(): String {
        val p: Pattern = Pattern.compile("^(?:0|[1-9]\\d{0,2}(?:\\.\\d{3})*),\\d{2}$")
        val m: Matcher = p.matcher(target.toString())
        if (!m.matches()){
            return messages.currency()
        }
        return ""
    }
}