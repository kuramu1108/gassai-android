package com.pocraft.gassai.view.fragment.ui

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.pocraft.gassai.R
import com.pocraft.gassai.util.nestedCoordinatorLayout
import com.pocraft.gassai.view.adapter.TeamAdapter
import com.pocraft.gassai.view.fragment.TeamFragment
import org.jetbrains.anko.*
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.collapsingToolbarLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class TeamFragmentUI: AnkoComponent<TeamFragment> {
    lateinit var recyclerView: RecyclerView
    lateinit var collapsingToolbar: CollapsingToolbarLayout
    lateinit var toolbar: Toolbar
    override fun createView(ui: AnkoContext<TeamFragment>) = with(ui) {
        nestedCoordinatorLayout {
            appBarLayout {
                id = R.id.app_bar_layout
                collapsingToolbar = collapsingToolbarLayout {
                    // ref https://chocolattips.hatenablog.com/entry/2017/03/12/000000
                    // 閉じた時(Toolbarの通常サイズ)の色
                    // 指定した場合、スクロールでImageViewにFadeIn/Outの効果
                    // 指定しない場合、ImageViewが常に表示される
                    setContentScrimColor(resources.getColor(R.color.colorPrimary, null))
                    isTitleEnabled = false
                    val imageView = imageView(R.drawable.test) {
                        id = R.id.team_top_image
                        scaleType = ImageView.ScaleType.CENTER_CROP
                    }.lparams(width = matchParent, height = dip(300)) {
                        collapseMode = CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PARALLAX
                    }
                    toolbar = toolbar {
                        id = R.id.toolbar
                        title = "asdf"
                    }.lparams(width = matchParent, height = dip(48)) {
                        minimumHeight = dip(48)
                        collapseMode = CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PIN
                    }
                }.lparams(width = matchParent, height = matchParent) {
                    fitsSystemWindows = true
                    scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or
                            AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
                }
            }.lparams(width = matchParent, height = dip(300)) {
            }

            id = R.id.teamFragment
            recyclerView = recyclerView {
                layoutManager = LinearLayoutManager(owner.context)
                adapter = TeamAdapter(owner.vm.teamList)
            }.lparams(width = matchParent, height = matchParent) {
                behavior = AppBarLayout.ScrollingViewBehavior()
            }
            lparams(width = matchParent, height = matchParent) {
            }
        }
    }
}