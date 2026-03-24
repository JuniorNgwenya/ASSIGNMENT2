package com.example.ice2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    //declarations

    private lateinit var tvTitle: TextView
    private lateinit var btnCheck: Button
    private lateinit var edtWithdrawal: EditText
    private lateinit var tvResult: TextView
    val balance = 3000
    val dailyLimit = 5000


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //typercasting

        tvTitle = findViewById(R.id.tvTitle)
        btnCheck = findViewById(R.id.btnCheck)
        edtWithdrawal = findViewById(R.id.edtWithdrawal)
        tvResult = findViewById(R.id.tvResult)



        btnCheck.setOnClickListener {
            // 1. Get the input and convert it to a number
            val withdrawalAmount = edtWithdrawal.text.toString().toDoubleOrNull()

            // Step 2: make input null
            if (withdrawalAmount == null) {
                tvResult.text = "Please enter a valid amount"
                return@setOnClickListener
            }

            // Step 3:IF/ELSE statement
            if (withdrawalAmount > balance) {
                tvResult.text = "Insufficient funds"
            } else if (withdrawalAmount > dailyLimit) {
                tvResult.text = "Daily limit exceeded"
            } else {
                val newBalance = balance - withdrawalAmount
                tvResult.text = "Withdrawal successful. New balance: R$newBalance"
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

}