package id.ac.ubaya.informatika.adv160420124week2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation

class GameFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var point = 0
        val ArrNum1 = (0..100).shuffled().random()
        val numOne = view.findViewById<TextView>(R.id.txtNo1)
        numOne.text = ArrNum1.toString()

        val ArrNum2 = (0..100).shuffled().random()
        val numTwo = view.findViewById<TextView>(R.id.txtNo2)
        numTwo.text = ArrNum2.toString()

        val editAnswer = view.findViewById<EditText>(R.id.editAnswer)
        val answer = editAnswer.text

        var jumlah = ArrNum1 + ArrNum2

        val btnSubmit = view.findViewById<Button>(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            if(answer.toString() == jumlah.toString())
            {
                val ArrNum1 = (0..100).shuffled().random()
                val numOne = view.findViewById<TextView>(R.id.txtNo1)
                numOne.text = ArrNum1.toString()

                val ArrNum2 = (0..100).shuffled().random()
                val numTwo = view.findViewById<TextView>(R.id.txtNo2)
                numTwo.text = ArrNum2.toString()

                val editAnswer = view.findViewById<EditText>(R.id.editAnswer)
                val answer = editAnswer.text
                answer.clear()

                jumlah = ArrNum1 + ArrNum2

                point ++
            } else {
                val action = GameFragmentDirections.actionResultFragment(point)
                Navigation.findNavController(it).navigate(action)
//                Toast.makeText(this.context, point.toString(), Toast.LENGTH_SHORT).show()
//                Toast.makeText(this.context, answer.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        arguments?.let {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            val txtTurn = view.findViewById<TextView>(R.id.txtTurn)
            txtTurn.text = "$playerName's Turn"
        }

//        if(arguments != null) {
//            val playerName =
//                GameFragmentArgs.fromBundle(requireArguments()).playerName
//            val txtTurn = view.findViewById<Button>(R.id.txtTurn)
//            txtTurn.text = "$playerName's Turn"
//        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }
}