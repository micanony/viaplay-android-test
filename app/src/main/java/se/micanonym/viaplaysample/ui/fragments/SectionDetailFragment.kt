package se.micanonym.viaplaysample.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import se.micanonym.viaplaysample.data.models.Id
import se.micanonym.viaplaysample.databinding.FragmentSectionDetailBinding
import se.micanonym.viaplaysample.ui.MainActivity
import se.micanonym.viaplaysample.ui.viewmodels.SectionDetailViewModel

@AndroidEntryPoint
class SectionDetailFragment : Fragment() {

    private val args: SectionDetailFragmentArgs by navArgs()
    private val viewModel: SectionDetailViewModel by viewModels()

    private var _binding: FragmentSectionDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSectionDetailBinding.inflate(layoutInflater, container, false)
        context ?: return binding.root

        viewModel.sectionDetail(Id(args.sectionId)).observe(viewLifecycleOwner) { sectionDetails ->
            with(sectionDetails) {
                binding.tvTitle.text = title
                binding.tvDescription.text = description
                (activity as? MainActivity)?.supportActionBar?.title = title
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
