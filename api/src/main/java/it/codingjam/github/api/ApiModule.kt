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

package it.codingjam.github.api

import dagger.Module
import dagger.Provides
import it.codingjam.github.api.util.RetrofitFactory.createService
import it.codingjam.github.core.GithubRepository
import okhttp3.HttpUrl
import javax.inject.Singleton

@Module
class ApiModule {
    @Singleton @Provides fun provideGithubService(): GithubService =
            createService(BuildConfig.DEBUG, HttpUrl.parse("https://api.github.com/")!!)

    @Provides @Singleton fun githubRepository(githubService: GithubService): GithubRepository = GithubRepositoryImpl(githubService)
}
