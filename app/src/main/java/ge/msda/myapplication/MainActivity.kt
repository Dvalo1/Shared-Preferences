package ge.msda.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.notes.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("MyApplication", Context.MODE_PRIVATE)
        val savedText = sharedPreferences.getString("NOTE", "")

        //notes_list.text = savedText

        var c_notes = ArrayList<Notes>()

        c_notes.add(Notes(inputText.text.toString()))

        val adapter = MainAdapter(c_notes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        addBtn.setOnClickListener {

            val input = inputText.text.toString()
            if (!TextUtils.isEmpty(input)) {

                val text = notes_list.text.toString()
                val resultText = input + "\n" + text
                notes_list.text = resultText
                inputText.setText("")
                sharedPreferences.edit().putString("NOTE", resultText).apply()

            }

        }

    }

}

class Notes(toString: String) {

}
