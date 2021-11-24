package co.id.rikihikmianto.myviewmodel

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import co.id.rikihikmianto.myviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    // private lateinit var viewModel: MainViewModel
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResult()

        binding.btnCalculate.setOnClickListener(this)
    }

    private fun displayResult() {
        binding.tvResult.text = viewModel.result.toString()
    }

    override fun onClick(v: View?) {
        val width = binding.edtWidth.text.toString()
        val length = binding.edtLength.text.toString()
        val height = binding.edtHeight.text.toString()

        when {
            width.isEmpty() -> binding.edtWidth.error = "Silahkan isi"
            length.isEmpty() -> binding.edtLength.error = "Silahkan isi"
            height.isEmpty() -> binding.edtHeight.error = "Silahkan isi"
            else -> {
                viewModel.calculate(width, height, length)
                displayResult()
            }
        }
    }
}