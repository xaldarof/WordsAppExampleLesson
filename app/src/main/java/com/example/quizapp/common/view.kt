package com.example.quizapp.common

import android.widget.EditText

/**
 * @Author: Temur
 * @Date: 27/07/2022
 */


val EditText.str: String
    get() {
        return this.text.toString()
    }