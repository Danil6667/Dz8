package com.danil.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.danil.myapplication.databinding.FragmentRecyclerBinding


class RecyclerFragment : Fragment(), OnItemClickListener {
    private var binding: FragmentRecyclerBinding? = null
    private val repository = RecyclerRepository()
    private val adapter = RecyclerAdapter(this)
    private var model: RecyclerModel? = null
    private var list: ArrayList<RecyclerModel>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = repository.getListOfCharacters()
        adapter.setData(list)
        initialize()
        setOnClickListener()
        addData()
    }

    private fun initialize() {
        binding?.rvListOfName?.adapter = adapter
    }

    private fun setOnClickListener() {
        binding?.btnAdd?.setOnClickListener {
            //   findNavController().navigate(R.id.action_recyclerFragment_to_thirdFragment)
        }
    }

    override fun onClick(model: RecyclerModel?) {
        val bundle = Bundle()
        bundle.putSerializable("key", model)
            //  findNavController().navigate(R.id.action_recyclerFragment_to_detailFragment, bundle)
            .toString()
    }

    private fun addData() {
        arguments.let {
            adapter.setData2(it?.getSerializable("OK") as RecyclerModel)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
