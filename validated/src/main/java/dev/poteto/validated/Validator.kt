package dev.poteto.validated

import android.widget.EditText
import dev.poteto.validated.contracts.ValidationMessages

/**
 * Main Validator class
 * @param messages optional ]is the messages set,
 * should be separated by languages
 * @method buildRulesFor can be added, if you want to
 * supporting any types of view classes you decided to use
 * @constructor apply the [ValidationMessages]
 */
class Validator (private val messages: ValidationMessages = DefaultMessage) {

    /**
     * @property fields to save any fields for validating purpose
     */
    private val fields: MutableList<ValidationRules> = mutableListOf()

    /**
     * @param target [EditText] to be validate
     * @return ValidationRules with target and message configured
     */
    fun buildRulesFor(target: EditText): ValidationRules {
        val rules = ValidationRules(this, target, messages)
        fields.add(rules)
        return rules
    }

    /**
     * @param target [CharSequence] to be validate
     * @return ValidationRules with target and message configured
     */
    fun buildRulesFor(target: CharSequence?): ValidationRules {
        val rules = ValidationRules(this, target, messages)
        fields.add(rules)
        return rules
    }

    /**
     * @return [Boolean] result of all validation rules
     * This method return all fields that have been attached using
     * @see buildRulesFor method
     */
    fun check(): Boolean {
        var validationResult = true
        fields.forEach {
            validationResult = validationResult.and(it.validate())
        }

        // Clear all fields, prevent duplicate of list element
        this.clear()

        return validationResult
    }

    /**
     * Reset all fields from error state
     */
    fun reset() {
        fields.forEach {
            it.clearErrors()
        }
    }

    /**
     * Remove all fields
     */
    fun clear() {
        fields.clear()
    }

}