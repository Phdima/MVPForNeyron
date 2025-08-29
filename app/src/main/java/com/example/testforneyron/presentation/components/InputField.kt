package com.example.testforneyron.presentation.components

import androidx.compose.foundation.border
import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.testforneyron.presentation.viewModels.UserFormViewModel
import kotlin.text.Regex


@Composable
fun InputField(viewModel: UserFormViewModel) {
    val formState = viewModel.formState

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Поле для номера участника
        OutlinedTextField(
            value = formState.participantNumber,
            onValueChange = {
                if (it.all { char -> char.isDigit() } && it.length <= 16) {
                    viewModel.updateParticipantNumber(it)
                }
            },
            label = {
                if (formState.participantNumber.isEmpty() && !formState.isFocusedParticipant) {
                    Text("Номер участника")
                }
            },
            isError = formState.participantNumberError,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    viewModel.updateFocusParticipant(focusState.isFocused)
                    if (!focusState.isFocused && formState.isFocusedParticipant){
                        viewModel.updateFocusParticipant(false)
                        viewModel.updateParticipantNumber(formState.participantNumber)
                    }
                },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            supportingText = {
                if (formState.participantNumberError) {
                    Text("Некорректные данные", color = MaterialTheme.colorScheme.error)
                } else {
                    Text("Номер из 16 цифр, который вы получили от банка")
                }
            },
            maxLines = 1,
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedIndicatorColor = if (formState.participantNumberError) {
                    Color.Red
                } else {
                    Color.Transparent
                },
                errorTextColor = Color.Red,
                focusedIndicatorColor = Color.Transparent,
                errorSupportingTextColor = Color.Red,
                errorLabelColor = Color.Red,
                errorIndicatorColor = Color.Red
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Поле для кода
        OutlinedTextField(
            value = formState.code,
            onValueChange = { viewModel.updateCode(it) },
            label = {
                if (formState.code.isEmpty() && !formState.isFocusedCode) {
                    Text("Код")
                }
            },
            isError = formState.codeError,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    viewModel.updateFocusCode(focusState.isFocused)
                    if (!focusState.isFocused && formState.isFocusedCode){
                        viewModel.updateFocusCode(false)
                        viewModel.updateCode(formState.code)
                    }
                },
            supportingText = {
                if (formState.codeError) {
                    Text("Поле не может быть пустым", color = MaterialTheme.colorScheme.error)
                } else {
                    Text("Код который получили от банка")
                }
            },
            maxLines = 1,
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedIndicatorColor = if (formState.codeError) {
                    Color.Red
                } else {
                    Color.Transparent
                },
                errorIndicatorColor = Color.Red,
                errorLabelColor = Color.Red,
                errorTextColor = Color.Red,
                errorSupportingTextColor = Color.Red,
                focusedIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Поле для имени
        OutlinedTextField(
            value = formState.firstName,
            onValueChange = { viewModel.updateFirstName(it) },
            label = {
                if (formState.firstName.isEmpty() && !formState.isFocusedFirstName) {
                    Text("Имя")
                }
            },
            isError = formState.firstNameError,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    viewModel.updateFocusFirstName(focusState.isFocused)
                    if (!focusState.isFocused && formState.isFocusedFirstName){
                        viewModel.updateFocusFirstName(false)
                        viewModel.updateFirstName(formState.firstName)
                    }
                },
            supportingText = {
                if (formState.firstNameError) {
                    Text("Поле не может быть пустым", color = MaterialTheme.colorScheme.error)
                } else {
                    Text("Имя (на латинице, как в загран паспорте)")
                }
            },
            maxLines = 1,
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedIndicatorColor = if (formState.firstNameError) {
                    Color.Red
                } else {
                    Color.Transparent
                },
                errorTextColor = Color.Red,
                errorLabelColor = Color.Red,
                errorIndicatorColor = Color.Red,
                focusedIndicatorColor = Color.Transparent,
                errorSupportingTextColor = Color.Red
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Поле для фамилии
        OutlinedTextField(
            value = formState.lastName,
            onValueChange = { viewModel.updateLastName(it) },
            label = {
                if (formState.lastName.isEmpty() && !formState.isFocusedLastName) {
                    Text("Фамилия")
                }
            },
            isError = formState.lastNameError,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    viewModel.updateFocusLastName(focusState.isFocused)
                    if (!focusState.isFocused && formState.isFocusedLastName){
                        viewModel.updateFocusLastName(false)
                        viewModel.updateLastName(formState.lastName)
                    }
                },
            supportingText = {
                if (formState.lastNameError) {
                    Text("Поле не может быть пустым", color = MaterialTheme.colorScheme.error)
                } else {
                    Text("Фамилия (на латинице, как в загран паспорте)")
                }
            },
            maxLines = 1,
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedIndicatorColor = if (formState.lastNameError) {
                    Color.Red
                } else {
                    Color.Transparent
                },
                errorTextColor = Color.Red,
                errorLabelColor = Color.Red,
                focusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Red,
                errorSupportingTextColor = Color.Red
            )
        )
    }
}

