package com.pocraft.gassai.view.fragment.ui

import android.widget.TextView
import com.pocraft.gassai.R
import com.pocraft.gassai.view.fragment.ReminderFragment
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.textView

class ReminderFragmentUI: AnkoComponent<ReminderFragment> {
    lateinit var textView: TextView

    override fun createView(ui: AnkoContext<ReminderFragment>) = with(ui) {
        relativeLayout {
            id = R.id.reminderFragment
            textView = textView {
                id = R.id.reminder_test
                text = "reminder"
            }
        }
    }
}