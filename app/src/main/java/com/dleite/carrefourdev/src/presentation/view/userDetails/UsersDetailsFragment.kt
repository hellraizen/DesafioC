package com.dleite.carrefourdev.src.presentation.view.userDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.dleite.carrefourdev.databinding.FragmentDetailsUserBinding
import com.dleite.carrefourdev.src.domain.model.User
import com.dleite.carrefourdev.src.presentation.model.RepoGitListViewData
import com.dleite.carrefourdev.src.presentation.model.UserViewData
import com.dleite.carrefourdev.src.presentation.onAction
import com.dleite.carrefourdev.src.presentation.onStateChange
import com.dleite.carrefourdev.src.presentation.view.userDetails.adapter.RepoGitAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersDetailsFragment : Fragment() {

    private var _binding: FragmentDetailsUserBinding? = null
    private val binding get() = _binding!!

    private val args: UsersDetailsFragmentArgs by navArgs()

    private val viewModel: UserDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsUserBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    override fun onResume() {
        super.onResume()
        loadDate()
    }

    private fun setupObservers() {
        binding.backBtn.setOnClickListener{
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        onAction(viewModel) { action ->
            when (action) {
                is UserDetailAction.ShowRepoGit -> loadRepoGitList(action.repoGit)
                is UserDetailAction.ShowUser -> loadUser( action.users)
                is UserDetailAction.ShowErrorMessage -> loadError(action.errorMessage)
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

    private fun loadRepoGitList(repoGit: List<RepoGitListViewData>) {
        val adapterLocation = RepoGitAdapter(repoGit)
        binding.recyclerViewRepository.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterLocation
        }
    }

    private fun loadUser(user:UserViewData){
        binding.run {
            name.text = user.name
            login.text = user.login
            fork.text = user.publicRepo.toString()
            Glide.with(pictureUser).load(user.imgUrl).into(pictureUser)
        }
    }
    private fun loadDate(){
        viewModel.getRepoGit(args.userName)
        viewModel.getUser(args.userName)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}