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

package it.codingjam.github.di

import dagger.Module
import dagger.Provides
import it.codingjam.github.AndroidNavigationController
import it.codingjam.github.NavigationController
import kotlinx.coroutines.experimental.CoroutineDispatcher
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.IO
import javax.inject.Singleton

@Module class AppModule {
    @Provides @Singleton fun navigationController(androidNavigationController: AndroidNavigationController): NavigationController = androidNavigationController

    @Provides @Singleton fun dispatcher(): CoroutineDispatcher = Dispatchers.IO
}
