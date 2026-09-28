package com.example.myflexiblefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class HomeFragment : Fragment(), View.OnClickListener {
    private lateinit var btnCategory: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCategory = view.findViewById(R.id.btn_category)
        btnCategory.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_category) {
            val mFragmentManager = parentFragmentManager
            val mCategoryFragment = CategoryFragment()
            mFragmentManager.commit {
                replace(
                    R.id.frame_container, mCategoryFragment, CategoryFragment::class.java.simpleName
                )
                addToBackStack(null)
            }
        }
    }
}