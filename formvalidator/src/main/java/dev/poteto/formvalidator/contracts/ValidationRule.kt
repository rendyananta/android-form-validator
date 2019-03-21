package dev.poteto.formvalidator.contracts

interface ValidationRule {
    /**
     * Validation check implementation,
     * this method should use to comparing things,
     * or many other you may need to validate the CharSequence inputs
     * @return the boolean result of checking implementation
     */
    fun check(): Boolean

    /**
     * @return the messages should be shown if validation fails
     */
    fun getMessage(): String
}