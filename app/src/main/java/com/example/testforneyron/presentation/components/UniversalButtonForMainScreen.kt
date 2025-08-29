package com.example.testforneyron.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testforneyron.R

@Composable
fun UniversalButtonForMainScreen(
    text: String = "",
    additionalText: String = "",
    actionText: String = "",
    textColor: Color = Color.Gray,
    isHasImage: Boolean = false,
    isHasAction: Boolean = false,
    isArrow: Boolean = true,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .background(
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(15.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 20.dp, bottom = 20.dp, end = 10.dp)
        ) {

            if (!isHasImage) {
                Column(modifier = Modifier.align(Alignment.CenterStart)) {

                    Text(text = text, color = textColor)

                    if (isHasAction) {
                        Text("")
                    }
                }
            } else {
                Image(
                    painter = painterResource(id = R.drawable.sber),
                    contentDescription = "изображение для магазина",
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .size(30.dp)
                        .clip(RoundedCornerShape(50.dp)),
                    contentScale = ContentScale.Crop,
                )
            }

            Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                Column {

                    Text(
                        text = additionalText,
                        color = Color.White,
                        maxLines = 1,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )

                    if (isHasAction) {
                        Text(
                            text = actionText,
                            color = Color.Red,
                            maxLines = 1,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }

                if (isArrow) {
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "ArrowRight",
                        tint = Color.White
                    )
                } else {
                    var booleanForSwitch by remember { mutableStateOf(true) }
                    Switch(
                        modifier = Modifier.height(20.dp),
                        checked = booleanForSwitch,
                        onCheckedChange = { booleanForSwitch = !booleanForSwitch },
                        colors = SwitchColors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = Color.Red,
                            checkedBorderColor = Color.Black,
                            checkedIconColor = Color.White,
                            uncheckedThumbColor = Color.White,
                            uncheckedTrackColor = Color.Gray,
                            uncheckedBorderColor = Color.Black,
                            uncheckedIconColor = Color.Gray,
                            disabledCheckedThumbColor = Color.Gray,
                            disabledCheckedTrackColor = Color.Gray,
                            disabledCheckedBorderColor = Color.Gray,
                            disabledCheckedIconColor = Color.Gray,
                            disabledUncheckedThumbColor = Color.Gray,
                            disabledUncheckedTrackColor = Color.Gray,
                            disabledUncheckedBorderColor = Color.Gray,
                            disabledUncheckedIconColor = Color.Gray
                        )
                    )
                }
            }
        }
    }
}