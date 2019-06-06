package com.pocraft.gassai.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pocraft.gassai.view.fragment.ui.TimeTableFragmentUI
import org.jetbrains.anko.AnkoContext

class TimeTableFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            TimeTableFragmentUI().createView(AnkoContext.create(inflater.context, this, false))
}