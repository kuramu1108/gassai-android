package com.pocraft.gassai.view.fragment.ui

import android.widget.Button
import android.widget.TextView
import com.pocraft.gassai.R
import com.pocraft.gassai.view.fragment.HomeFragment
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout

class HomeFragmentUI: AnkoComponent<HomeFragment> {
    lateinit var textView: TextView
    lateinit var fetchButton: Button
    lateinit var resultText: TextView
    override fun createView(ui: AnkoContext<HomeFragment>) = with(ui) {
        constraintLayout {
            id = R.id.homeFragment
            textView = textView {
                id = R.id.text_view
                text = "home"
            }

            fetchButton = button {
                id = R.id.fetch_button
                text = "fetch"
            }.lparams(width = wrapContent, height = wrapContent) {

                topToBottom = R.id.text_view
            }

            resultText = textView {
                id = R.id.result_text_view
                text = ""
            }.lparams(width = wrapContent, height = wrapContent) {
                topToBottom = R.id.fetch_button
            }
        }
    }
}