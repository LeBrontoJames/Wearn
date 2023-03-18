package com.reift.wearn

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.reift.toasting.Toasting
import com.reift.wearn.adapter.WearnAdapter
import com.reift.wearn.data.Dummy
import com.reift.wearn.data.Learn
import com.reift.wearn.databinding.FragmentLearnBinding

class LearnFragment : Fragment() {

    private lateinit var binding: FragmentLearnBinding

    private lateinit var learn: Learn

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLearnBinding.inflate(layoutInflater)

        learn = arguments?.getParcelable(WearnAdapter.BUNDLE_LEARN) ?: Dummy.listWearn[3] as Learn

        setUpLearn()

        return binding.root
    }

    private fun setUpLearn() {
        binding.apply {
            tvQuestion.text = learn.question
            tvAnswer1.text = learn.listAnswer[0]
            tvAnswer2.text = learn.listAnswer[1]
            tvAnswer3.text = learn.listAnswer[2]
            tvAnswer4.text = learn.listAnswer[3]

            btnAnswer1.setOnClickListener { checkAnswer(1) }
            btnAnswer2.setOnClickListener { checkAnswer(2) }
            btnAnswer3.setOnClickListener { checkAnswer(3) }
            btnAnswer4.setOnClickListener { checkAnswer(4) }
        }
    }

    private fun checkAnswer(answer: Int) {
        if (answer == learn.trueAnswer) {
            showToasting(
                Toasting.SUCCESS_TYPE,
                "You got it Right!",
                "Your answer was ${learn.listAnswer[answer - 1]}",
                "See Explanation"
            ) {
                showToasting(
                    Toasting.WARNING_TYPE,
                    learn.question,
                    learn.explanation,
                    "Got it"
                ) {}
            }
        } else {
            showToasting(
                Toasting.ERROR_TYPE,
                "Sadly you're Wrong :(",
                "Your answered ${learn.listAnswer[answer - 1]} and the right answer is ${learn.listAnswer[learn.trueAnswer - 1]}",
                "See Explanation"
            ) {
                showToasting(
                    Toasting.WARNING_TYPE,
                    learn.question,
                    learn.explanation,
                    "Got it"
                ) {}
            }
        }
    }

    private fun getFont(font: Int): Typeface? {
        return ResourcesCompat.getFont(requireContext(), font)
    }

    private fun showToasting(
        type: String,
        title: String,
        content: String,
        btnMessage: String,
        onButtonClick: () -> Unit
    ) {
        Toasting.Builder(type)
            .setTitleText(title)
            .setContentText(content)
            .setButtonMessage(btnMessage)
            .setTitleFont(getFont(R.font.lexend_bold))
            .setContentFont(getFont(R.font.lexend_regular))
            .setButtonFont(getFont(R.font.lexend_semibold))
            .setOnButtonClick {
                onButtonClick()
            }
            .show(requireActivity().supportFragmentManager)
    }
}