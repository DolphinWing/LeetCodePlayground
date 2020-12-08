package dolphin.android.apps.leetcodeplayground

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import dolphin.android.apps.leetcodeplayground.ui.LeetCodePlaygroundTheme

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "LeetCode"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeetCodePlaygroundTheme {
                Column {
                    Greeting("Android")
                    Button(onClick = {
                        val result = Weekly198Solution().closestToTarget(intArrayOf(9, 12, 3, 7, 15), 5)
                        Log.d(TAG, ">> result = $result")
                    }) {
                        Text("LeetCode")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LeetCodePlaygroundTheme {
        Greeting("Android")
    }
}