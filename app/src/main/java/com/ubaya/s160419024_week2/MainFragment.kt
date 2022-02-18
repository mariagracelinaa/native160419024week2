package com.ubaya.s160419024_week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    var number1 = (1..50).random()
    var number2 = (1..50).random()
    var point = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtNum1.text = number1.toString()
        txtNum2.text = number2.toString()

        btnSubmit.setOnClickListener {
            val res = (number1+number2).toString()
            val answer = txtAnswer.text.toString()

            if (res == answer) {
                number1 = (1..50).random()
                number2 = (1..50).random()

                txtNum1.text = number1.toString()
                txtNum2.text = number2.toString()

                point = point + 1
                txtAnswer.setText("")

            } else {
                val action = MainFragmentDirections.actionResultFragment(point.toString())
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

}