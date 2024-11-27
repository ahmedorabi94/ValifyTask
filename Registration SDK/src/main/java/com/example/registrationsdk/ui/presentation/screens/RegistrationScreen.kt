package com.example.registrationsdk.ui.presentation.screens

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.registrationsdk.navigation.NavigationItem
import com.example.registrationsdk.ui.presentation.RegisterViewModel
import com.example.registrationsdk.ui.presentation.components.CustomTextField


@Preview(showBackground = true)
@Composable
fun RegistrationScreen(
    innerPadding: PaddingValues? = null,
    navController: NavHostController? = null,
    registerViewModel: RegisterViewModel = hiltViewModel()
) {

    val localFocusManager = LocalFocusManager.current
    val context = LocalContext.current


    val usernameMutable = remember { mutableStateOf("") }
    val phoneNumberMutable = remember { mutableStateOf("") }
    val emailMutable = remember { mutableStateOf("") }
    val passwordMutable = remember { mutableStateOf("") }

    val usernameErrorMutable = remember { mutableStateOf("") }
    val emailErrorMutable = remember { mutableStateOf("") }
    val phoneErrorMutable = remember { mutableStateOf("") }
    val passwordErrorMutable = remember { mutableStateOf("") }

    val permission = Manifest.permission.CAMERA
    val isPermissionGranted =  remember { mutableStateOf(false) }
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {isGranted ->
        isPermissionGranted.value = isGranted
        if (isGranted){
            registerViewModel.addUserInfo()
            navController?.navigate(NavigationItem.CaptureImage.route)
        }
    }

    isPermissionGranted.value = ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {

        Spacer(Modifier.height(20.dp))
        CustomTextField(
            usernameMutable,
            usernameErrorMutable,
            KeyboardActions(onNext = { localFocusManager.moveFocus(FocusDirection.Down) }),
            "Username",
            onChanged = {
                registerViewModel.state = registerViewModel.state.copy(userName = it)
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomTextField(
            phoneNumberMutable,
            phoneErrorMutable,
            KeyboardActions(onNext = { localFocusManager.moveFocus(FocusDirection.Down) }),
            "Phone Number",
            onChanged = {
                registerViewModel.state = registerViewModel.state.copy(phoneNumber = it)
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomTextField(
            emailMutable,
            emailErrorMutable,
            KeyboardActions(onNext = { localFocusManager.moveFocus(FocusDirection.Down) }),
            "Email",
            onChanged = {
                registerViewModel.state = registerViewModel.state.copy(email = it)
            }

        )
        Spacer(Modifier.height(8.dp))
        CustomTextField(
            passwordMutable,
            passwordErrorMutable,
            KeyboardActions(onNext = { localFocusManager.moveFocus(FocusDirection.Down) }),
            "Password",
            onChanged = {
                registerViewModel.state = registerViewModel.state.copy(password = it)
            }
        )

        Button(
            onClick = {


                if (registerViewModel.saveData()) {
                    if (registerViewModel.state.userNameError != null)
                        usernameErrorMutable.value = registerViewModel.state.userNameError ?: ""
                    else usernameErrorMutable.value = ""
                    if (registerViewModel.state.phoneNumberError != null)
                        phoneErrorMutable.value = registerViewModel.state.phoneNumberError ?: ""
                    else phoneErrorMutable.value = ""

                    if (registerViewModel.state.emailError != null)
                        emailErrorMutable.value = registerViewModel.state.emailError ?: ""
                    else emailErrorMutable.value = ""

                    if (registerViewModel.state.passwordError != null)
                        passwordErrorMutable.value = registerViewModel.state.passwordError ?: ""
                    else passwordErrorMutable.value = ""
                } else {

                    if (!isPermissionGranted.value) {
                        permissionLauncher.launch(permission)
                    } else {
                        registerViewModel.addUserInfo()
                         navController?.navigate(NavigationItem.CaptureImage.route)
                    }

                }

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
                .padding(top = 30.dp, start = 30.dp, end = 30.dp)
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