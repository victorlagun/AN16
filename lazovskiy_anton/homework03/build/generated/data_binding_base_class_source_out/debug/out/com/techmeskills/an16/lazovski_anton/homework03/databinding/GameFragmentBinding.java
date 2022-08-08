// Generated by view binder compiler. Do not edit!
package com.techmeskills.an16.lazovski_anton.homework03.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.techmeskills.an16.lazovski_anton.homework03.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class GameFragmentBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final TextView score;

  @NonNull
  public final Button skip;

  @NonNull
  public final Button submit;

  @NonNull
  public final TextInputLayout textField;

  @NonNull
  public final TextInputEditText textInputEditText;

  @NonNull
  public final TextView textViewInstructions;

  @NonNull
  public final TextView textViewUnscrambledWord;

  @NonNull
  public final TextView wordCount;

  private GameFragmentBinding(@NonNull ScrollView rootView, @NonNull TextView score,
      @NonNull Button skip, @NonNull Button submit, @NonNull TextInputLayout textField,
      @NonNull TextInputEditText textInputEditText, @NonNull TextView textViewInstructions,
      @NonNull TextView textViewUnscrambledWord, @NonNull TextView wordCount) {
    this.rootView = rootView;
    this.score = score;
    this.skip = skip;
    this.submit = submit;
    this.textField = textField;
    this.textInputEditText = textInputEditText;
    this.textViewInstructions = textViewInstructions;
    this.textViewUnscrambledWord = textViewUnscrambledWord;
    this.wordCount = wordCount;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static GameFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static GameFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.game_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static GameFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.score;
      TextView score = ViewBindings.findChildViewById(rootView, id);
      if (score == null) {
        break missingId;
      }

      id = R.id.skip;
      Button skip = ViewBindings.findChildViewById(rootView, id);
      if (skip == null) {
        break missingId;
      }

      id = R.id.submit;
      Button submit = ViewBindings.findChildViewById(rootView, id);
      if (submit == null) {
        break missingId;
      }

      id = R.id.textField;
      TextInputLayout textField = ViewBindings.findChildViewById(rootView, id);
      if (textField == null) {
        break missingId;
      }

      id = R.id.text_input_edit_text;
      TextInputEditText textInputEditText = ViewBindings.findChildViewById(rootView, id);
      if (textInputEditText == null) {
        break missingId;
      }

      id = R.id.textView_instructions;
      TextView textViewInstructions = ViewBindings.findChildViewById(rootView, id);
      if (textViewInstructions == null) {
        break missingId;
      }

      id = R.id.textView_unscrambled_word;
      TextView textViewUnscrambledWord = ViewBindings.findChildViewById(rootView, id);
      if (textViewUnscrambledWord == null) {
        break missingId;
      }

      id = R.id.word_count;
      TextView wordCount = ViewBindings.findChildViewById(rootView, id);
      if (wordCount == null) {
        break missingId;
      }

      return new GameFragmentBinding((ScrollView) rootView, score, skip, submit, textField,
          textInputEditText, textViewInstructions, textViewUnscrambledWord, wordCount);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
