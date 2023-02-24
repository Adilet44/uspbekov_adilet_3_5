package com.example.uspbekov_adilet_3_5

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uspbekov_adilet_3_5.databinding.FragmentChackBinding


class ChackFragment : Fragment() {
    private lateinit var binding: FragmentChackBinding
    private var chack = 0
    private var bibnMinus = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChackBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        binding.btnOperation2.visibility=View.GONE
    }

    private fun initListener() {
        binding.btnOperation.setOnClickListener {
            binding.tvCount.text = chack.toString()
            chack++
            if (chack == 11){
                binding.btnOperation.visibility=View.GONE
                binding.btnOperation2.visibility=View.VISIBLE
            }
        }
        binding.btnOperation2.setOnClickListener {
            binding.tvCount.text = chack.toString()
            chack--
            if (chack==-1){
                val boundle = Bundle()
                boundle.putString("ADIK",binding.tvCount.text.toString())

                val twoFragment = TwoFragment()
                twoFragment.arguments = boundle

                requireActivity().supportFragmentManager.beginTransaction().
                replace(R.id.fragment_container,twoFragment).addToBackStack(null).commit()

            }
        }
    }
}
