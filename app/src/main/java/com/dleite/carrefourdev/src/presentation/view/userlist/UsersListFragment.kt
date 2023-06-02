package com.dleite.carrefourdev.src.presentation.view.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dleite.carrefourdev.databinding.FragmentListUserBinding
import com.dleite.carrefourdev.src.presentation.model.UserListViewData
import com.dleite.carrefourdev.src.presentation.view.userlist.adapter.UserAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class UsersListFragment : Fragment() {

    private var _binding: FragmentListUserBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UserViewModel by viewModels()

    private lateinit var adapterLocation: UserAdapter
    private lateinit var userListLocation: List<UserListViewData>

    private val navControl by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListUserBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupSearch()
    }

    private fun setupSearch() {
        binding.searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener,
                OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    filterList(newText)
                    return true
                }
            })
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.states.collect {
                setupLoading(it.isLoading)
                loadUsersList(it.userList)
                loadError(it.errorMessage)
            }
        }
    }

    private fun setupLoading(loading: Boolean) {
        if (loading) {
            binding.loading.visibility = View.VISIBLE
        } else {
            binding.loading.visibility = View.GONE
        }
    }

    private fun loadError(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
    }

    private fun loadUsersList(users: List<UserListViewData>) {
        userListLocation = users;
        adapterLocation = UserAdapter(users, onItemClickListener = {
            goDetails(it.name)
        })
        binding.recyclerView.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterLocation
            isClickable = true
        }
    }

    private fun goDetails(userName: String) {
        navControl.navigate(
            UsersListFragmentDirections
                .actionUserListToUsersDetailsFragment(userName)
        )
    }


    private fun filterList(name: String?) {
        if (name != null) {
            val filteredList = ArrayList<UserListViewData>()
            for (i in userListLocation) {
                if (i.name.lowercase(Locale.ROOT).contains(name)) {
                    filteredList.add(i)
                }
            }
            if (filteredList.isEmpty()) {
                loadError("Não encontrado")
            } else {
                adapterLocation.setFilteredList(filteredList)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}