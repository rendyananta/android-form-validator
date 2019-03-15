package dev.poteto.ourapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.poteto.formvalidator.Validator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val validator = Validator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            if (formsValidated()) {
                // Do your magic
            }
        }
    }

    private fun formsValidated(): Boolean {
        validator.buildRulesFor(field)
            .required()
            .min(15)
            .build()

        validator.buildRulesFor(field2)
            .required()
            .max(5)
            .validEmail()
            .onError {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }

        return validator.check()
    }
}
