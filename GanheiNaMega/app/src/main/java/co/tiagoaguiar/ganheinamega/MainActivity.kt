package co.tiagoaguiar.ganheinamega

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//AppCompactAcitivty informa ao sistema operacional android que a nossa classe herda todas as características de uma activity
//setContentView espera que voce envie um identificador de recursos/layout da pasta res(qual activity?)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_generate)

        btnGenerate.setOnClickListener{
            val text = editText.text.toString()
            numberGenerator(text, txtResult)
        }
    }
    private fun numberGenerator(text: String, txtResult:TextView){
        //validação de quando o campo for vazio
        if (text.isNotEmpty()){
            val qtd = text.toInt()//converte string para inteiro
            //validação de que o campo deve ter números entre 6 e 15
            if (qtd >= 6 && qtd <= 15){

                val numbers = mutableSetOf<Int>()
                val random = Random()

                while (true){
                    val number = random.nextInt(60) //0..59
                    numbers.add(number+1)
                    if (numbers.size == qtd){
                        break
                    }
                }

                txtResult.text = numbers.joinToString(" - ")

            }else{
                Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG)

            }
        }else{
            Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG)
                .show()
        }



    }
}