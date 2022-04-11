package com.example.login.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.login.R
import com.example.login.viewmodel.MainViewModel

import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.adapter.DataStoreAdapter
import com.example.login.model.DataStore
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentHomeScreen : Fragment() {

    private var rvDataStore: RecyclerView? = null
    private var floatingActionButton: FloatingActionButton? = null
    private var regBack: ImageView? = null

    private val LIST_VIEW = "LIST_VIEW"
    private val GRID_VIEW = "GRID_VIEW"
    var currentView = LIST_VIEW
    val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_screen, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvDataStore  = view.findViewById<RecyclerView>(R.id.rv_dataStore)
        floatingActionButton  = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        regBack = view.findViewById<ImageView>(R.id.reg_back)

        listView()
        floatingActionButton?.setOnClickListener {
            if (currentView == LIST_VIEW) {
                floatingActionButton?.setImageDrawable(
                    activity?.let {
                        ContextCompat.getDrawable(
                            activity!!,
                            R.drawable.ic_list
                        )
                    }
                )
                gridView()
            } else {
                floatingActionButton?.setImageDrawable(
                    activity?.let {
                        ContextCompat.getDrawable(
                            activity!!,
                            R.drawable.ic_grid
                        )
                    }
                )
                listView()
            }
        }

        regBack?.setOnClickListener{
            val controller = findNavController()
            controller.navigate(R.id.action_fragmentHomeScreen_to_fragmentProfile)
        }

    }

    private fun listView() {
        currentView = LIST_VIEW
        rvDataStore?.layoutManager = LinearLayoutManager(activity)
        rvDataStore?.adapter = DataStoreAdapter(DataStore.getDataSet())
    }

    private fun gridView() {
        currentView = GRID_VIEW
        rvDataStore?.layoutManager = GridLayoutManager(activity, 3)
        rvDataStore?.adapter = DataStoreAdapter(DataStore.getDataSet())
    }

}