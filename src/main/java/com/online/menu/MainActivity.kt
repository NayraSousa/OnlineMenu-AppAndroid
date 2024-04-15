package com.online.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.online.menu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var status: Boolean = false
    private var priceTotal: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalcular.setOnClickListener(this)
        binding.buttonFinalizarPedido.setOnClickListener(this)

    }

    override fun onClick(view: View) {

        if (view.id == R.id.button_calcular) {
            status = true
            calculate()
        }
        if (view.id == R.id.button_finalizar_pedido) {
            finalizeOrder()
            status = false
        }
    }

    private fun calculate() {

        val checkboxes = listOf(
            binding.checkboxOne,
            binding.checkboxTwo,
            binding.checkboxThree,
            binding.checkboxFour,
            binding.checkboxFive,
            binding.checkboxSix,
            binding.checkboxSeven,
            binding.checkboxEight,
            binding.checkboxNine,
            binding.checkboxTen,
            binding.checkboxEleven,
            binding.checkboxTwelve,
            binding.checkboxThirteen,
            binding.checkboxFourteen,
            binding.checkboxFifteen,
            binding.checkboxSixteen
        )

        val prices = listOf(
            binding.textPriceDadinhoTapioca.text.toString().toFloat(),
            binding.textPriceMacaxeira.text.toString().toFloat(),
            binding.textPriceBolo.text.toString().toFloat(),
            binding.textPriceCuscuzLeite.text.toString().toFloat(),
            binding.textPriceMariaBonita.text.toString().toFloat(),
            binding.textPriceArretadoBom.text.toString().toFloat(),
            binding.textPriceNordestino.text.toString().toFloat(),
            binding.textPriceAmostrado.text.toString().toFloat(),
            binding.textPriceSuco.text.toString().toFloat(),
            binding.textPriceCafe.text.toString().toFloat(),
            binding.textPriceVitamina.text.toString().toFloat(),
            binding.textPriceRefrigerante.text.toString().toFloat(),
            binding.textPriceCocadaSorvete.text.toString().toFloat(),
            binding.textPriceCanjica.text.toString().toFloat(),
            binding.textPriceMousse.text.toString().toFloat(),
            binding.textPriceSorvete.text.toString().toFloat()
        )
        priceTotal = 0f

        for ((index, checkBox) in checkboxes.withIndex()) {
            if (checkBox.isChecked) {
                priceTotal += prices[index]
            }
        }

        if (priceTotal == 0f) {
            Toast.makeText(this, R.string.priceTotalZero, Toast.LENGTH_LONG).show()
        }

        binding.textPriceTotal.text = "R$ ${"%.2f".format(priceTotal)}"
    }

    private fun finalizeOrder() {
        if (status && priceTotal > 0) {
            Toast.makeText(this, R.string.finalizeOrder, Toast.LENGTH_LONG).show()
        } else if (priceTotal <= 0) {
            Toast.makeText(this, R.string.priceZero, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, R.string.calculate, Toast.LENGTH_LONG).show()
        }
    }

}
