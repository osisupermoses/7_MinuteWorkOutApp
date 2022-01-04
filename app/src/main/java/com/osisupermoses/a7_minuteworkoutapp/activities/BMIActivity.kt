package com.osisupermoses.a7_minuteworkoutapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.osisupermoses.a7_minuteworkoutapp.R
import com.osisupermoses.a7_minuteworkoutapp.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBmiBinding

    companion object {
        private const val METRIC_UNITS_VIEW = "METRIC_UNIT_VIEW" // Metric Unit View
        private const val US_UNITS_VIEW = "US_UNIT_VIEW" // US Unit View
    }

    private var currentVisibleView: String =
        METRIC_UNITS_VIEW // A variable to hold a value to make a selected  view visible

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarBmiActivity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "CALCULATE BMI"

        binding.toolbarBmiActivity.setNavigationOnClickListener {
            onBackPressed()
        }

        makeMetricUnitsViewVisible()

        binding.rgUnits.setOnCheckedChangeListener { _, checkedId: Int ->
            if (checkedId == R.id.rbMetricUnits) {
                makeMetricUnitsViewVisible()
            } else {
                makeUSUnitsViewVisible()
            }
        }

        binding.btnCalculateUnits.setOnClickListener {
            calculateUnits()
        }
    }

    /**
     * Function is used to validate the input values for METRIC UNITS.
     */
    private fun validateMetricUnits(): Boolean {
        var isValid = true

        if (binding.etMetricUnitWeight.text.toString().isEmpty()) {
            isValid = false
        } else if (binding.etMetricUnitHeight.text.toString().isEmpty()) {
            isValid = false
        }
        return isValid
    }

    private fun displayBMIResult(bmi: Float) {

        var bmiLabel: String = ""
        var bmiDescription: String = ""

        if (bmi.compareTo(15f) <= 0) {
            bmiLabel = "Very severely underweight"
            bmiDescription = "Oops! You really need to take better care of yourself! Eat more!!"
        } else if (bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <= 0) {
            bmiLabel = "Severely underweight"
            bmiDescription = "Oops! You really need to take better care of yourself! Eat more!!"
        } else if (bmi.compareTo(18f) > 0 && bmi.compareTo(18.5f) <= 0) {
            bmiLabel = "Underweight"
            bmiDescription = "Oops! You really need to take better care of yourself! Eat more!!"
        } else if (bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0) {
            bmiLabel = "Normal"
            bmiDescription = "Congratulations! You are in a good shape!!"
        } else if (bmi.compareTo(25f) > 0 && bmi.compareTo(30f) <= 0) {
            bmiLabel = "Overweight"
            bmiDescription = "Oops! You really need to take care of yourself! Engage in exercises!!"
        } else if (bmi.compareTo(30f) > 0 && bmi.compareTo(35f) <= 0) {
            bmiLabel = "Obese Class | (Moderately obese)"
            bmiDescription = "Oops! You really need to take care of yourself! Engage in exercises!!"
        } else if (bmi.compareTo(35f) > 0 && bmi.compareTo(40f) <= 0) {
            bmiLabel = "Obese Class || (Severely obese)"
            bmiDescription = "OMG! You are in a very dangerous condition!! Act now!!!"
        } else {
            bmiLabel = "Obese Class ||| (Very severely obese)"
            bmiDescription = "OMG! You are in a very dangerous condition!! Act now!!!"
        }

        val bmiValue = BigDecimal(bmi.toDouble())
            .setScale(2, RoundingMode.HALF_EVEN).toString()

        binding.llDisplayBMIResult.visibility = View.VISIBLE
        binding.tvBMIValue.text = bmiValue
        binding.tvBMIType.text = bmiLabel
        binding.tvBMIDescription.text = bmiDescription
    }

    private fun makeMetricUnitsViewVisible() {
        currentVisibleView = METRIC_UNITS_VIEW // Current View is updated here.
        binding.tilMetricUnitWeight.visibility = View.VISIBLE // METRIC  Height UNITS VIEW is Visible
        binding.tilMetricUnitHeight.visibility = View.VISIBLE // METRIC  Weight UNITS VIEW is Visible
        binding.tilMetricUSUnitWeight.visibility = View.GONE // make weight view Gone.
        binding.tilMetricUsUnitHeightFeet.visibility = View.GONE // make height feet view Gone.
        binding.tilMetricUsUnitHeightInch.visibility = View.GONE // make height inch view Gone.

        binding.etMetricUnitHeight.text!!.clear() // height value is cleared if it is added.
        binding.etMetricUnitWeight.text!!.clear() // weight value is cleared if it is added.

        binding.llDisplayBMIResult.visibility = View.INVISIBLE

    }

    private fun makeUSUnitsViewVisible() {
        currentVisibleView = US_UNITS_VIEW
        binding.tilMetricUnitWeight.visibility = View.INVISIBLE
        binding.tilMetricUnitHeight.visibility = View.INVISIBLE
        binding.tilMetricUSUnitWeight.visibility = View.VISIBLE
        binding.tilMetricUsUnitHeightFeet.visibility = View.VISIBLE
        binding.tilMetricUsUnitHeightInch.visibility = View.VISIBLE

        binding.etUsMetricUnitWeight.text!!.clear() // weight value is cleared if added
        binding.etUsMetricUnitHeightFeet.text!!.clear() // height feet is cleared if added
        binding.etUsMetricUnitHeightInch.text!!.clear() // height inch is cleared if added

        binding.llDisplayBMIResult.visibility = View.INVISIBLE

    }

    /**
     * Function is used to validate the input values for US UNITS.
     */
    private fun validateUSUnits(): Boolean {
        var isValid = true

        when {
            binding.etUsMetricUnitWeight.text.toString().isEmpty() -> {
                isValid = false
            }
            binding.etUsMetricUnitHeightFeet.text.toString().isEmpty() -> {
                isValid = false
            }
            binding.etUsMetricUnitHeightInch.text.toString().isEmpty() -> {
                isValid = false
            }
        }

        return isValid
    }

    private fun calculateUnits() {
        if (currentVisibleView == METRIC_UNITS_VIEW) {
            if (validateMetricUnits()) {
                val heightValue: Float = binding.etMetricUnitHeight.text.toString().toFloat() / 100
                val weightValue: Float = binding.etMetricUnitWeight.text.toString().toFloat()

                val bmi = weightValue / (heightValue * heightValue)

                displayBMIResult(bmi)

            } else {
                Toast.makeText(
                    this,
                    "Please enter valid values.",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        } else {
            if (validateUSUnits()) {
                val usUnitHeightValueFeet: String =
                    binding.etUsMetricUnitHeightFeet.text.toString() // Height Feet value entered in EditText component.
                val usUnitHeightValueInch: String =
                    binding.etUsMetricUnitHeightInch.text.toString() // Height Inch value entered in EditText component.
                val usUnitWeightValue: Float =
                    binding.etUsMetricUnitWeight.text.toString().toFloat() // Weight value entered in EditText component.

                // Here the Height Feet and Inch values are merged and multiplied by 12 for converting it to inches.
                val heightValue =
                    usUnitHeightValueInch.toFloat() + usUnitHeightValueFeet.toFloat() * 12

                // This is the Formula for US UNITS result.
                // Reference Link : https://www.cdc.gov/healthyweight/assessing/bmi/childrens_bmi/childrens_bmi_formula.html
                val bmi = 703 * (usUnitWeightValue / (heightValue * heightValue))

                displayBMIResult(bmi) // Displaying the result into UI

            } else {
                Toast.makeText(
                    this@BMIActivity,
                    "Please enter valid values.",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }
}