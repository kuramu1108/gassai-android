package com.pocraft.gassai.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pocraft.gassai.view.fragment.ui.ReminderFragmentUI
import org.jetbrains.anko.AnkoContext

class ReminderFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            ReminderFragmentUI().createView(AnkoContext.create(inflater.context, this, false))
}