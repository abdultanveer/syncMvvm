package com.abdul.mvvmapp.customviews;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.res.ResourcesCompat;

import com.abdul.mvvmapp.R;

public class EditTextWithClear extends AppCompatEditText {

    Drawable mClearButtonImage;

    public EditTextWithClear(Context context) {
        super(context);
        init();
    }

    public EditTextWithClear(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditTextWithClear(Context context,
                             AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // Initialize Drawable member variable.
        mClearButtonImage =
                ResourcesCompat.getDrawable(getResources(),
                        R.drawable.ic_baseline_clear_24, null);

        // If the X (clear) button is tapped, clear the text.
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Use the getCompoundDrawables()[2] expression to check
                // if the drawable is on the "end" of text [2].
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    if ((getCompoundDrawablesRelative()[2] != null)) {
                        float clearButtonStart; // Used for LTR languages
                        float clearButtonEnd;  // Used for RTL languages
                        boolean isClearButtonClicked = false;
                        // Detect the touch in RTL or LTR layout direction.
                        if (getLayoutDirection() == LAYOUT_DIRECTION_RTL) {
                            // If RTL, get the end of the button on the left side.
                            clearButtonEnd = mClearButtonImage
                                    .getIntrinsicWidth() + getPaddingStart();
                            // If the touch occurred before the end of the button,
                            // set isClearButtonClicked to true.
                            if (event.getX() < clearButtonEnd) {
                                isClearButtonClicked = true;
                            }
                        } else {
                            // Layout is LTR.
                            // Get the start of the button on the right side.
                            clearButtonStart = (getWidth() - getPaddingEnd()
                                    - mClearButtonImage.getIntrinsicWidth());
                            // If the touch occurred after the start of the button,
                            // set isClearButtonClicked to true.
                            if (event.getX() > clearButtonStart) {
                                isClearButtonClicked = true;
                            }
                        }
                        // Check for actions if the button is tapped.
                        if (isClearButtonClicked) {
                            // Check for ACTION_DOWN (always occurs before ACTION_UP).
                            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                // Switch to the black version of clear button.
                                mClearButtonImage =
                                        ResourcesCompat.getDrawable(getResources(),
                                                R.drawable.ic_baseline_clear_24, null);
                                showClearButton();
                            }
                            // Check for ACTION_UP.
                            if (event.getAction() == MotionEvent.ACTION_UP) {
                                // Switch to the opaque version of clear button.
                                mClearButtonImage =
                                        ResourcesCompat.getDrawable(getResources(),
                                                R.drawable.ic_baseline_clear_24, null);
                                // Clear the text and hide the clear button.
                                getText().clear();
                                hideClearButton();
                                return true;
                            }
                        } else {
                            return false;
                        }
                    }
                }
                return false;
            }
        });

        // If the text changes, show or hide the X (clear) button.
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s,
                                          int start, int count, int after) {
                // Do nothing.
            }

            @Override
            public void onTextChanged(CharSequence s,
                                      int start, int before, int count) {
                showClearButton();
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing.
            }
        });
    }

    /**
     * Shows the clear (X) button.
     */

    private void showClearButton() {
        // Sets the Drawables (if any) to appear to the left of,
        // above, to the right of, and below the text.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            setCompoundDrawablesRelativeWithIntrinsicBounds
                    (null,                      // Start of text.
                            null,               // Top of text.
                            mClearButtonImage,  // End of text.
                            null);              // Below text.
        }
    }

    /**
     * Hides the clear button.
     */
    private void hideClearButton() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            setCompoundDrawablesRelativeWithIntrinsicBounds
                    (null,             // Start of text.
                            null,      // Top of text.
                            null,      // End of text.
                            null);     // Below text.
        }
    }
}