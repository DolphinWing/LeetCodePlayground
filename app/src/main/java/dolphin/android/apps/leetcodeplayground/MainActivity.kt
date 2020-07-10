package dolphin.android.apps.leetcodeplayground

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.material.Button
import androidx.ui.tooling.preview.Preview
import dolphin.android.apps.leetcodeplayground.ui.LeetCodePlaygroundTheme

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "LeetCode"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeetCodePlaygroundTheme {
                Column() {
                    Greeting("Android")
                    Button(onClick = {
                        val result = Solution().canArrange(intArrayOf(1, 2, 3, 4, 5, 6), 10)
                        Log.d(TAG, "result = $result")
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