package com.example.wordsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.databinding.FragmentLetterListBinding
import com.example.wordsapp.databinding.FragmentWordListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WordListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WordListFragment : Fragment() {
    //simialrly to activities we gotta inflate and bind views
    // it has to be nullable since we cannot inflate the layout until oncreateview is called
    private var _binding :FragmentWordListBinding? = null
    private val binding get() = _binding!!

    companion object{
        val LETTER = "letter"
        val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    private lateinit var letterId: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Retrieve the LETTER from the Fragment arguments
        arguments?.let {
            letterId = it.getString(LETTER).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWordListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//This is almost identical to configuring the recyclerView in onCreate() in the DetailActivity.
// However, because fragments don't have direct access to the intent, you need to reference it with activity.intent.
// You have to do this in onViewCreated() however, as there's no guarantee the activity exists earlier in the lifecycle.
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//        recyclerView.adapter = WordAdapter(activity?.intent?.extras?.getString(LETTER).toString(), requireContext())
        recyclerView.adapter = WordAdapter(letterId, requireContext())

        recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
    }


}