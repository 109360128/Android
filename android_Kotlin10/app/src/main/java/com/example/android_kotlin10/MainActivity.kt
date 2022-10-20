package com.example.android_kotlin10

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.widget.RadioButton
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var ed_name: EditText? = null
    private var tv_text: TextView? = null
    private var tv_name: TextView? = null
    private var tv_winner: TextView? = null
    private var tv_mmora: TextView? = null
    private var tv_cmora: TextView? = null
    private var btn_scissor: RadioButton? = null
    private var btn_stone: RadioButton? = null
    private var btn_paper: RadioButton? = null
    private var btn_mora: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var ed_name = findViewById<EditText>(R.id.ed_name)
        var tv_text = findViewById<TextView>(R.id.tv_text)
        var tv_name = findViewById<TextView>(R.id.tv_name)
        var tv_winner = findViewById<TextView>(R.id.tv_winner)
        var tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        var tv_cmora = findViewById<TextView>(R.id.tv_cmora)
        var btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        var btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        var btn_paper = findViewById<RadioButton>(R.id.btn_paper)
        var btn_mora = findViewById<Button>(R.id.btn_mora)
        btn_mora.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if (ed_name.length() < 1) {
                    tv_text.setText("請輸入玩家姓名")
                } else {
                    tv_name.setText(String.format("名字\n%s", ed_name.getText().toString()))
                    if (btn_scissor.isChecked()) {
                        tv_mmora.setText("我方出拳\n剪刀")
                    } else if (btn_stone.isChecked()) {
                        tv_mmora.setText("我方出拳\n石頭")
                    } else {
                        tv_mmora.setText("我方出拳\n布")
                    }
                    val computer = (Math.random() * 3).toInt()
                    if (computer == 0) tv_cmora.setText("電腦出拳\n剪刀") else if (computer == 1) {
                        tv_cmora.setText("電腦出拳\n石頭")
                    } else {
                        tv_cmora.setText("電腦出拳\n布")
                    }
                    if (btn_scissor.isChecked() && computer == 2 || btn_stone.isChecked() && computer == 0 || btn_paper.isChecked() && computer == 1) {
                        tv_winner.setText(
                            """
    勝利者
    ${ed_name.getText()}
    """.trimIndent()
                        )
                        tv_text.setText("恭喜你獲勝了!!!")
                    } else if (btn_scissor.isChecked() && computer == 1 || btn_stone.isChecked() && computer == 2 || btn_paper.isChecked() && computer == 0) {
                        tv_winner.setText("勝利者\n電腦")
                        tv_text.setText("可惜電腦獲勝了")
                    } else {
                        tv_winner.setText("勝利者\n平手")
                        tv_text.setText("平手，再試1一次")
                    }
                }
            }
        })
    }
}