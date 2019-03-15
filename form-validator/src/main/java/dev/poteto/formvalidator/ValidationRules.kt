package dev.poteto.formvalidator

import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import dev.poteto.formvalidator.contracts.ValidationMessages
import dev.poteto.formvalidator.contracts.ValidationRule
import dev.poteto.formvalidator.rules.*

/**
 * Validation rules class
 * Purpose of this class is for configuring
 * the validation rules of each validation target
 * @property validatorInstance for chaining purpose
 * @property target [CharSequence] to be validated
 * @property messages [ValidationMessages] messages set to be used
 * @property type [DataType] is to know the type of validator to be used
 * while the validation comes to fails
 */
class ValidationRules (
    private val validatorInstance: Validator,
    private val target: CharSequence?,
    private val messages: ValidationMessages,
    private val type: DataType = DataType.STRING
) {

    /**
     * @property rules makes our life easier
     * we just iterate it items, then do checking
     */
    private val rules: MutableList<ValidationRule> = mutableListOf()

    /**
     * @property editText for setting the error messages directly
     */
    private var editText: EditText? = null

    /**
     * @property customErrorCallback
     * This will save the custom callback and invoke it
     * when it's initialized or when user call
     * @see onError method
     */
    private lateinit var customErrorCallback: (String) -> Unit

    /**
     * @constructor accept EditText
     */
    constructor(validatorInstance: Validator, target: EditText, messages: ValidationMessages)
            : this(validatorInstance, target.text.toString(), messages) {
        editText = target
    }

    /**
     * @return [Boolean] validation results of given rules
     * iterate any rules in class property
     * @see rules
     */
    fun validate(): Boolean {
        var checker = true

        run validator@ {
            rules.forEach {
                checker = checker.and(it.check())

                // If any error happens, we set the message
                // and end the loop
                if (! checker) {

                    if (::customErrorCallback.isInitialized) {
                        customErrorCallback.invoke(it.getMessage())
                    } else {
                        errorCallback(it.getMessage())
                    }

                    return@validator
                }
            }
        }

        return checker
    }

    /**
     * Append the rule into rules that will be checked per item
     * @return [ValidationRule]
     */
    private fun appendRule(rule: ValidationRule): ValidationRule {
        // We append the rules, then return the
        // instance of validation rule
        rules.add(rule)
        return rule
    }

    /**
     * Callback, we will invoke this method if the
     * error from validation returned a.k.a false
     * If you use your custom views, you can extend this class
     * and override this method
     * @param message to be shown
     * @return [Unit]
     */
    private fun errorCallback(message: String) {
        editText?.let {
            // Check if the parent of parent is TextInputLayout
            val parent = it.parent.parent
            if (parent is TextInputLayout) {
                // This will be useful,
                parent.error = message
            } else {
                it.error = message
            }
        }
    }

    /**
     * Clear errors messages
     */
    fun clearErrors() {
        editText?.let {
            it.error = null
        }
    }

    /**
     * Custom error callback
     */
    fun onError(block: (String) -> Unit) {
        customErrorCallback = block
    }

    /**
     * @return [Validator] to continue chains
     */
    fun build(): Validator {
        return validatorInstance
    }

    /**
     * @see ValidateRequired class for details
     * @return this
     */
    fun required(): ValidationRules {
        appendRule(ValidateRequired(target, messages, type))
        return this
    }

    /**
     * @see ValidateMin class for details
     * @return this
     */
    fun min(min: Int): ValidationRules {
        appendRule(ValidateMin(min, target, messages, type))
        return this
    }

    /**
     * @see ValidateMax class for details
     * @return this
     */
    fun max(max: Int): ValidationRules {
        appendRule(ValidateMax(max, target, messages, type))
        return this
    }

    /**
     * @see ValidateEmail class for details
     * @return this
     */
    fun validEmail(): ValidationRules {
        appendRule(ValidateEmail(target, messages, type))
        return this
    }

    /**
     * @see ValidateRange class for details
     */
    fun range(from: Int, to: Int): ValidationRules {
        appendRule(ValidateRange(from, to, target, messages, type))
        return this
    }
}