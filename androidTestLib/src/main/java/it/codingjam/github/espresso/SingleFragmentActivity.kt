/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.codingjam.github.espresso

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import android.widget.FrameLayout.LayoutParams
import androidx.navigation.NavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.get

class SingleFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val content = FrameLayout(this)
        content.layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
        content.id = R.id.container
        setContentView(content)
    }

    fun setFragment(graphId: Int, nodeId: Int, args: Bundle) {
        val navController = NavController(this)
        navController.navigatorProvider.addNavigator(FragmentNavigator(this, supportFragmentManager, 123))
        val navGraph = navController.navInflater.inflate(graphId)
        val node = navGraph[nodeId]
        val fragmentClass = (node as FragmentNavigator.Destination).fragmentClass

        val fragment = Fragment.instantiate(this, fragmentClass.canonicalName).apply {
            arguments = args
        }

        supportFragmentManager.beginTransaction()
                .add(R.id.container, fragment, "TEST")
                .commit()

    }
}
