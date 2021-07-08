package se.micanonym.viaplaysample.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import se.micanonym.viaplaysample.databinding.FragmentSectionPageListBinding
import se.micanonym.viaplaysample.ui.SectionListAdapter
import se.micanonym.viaplaysample.ui.viewmodels.SectionPageListViewModel

@AndroidEntryPoint
class SectionPageListFragment : Fragment() {

    private val viewModel: SectionPageListViewModel by viewModels()

    private var _binding: FragmentSectionPageListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSectionPageListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        viewModel.spinner.observe(viewLifecycleOwner) { show ->
            binding.spinner.visibility = if (show) View.VISIBLE else View.GONE
        }

        viewModel.snackbar.observe(viewLifecycleOwner) { message ->
            message?.let {
                Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()
                viewModel.onSnackbarWasShown()
            }
        }

        viewModel.selectedSection.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let { section ->
                val direction =
                    SectionPageListFragmentDirections.actionSectionListFragmentToSectionDetailFragment(
                        section.id.value
                    )
                findNavController().navigate(direction)
            }
        }

        val adapter = SectionListAdapter { section ->
            viewModel.onDidSelectSection(section)
        }
        binding.mainList.adapter = adapter

        viewModel.sections.observe(viewLifecycleOwner) { sections ->
            adapter.submitList(sections)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
