package com.pocraft.gassai.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pocraft.gassai.view.fragment.ui.HomeFragmentUI
import org.jetbrains.anko.AnkoContext

class HomeFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            HomeFragmentUI().createView(AnkoContext.create(inflater.context, this, false))
}