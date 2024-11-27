package com.example.valifytask.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.valifytask.R


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("Range")
@Composable
fun CustomTextField(
    fieldMutable: MutableState<String>,
    fieldErrorMutable: MutableState<String>,
    keyBoardAction: KeyboardActions,
    hintStr: String,
    onChanged: (String) -> Unit,
    paddingHorizontal: Int = 16
) {


    Column(modifier = Modifier.padding(start = paddingHorizontal.dp, end = paddingHorizontal.dp)) {

        TextField(
            value = fieldMutable.value,
            onValueChange = {
                fieldMutable.value = it
                fieldErrorMutable.value = ""
                onChanged.invoke(it)
            },
            trailingIcon = {
                if (fieldErrorMutable.value.isNotEmpty())
                    Icon(Icons.Filled.Clear, "error", tint = MaterialTheme.colorScheme.error)
            },
            placeholder = {
                Text(
                    text = hintStr,
                    color = colorResource(id = R.color.white),
                    fontSize = 17.sp,
                    fontFamily = FontFamily.SansSerif
                )
            },
            keyboardActions = keyBoardAction,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp)
                .defaultMinSize(minHeight = 44.dp)
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.white),
                    shape = RoundedCornerShape(6.dp)
                )
                .scale(scaleY = 0.9F, scaleX = 1F),
            textStyle = TextStyle(
                color = colorResource(id = R.color.white),
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif
            ),
            shape = RoundedCornerShape(6.dp),
            singleLine = true,

            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                cursorColor = Color.White,
            )
        )

        if (fieldErrorMutable.value.isNotEmpty()) {
            Text(
                text = fieldErrorMutable.value,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

    }
}