package com.example.valifytask.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.valifytask.R
import com.example.valifytask.navigation.NavigationItem


@Preview(showBackground = true)
@Composable
fun RegistrationScreen(
    innerPadding: PaddingValues? = null,
    navController: NavHostController? = null,
    registerViewModel: RegisterViewModel = hiltViewModel()
) {

    val localFocusManager = LocalFocusManager.current
    val usernameMutable = remember { mutableStateOf("") }
    val phoneNumberMutable = remember { mutableStateOf("") }
    val emailMutable = remember { mutableStateOf("") }
    val passwordMutable = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {


        Spacer(Modifier.height(20.dp))
        TextField(
            value = usernameMutable.value,
            onValueChange = {
                usernameMutable.value = it
                registerViewModel.useInfo = registerViewModel.useInfo.copy(userName = it)

            },
            trailingIcon = {

            },
            placeholder = {
                Text(
                    text = "Username",
                    color = colorResource(id = R.color.white),
                    fontSize = 17.sp,
                    fontFamily = FontFamily.SansSerif
                )
            },
            keyboardActions = KeyboardActions(onNext = {
                localFocusManager.moveFocus(FocusDirection.Down)
            }),
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
                color = colorResource(id = R.color.black),
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif
            ),
            shape = RoundedCornerShape(6.dp),
            singleLine = true,

            )

        Spacer(Modifier.height(8.dp))
        TextField(
            value = phoneNumberMutable.value,
            onValueChange = {
                phoneNumberMutable.value = it
                registerViewModel.useInfo = registerViewModel.useInfo.copy(phoneNumber = it)
            },
            trailingIcon = {

            },
            placeholder = {
                Text(
                    text = "Phone Number",
                    color = colorResource(id = R.color.white),
                    fontSize = 17.sp,
                    fontFamily = FontFamily.SansSerif
                )
            },
            keyboardActions = KeyboardActions(onNext = {
                localFocusManager.moveFocus(FocusDirection.Down)
            }),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Phone,
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
                color = colorResource(id = R.color.black),
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif
            ),
            shape = RoundedCornerShape(6.dp),
            singleLine = true,

            )

        Spacer(Modifier.height(8.dp))
        TextField(
            value = emailMutable.value,
            onValueChange = {
                emailMutable.value = it
                registerViewModel.useInfo = registerViewModel.useInfo.copy(email = it)

            },
            trailingIcon = {

            },
            placeholder = {
                Text(
                    text = "Email",
                    color = colorResource(id = R.color.white),
                    fontSize = 17.sp,
                    fontFamily = FontFamily.SansSerif
                )
            },
            keyboardActions = KeyboardActions(onNext = {
                localFocusManager.moveFocus(FocusDirection.Down)
            }),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Email,
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
                color = colorResource(id = R.color.black),
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif
            ),
            shape = RoundedCornerShape(6.dp),
            singleLine = true,

            )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = passwordMutable.value,
            onValueChange = {
                passwordMutable.value = it

            },
            trailingIcon = {

            },
            placeholder = {
                Text(
                    text = "Password",
                    color = colorResource(id = R.color.white),
                    fontSize = 17.sp,
                    fontFamily = FontFamily.SansSerif
                )
            },
            keyboardActions = KeyboardActions(onNext = {
                localFocusManager.moveFocus(FocusDirection.Down)
            }),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Password,
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
                color = colorResource(id = R.color.black),
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif
            ),
            shape = RoundedCornerShape(6.dp),
            singleLine = true,

            )
        Spacer(Modifier.height(8.dp))


        Button(
            onClick = {

                registerViewModel.addUserInfo()
                navController?.navigate(NavigationItem.CaptureImage.route)

            },
            shape = RoundedCornerShape(14.dp),
            contentPadding = PaddingValues(
                top = 15.dp,
                bottom = 15.dp,
            ),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black, containerColor = Color.White
            ), modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 12.dp, end = 12.dp)
        ) {
            Text(
                text = "Save",
                color = Color.Black,
                fontWeight = FontWeight.W800,
                fontSize = 16.sp, modifier = Modifier
            )
        }
    }

}