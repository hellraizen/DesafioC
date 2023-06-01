package com.dleite.carrefourdev.src.presentation.view.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dleite.carrefourdev.R
import com.dleite.carrefourdev.databinding.FragmentListUserBinding
import com.dleite.carrefourdev.src.presentation.model.UserListViewData
import com.dleite.carrefourdev.src.presentation.onAction
import com.dleite.carrefourdev.src.presentation.onStateChange
import com.dleite.carrefourdev.src.presentation.view.userlist.adapter.UserAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersListFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private var _binding: FragmentListUserBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UserViewModel by viewModels()

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
        //   binding.searchButton.setOnClickListener {
        //       viewModel.getUsers()
        //   }
    }


    override fun onResume() {
        super.onResume()
        viewModel.getUsers()
    }

    private fun setupObservers() {
        onAction(viewModel) { action ->
            when (action) {
                is UserAction.ShowUsers -> loadUsersList(action.users)
                is UserAction.ShowErrorMessage -> loadError(action.errorMessage)
            }
        }
        onStateChange(viewModel) { viewState ->
            setupLoading(viewState.isLoading)
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
        val adapterLocation = UserAdapter(users, onItemClickListener = {
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

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}